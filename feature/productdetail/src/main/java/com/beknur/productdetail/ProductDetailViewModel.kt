package com.beknur.productdetail

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.beknur.navigation.NavigationManager
import com.beknur.navigation.Screen
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class ProductDetailViewModel(
	private val navigationManager: NavigationManager
): ViewModel() {

	init {
		Log.d("viewmodel","detail")
	}

	private val _viewState= MutableStateFlow<ProductDetialViewState>(ProductDetialViewState(""))
	val viewState=_viewState.asStateFlow()


	fun handleEvent(event: ProductDetailUiEvent){

	}
	fun onProductSelected(){
		viewModelScope.launch {
			navigationManager.navigate(Screen.ProductDetail)
		}
	}
}