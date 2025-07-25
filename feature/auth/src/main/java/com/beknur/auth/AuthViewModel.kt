package com.beknur.auth

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.beknur.domain.AuthUseCase
import com.beknur.navigation.NavigationManager
import com.beknur.navigation.Screen
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch


class AuthViewModel constructor(
	private val navigationManager: NavigationManager,
	private val authUseCase: AuthUseCase
):ViewModel() {

	init {
		Log.d("viewmodel","аутз")

	}

	private val _viewState= MutableStateFlow<AuthViewState>(AuthViewState("",false,"",""))
	val viewState=_viewState.asStateFlow()


	fun handleEvent(event: AuthUiEvent){
		when(event){
			AuthUiEvent.OnSendButtonClick -> onSendButtonClick()
			is AuthUiEvent.OnPhoneNumberChanged ->onPhoneNumberChanged(event.phoneNumber)
			is AuthUiEvent.OnCodeChanged -> onCodeChanged(event.code)
			AuthUiEvent.OnBackClick -> onBackClick()
		}
	}
	private fun onPhoneNumberChanged(number:String){
		val digitsOnly = number.filter { it.isDigit() }.take(10)
		_viewState.update { it.copy(phoneNumber = digitsOnly) }
	}
	private fun onSendButtonClick(){
		if (_viewState.value.isOtpMode){

			viewModelScope.launch {
				authUseCase.changeAuth()
				navigationManager.popUntilNavigate(Screen.Auth,Screen.Profile)
			}
		}else{
			_viewState.update { it.copy(isOtpMode = true) }
		}

	}
	private fun onCodeChanged(code:String){
		_viewState.update { it.copy(code = code) }
	}
	private fun onBackClick(){
		if (_viewState.value.isOtpMode){
			_viewState.update { it.copy(isOtpMode = false, code = "") }
		}else{
			viewModelScope.launch {
				navigationManager.backShowBottom(Screen.Auth)
			}
		}
	}
}