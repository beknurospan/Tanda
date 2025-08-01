package com.beknur.payment

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.beknur.navigation.NavigationManager
import com.beknur.navigation.Screen
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class PaymentViewModel(private val navigationManager: NavigationManager):ViewModel() {

	private val _viewState= MutableStateFlow(PaymentViewState(""))
	val viewState=_viewState.asStateFlow()

	fun handleEvent(event: PaymentUiEvent){
		when(event){
			PaymentUiEvent.OnChangeAddressClick -> onChangeAddressClick()
			PaymentUiEvent.OnAddCardClick -> onAddCardClick()
		}
	}

	private fun onChangeAddressClick(){
		viewModelScope.launch {
			navigationManager.navigate(Screen.Address)
		}
	}
	private fun onAddCardClick(){
		viewModelScope.launch {
			navigationManager.navigate(Screen.Cards)
		}
	}

}