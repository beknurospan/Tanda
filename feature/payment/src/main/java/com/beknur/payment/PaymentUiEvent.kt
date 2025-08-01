package com.beknur.payment

sealed interface PaymentUiEvent {
	data object OnChangeAddressClick:PaymentUiEvent
	data object OnAddCardClick:PaymentUiEvent
}