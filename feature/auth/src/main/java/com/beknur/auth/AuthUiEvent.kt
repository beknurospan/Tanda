package com.beknur.auth

sealed interface AuthUiEvent {
	data object OnSendButtonClick:AuthUiEvent
	data class  OnPhoneNumberChanged(val phoneNumber:String):AuthUiEvent
	data class  OnCodeChanged(val code:String):AuthUiEvent
	data object  OnBackClick:AuthUiEvent
}