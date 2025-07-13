package com.beknur.profile

sealed interface ProfileUiEvent {
	data object OnOrderClick:ProfileUiEvent
	data object OnCardsClick:ProfileUiEvent
	data object OnAddressClick:ProfileUiEvent
	data object OnNotificationClick:ProfileUiEvent
	data object OnAboutAppClick:ProfileUiEvent
	data object OnSupportClick:ProfileUiEvent
	data object OnLogoutClick:ProfileUiEvent
}