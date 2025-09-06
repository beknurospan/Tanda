package com.beknur.payment

sealed interface PaymentUiEvent {
	data object OnFillNameClick:PaymentUiEvent
	data object ChangeBottomSheetState:PaymentUiEvent
	data object OnChangeAddressClick:PaymentUiEvent
	data object OnChangeTimeClick:PaymentUiEvent
	data object OnAddCardClick:PaymentUiEvent
	data class OnSaveNameClick(val name: String):PaymentUiEvent
	data class OnSaveTimeClick(val time: String):PaymentUiEvent
	data class OnAdditionalInfoChange(val info: String): PaymentUiEvent
	data class OnPayment(val totalPrice: Double):PaymentUiEvent
}