package com.beknur.profile

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.beknur.navigation.NavigationManager
import com.beknur.navigation.Screen
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class ProfileViewModel(
	private val navigationManager: NavigationManager
): ViewModel() {

	private val _viewState= MutableStateFlow<ProfileViewState>(ProfileViewState(""))
	val viewState=_viewState.asStateFlow()


	fun handleEvent(event: ProfileUiEvent){
		when(event){
			ProfileUiEvent.OnAboutAppClick -> onAboutAppClick()
			ProfileUiEvent.OnAddressClick -> onAddressClick()
			ProfileUiEvent.OnCardsClick -> onAddressClick()
			ProfileUiEvent.OnLogoutClick -> onLogoutClick()
			ProfileUiEvent.OnNotificationClick -> onNotificationClick()
			ProfileUiEvent.OnOrderClick -> onOrderClick()
			ProfileUiEvent.OnSupportClick -> onSupportClick()
		}

	}
	fun onAboutAppClick(){
		viewModelScope.launch {
			Log.d("deb","cli")
			navigationManager.navigate(Screen.AboutApp)
		}
	}
	fun onAddressClick(){
		viewModelScope.launch {
			navigationManager.navigate(Screen.Address)
		}
	}
	fun onCardsClick(){
		viewModelScope.launch {
			navigationManager.navigate(Screen.Cards)
		}
	}
	fun onLogoutClick(){

	}
	fun onNotificationClick(){
		viewModelScope.launch {
			navigationManager.navigate(Screen.Notifications)
		}
	}
	fun onOrderClick(){
		viewModelScope.launch {
			navigationManager.navigate(Screen.Orders)
		}
	}
	fun onSupportClick(){
		viewModelScope.launch {
			navigationManager.navigate(Screen.Support)
		}
	}
}