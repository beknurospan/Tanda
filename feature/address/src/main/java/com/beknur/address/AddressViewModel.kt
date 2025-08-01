package com.beknur.address

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class AddressViewModel:ViewModel() {

	private val _viewState= MutableStateFlow<AddressViewState>(AddressViewState(""))
	val viewState=_viewState.asStateFlow()


	fun handleEvent(event: AddressUiEvent){
		when(event){

			else -> {}
		}
	}
}