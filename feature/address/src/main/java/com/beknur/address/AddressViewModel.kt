package com.beknur.address

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.beknur.domain.model.Address
import com.beknur.domain.model.MySearchResult
import com.beknur.domain.repository.AddressRepository
import com.beknur.domain.repository.UserDataRepository
import com.beknur.navigation.NavigationManager
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class AddressViewModel(
	private val navigationManager: NavigationManager,
	private val userDataRepository: UserDataRepository,
	private val addressRepository: AddressRepository
) : ViewModel() {

	private val _viewState = MutableStateFlow<AddressViewState>(
		AddressViewState(
			isFillMode = false,
			showBottomSheet = false,
			addresses = emptyList(),
			searchQuery = "",
			searchQueryResult = emptyList(),
			address = "",
			apartment = "",
			entrance = "",
			floor = "",
			streetNumber = "Улица и номер дома",
			clickedItemId = -1,
			showAddressConfigDialog = false
		)
	)
	val viewState = _viewState.asStateFlow()
	private val queryFlow = MutableStateFlow("")

	init {
		observeQuery()
		observeAddresses()
	}

	fun handleEvent(event: AddressUiEvent) {
		when (event) {
			AddressUiEvent.OnAddClick -> onAddClick()
			AddressUiEvent.OnAddressClick -> onAddressClick()
			AddressUiEvent.OnDismissRequest -> onDismissRequest()
			is AddressUiEvent.OnApartmentChange -> onApartmentChange(event.apartment)
			is AddressUiEvent.OnEntranceChange -> onEntranceChange(event.entrance)
			is AddressUiEvent.OnFloorChange -> onFloorChange(event.floor)
			is AddressUiEvent.OnResultClick -> onResultClick(event.result)
			is AddressUiEvent.OnSearchQueryChange -> onSearchQueryChange(event.query)
			is AddressUiEvent.OnConfirmAddress -> onConfirmAddress(event.address)
			is AddressUiEvent.OnItemClick -> onItemClick(event.itemId)
			is AddressUiEvent.OnActionCancelClick -> onActionCancelClick()
			is AddressUiEvent.OnActionDeleteClick -> onActionDeleteClick(event.itemId)
			is AddressUiEvent.OnActionEditClick -> onActionEditClick(event.itemId)
			is AddressUiEvent.OnActionMakePrimaryClick -> onActionMakePrimaryClick(event.itemId)
		}
	}

	private fun onActionMakePrimaryClick(id:Int){
		viewModelScope.launch {
			addressRepository.setChosenAndUnchooseAll(id)
			_viewState.update {
				it.copy(showAddressConfigDialog = false, clickedItemId = -1)
			}
		}


	}

	private fun onActionCancelClick() {
		_viewState.update {
			it.copy(showAddressConfigDialog = false, clickedItemId = -1)
		}
	}

	private fun onActionDeleteClick(id: Int) {
		viewModelScope.launch {
			addressRepository.deleteAddress(id)
			_viewState.update {
				it.copy(showAddressConfigDialog = false, clickedItemId = -1)
			}
		}
	}

	private fun onActionEditClick(id: Int) {
		viewModelScope.launch {
			val address = addressRepository.getAddressById(id)
			_viewState.update {
				it.copy(
					isFillMode = true,
					apartment = address.apartment,
					entrance = address.entrance,
					floor = address.floor,
					address = address.address
				)
			}
		}

	}

	private fun onItemClick(itemId: Int) {
		_viewState.update {
			it.copy(showAddressConfigDialog = true, clickedItemId = itemId)
		}
	}

	private fun onApartmentChange(apartment: String) {
		_viewState.update {
			it.copy(apartment = apartment)
		}
	}

	private fun onConfirmAddress(address: Address) {
		viewModelScope.launch {
			val id=_viewState.value.clickedItemId
			if (id>=0){
				addressRepository.updateAddressById(id,address.address,address.entrance,address.floor,address.apartment)
			}else{
				userDataRepository.updateChosenAddress(address)
				addressRepository.addAndSetChosen(address)
			}
			navigationManager.navigateBack()
		}
	}

	private fun onEntranceChange(entrance: String) {
		_viewState.update {
			it.copy(entrance = entrance)
		}
	}

	private fun onFloorChange(floor: String) {
		_viewState.update {
			it.copy(floor = floor)
		}
	}

	private fun onResultClick(result: MySearchResult) {
		_viewState.update {
			it.copy(
				address = result.name,
				showBottomSheet = false
			)
		}
	}

	@OptIn(FlowPreview::class)
	private fun onSearchQueryChange(query: String) {
		_viewState.update {
			it.copy(searchQuery = query)
		}

		queryFlow.value = query

	}

	@OptIn(FlowPreview::class)
	private fun observeQuery() {
		viewModelScope.launch {
			queryFlow
				.filter { it.length >= 3 }
				.debounce {
					500
				}
				.distinctUntilChanged()
				.collectLatest { query ->
					val searchResult = userDataRepository.getSearchResult(query)
					_viewState.update {
						it.copy(searchQueryResult = searchResult)
					}
				}
		}
	}

	private fun observeAddresses() {
		viewModelScope.launch {
			addressRepository.getAddresses().collectLatest { addresses ->
				_viewState.update {
					it.copy(addresses = addresses)
				}
			}
		}
	}

	private fun onDismissRequest() {
		_viewState.update {
			it.copy(showBottomSheet = false)
		}
	}

	private fun onAddClick() {
		_viewState.update {
			it.copy(isFillMode = true)
		}
	}

	private fun onAddressClick() {
		_viewState.update {
			it.copy(showBottomSheet = true)
		}
	}
}