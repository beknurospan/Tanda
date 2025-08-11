package com.beknur.payment

import android.R.attr.name
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.beknur.domain.model.Address
import com.beknur.domain.repository.UserDataRepository
import com.beknur.navigation.NavigationManager
import com.beknur.navigation.Screen
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class PaymentViewModel(
	private val navigationManager: NavigationManager,
	private val userDataRepository: UserDataRepository
) : ViewModel() {

	private val _viewState = MutableStateFlow(
		PaymentViewState(
			"", "", false, sheetType = SheetType.NAME, chosenAddress = Address(
				address = "",
				apartment = "",
				entrance = "",
				floor = ""
			), additionalAddressInfo = ""
		)
	)
	val viewState = _viewState.asStateFlow()

	init {
		viewModelScope.launch {
			userDataRepository.getUserData().collect { userData ->
				_viewState.update {
					it.copy(
						name = userData.userName,
						time = userData.suitableTimeDelivery,
						chosenAddress = userData.chosenAddress,
					)
				}
			}
		}
	}


	fun handleEvent(event: PaymentUiEvent) {
		when (event) {
			PaymentUiEvent.OnChangeAddressClick -> onChangeAddressClick()
			PaymentUiEvent.OnChangeTimeClick -> onChangeTimeClick()
			PaymentUiEvent.OnAddCardClick -> onAddCardClick()
			PaymentUiEvent.OnFillNameClick -> onFillNameClick()
			PaymentUiEvent.ChangeBottomSheetState -> changeBottomSheetState()
			is PaymentUiEvent.OnSaveNameClick -> onSaveNameClick(event.name)
			is PaymentUiEvent.OnSaveTimeClick -> onSaveTimeClick(event.time)
			is PaymentUiEvent.OnAdditionalInfoChange -> onAdditionalInfoChange(event.info)
		}
	}


	private fun onAdditionalInfoChange(info: String) {
		_viewState.update {
			it.copy(additionalAddressInfo = info)
		}
	}

	private fun onSaveTimeClick(time: String) {
		viewModelScope.launch {
			userDataRepository.updateSuitableTimeDelivery(time)
			_viewState.update {
				it.copy(showBottomSheet = false)
			}
		}

	}

	private fun onSaveNameClick(name: String) {
		viewModelScope.launch {
			userDataRepository.updateUserName(name)
			_viewState.update {
				it.copy(showBottomSheet = false)
			}
		}

	}

	private fun onSaveAdditionalInfo(additionalInfo: String) {
		viewModelScope.launch {
			userDataRepository.updateAdditionalAddressInfo(additionalInfo)
		}
	}

	private fun onChangeTimeClick() {
		_viewState.update {
			it.copy(showBottomSheet = true, sheetType = SheetType.TIME)
		}
	}

	private fun changeBottomSheetState() {
		_viewState.update {
			it.copy(showBottomSheet = false)
		}
	}

	private fun onChangeAddressClick() {
		viewModelScope.launch {
			navigationManager.navigate(Screen.Address)
		}
	}

	private fun onFillNameClick() {
		_viewState.update {
			it.copy(showBottomSheet = true, sheetType = SheetType.NAME)
		}
	}

	private fun onAddCardClick() {
		viewModelScope.launch {
			navigationManager.navigate(Screen.Cards)
		}
	}

}