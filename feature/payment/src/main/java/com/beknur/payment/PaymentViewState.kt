package com.beknur.payment

import com.beknur.domain.model.Address

data class PaymentViewState(
	val name: String,
	val time: String,
	val showBottomSheet: Boolean,
	val chosenAddress: Address,
	val additionalAddressInfo: String,
	val sheetType: SheetType
)
