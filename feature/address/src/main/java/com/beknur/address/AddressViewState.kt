package com.beknur.address


import com.beknur.domain.model.Address
import com.beknur.domain.model.MySearchResult

data class AddressViewState(
	val isFillMode: Boolean,
	val addresses: List<Address> =emptyList(),
	val showBottomSheet: Boolean,
	val searchQuery: String,
	val searchQueryResult:List<MySearchResult>,
	val address: String,
	val apartment: String,
	val entrance: String,
	val floor: String,
	val streetNumber: String,
	val showAddressConfigDialog: Boolean,
	val clickedItemId:Int
)


