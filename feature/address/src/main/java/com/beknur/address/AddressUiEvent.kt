package com.beknur.address

import com.beknur.domain.model.Address
import com.beknur.domain.model.MySearchResult

sealed interface AddressUiEvent{
	data object OnAddClick: AddressUiEvent
	data object OnAddressClick: AddressUiEvent
	data object OnDismissRequest: AddressUiEvent
	data class OnSearchQueryChange(val query:String): AddressUiEvent
	data class OnEntranceChange(val entrance:String): AddressUiEvent
	data class OnFloorChange(val floor:String): AddressUiEvent
	data class OnApartmentChange(val apartment:String): AddressUiEvent
	data class OnResultClick(val result: MySearchResult): AddressUiEvent
	data class OnConfirmAddress(val address: Address): AddressUiEvent
	data class OnItemClick(val itemId: Int): AddressUiEvent
	data class OnActionEditClick(val itemId: Int): AddressUiEvent
	data class OnActionDeleteClick(val itemId: Int): AddressUiEvent
	data class OnActionCancelClick(val itemId: Int): AddressUiEvent
	data class OnActionMakePrimaryClick(val itemId: Int): AddressUiEvent
}


