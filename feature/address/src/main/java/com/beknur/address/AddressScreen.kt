package com.beknur.address

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.beknur.address.screens.AddressHolderScreen
import com.beknur.address.screens.AddressScreenFill
import com.beknur.domain.model.MySearchResult


@Preview
@Composable
fun AddressScreenPreview() {
	AddressScreen(
		viewState = AddressViewState(
			false,
			showBottomSheet = false,
			addresses = emptyList(),
			searchQuery = "",
			streetNumber = "",
			searchQueryResult = listOf(MySearchResult("", "")),
			address = "",
			apartment = "",
			entrance = "",
			floor = "",
			clickedItemId = -1,
			showAddressConfigDialog = false
		), {})
}

@Composable
fun AddressScreenRoute(viewModel: AddressViewModel) {
	val viewState by viewModel.viewState.collectAsStateWithLifecycle()
	AddressScreen(viewState, viewModel::handleEvent)
}

@Composable
fun AddressScreen(
	viewState: AddressViewState,
	sendUiEvent: (AddressUiEvent) -> Unit
) {
	val isAddressExist = viewState.addresses.isEmpty()
	if (viewState.isFillMode) {
		AddressScreenFill(
			onAddressClick = { sendUiEvent(AddressUiEvent.OnAddressClick) },
			address = viewState.address,
			floor = viewState.floor,
			entrance = viewState.entrance,
			apartment = viewState.apartment,
			showBottomSheet = viewState.showBottomSheet,
			searchQuery = viewState.searchQuery,
			streetNumber = viewState.streetNumber,
			searchQueryResult = viewState.searchQueryResult,
			onApartmentChange = { sendUiEvent(AddressUiEvent.OnApartmentChange(it)) },
			onFloorChange = { sendUiEvent(AddressUiEvent.OnFloorChange(it)) },
			onEntranceChange = { sendUiEvent(AddressUiEvent.OnEntranceChange(it)) },
			onDismissRequest = { sendUiEvent(AddressUiEvent.OnDismissRequest) },
			onSearchQueryChange = { sendUiEvent(AddressUiEvent.OnSearchQueryChange(it)) },
			onResultClick = { sendUiEvent(AddressUiEvent.OnResultClick(it)) },
			onConfirmAddress = { sendUiEvent(AddressUiEvent.OnConfirmAddress(it)) },
		)
	} else {
		AddressHolderScreen(
			isAddressExist = isAddressExist,
			addressList = viewState.addresses,
			showDialog = viewState.showAddressConfigDialog,
			onAddButtonClick = { sendUiEvent(AddressUiEvent.OnAddClick) },
			onItemClick = { sendUiEvent(AddressUiEvent.OnItemClick(it)) },
			onActionEditClick = { sendUiEvent(AddressUiEvent.OnActionEditClick(viewState.clickedItemId)) },
			onActionDeleteClick = { sendUiEvent(AddressUiEvent.OnActionDeleteClick(viewState.clickedItemId)) },
			onActionMakePrimaryClick = { sendUiEvent(AddressUiEvent.OnActionMakePrimaryClick(viewState.clickedItemId)) },
			onActionCancelClick = { sendUiEvent(AddressUiEvent.OnActionCancelClick(viewState.clickedItemId)) },
		)
	}
}



