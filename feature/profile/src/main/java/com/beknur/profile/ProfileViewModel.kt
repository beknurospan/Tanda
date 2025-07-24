package com.beknur.profile

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.beknur.navigation.NavigationManager
import com.beknur.navigation.Screen
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class ProfileViewModel(
	private val navigationManager: NavigationManager
): ViewModel() {

	private val _viewState= MutableStateFlow<ProfileViewState>(ProfileViewState("","",false,LangParamsUI.RUS))
	val viewState=_viewState.asStateFlow()


	fun handleEvent(event: ProfileUiEvent){
		when(event){
			ProfileUiEvent.OnAboutAppClick -> onAboutAppClick()
			ProfileUiEvent.OnAddressClick -> onAddressClick()
			ProfileUiEvent.OnCardsClick -> onCardsClick()
			ProfileUiEvent.OnLogoutClick -> onLogoutClick()
			ProfileUiEvent.OnNotificationClick -> onNotificationClick()
			ProfileUiEvent.OnOrderClick -> onOrderClick()
			ProfileUiEvent.OnSupportClick -> onSupportClick()
			ProfileUiEvent.OnAuthClick -> onAuthClick()
			is ProfileUiEvent.OnLangChanged -> onLangChanged(event.selectedLang)
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
		_viewState.update { it.copy(isAuth = false) }
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
	fun onAuthClick(){
		viewModelScope.launch {
			navigationManager.navigate(Screen.Auth)
		}
	}
	fun onLangChanged(selectedLang:LangParamsUI){
		when(selectedLang){
			LangParamsUI.KZ -> _viewState.update { it.copy(currentLang = LangParamsUI.KZ) }
			LangParamsUI.RUS -> _viewState.update { it.copy(currentLang = LangParamsUI.RUS) }
		}
	}
}