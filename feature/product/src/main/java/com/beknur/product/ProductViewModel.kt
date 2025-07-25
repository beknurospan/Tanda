package com.beknur.product

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.beknur.navigation.NavigationManager
import com.beknur.navigation.Screen
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class ProductViewModel(
	private val navigationManager: NavigationManager
): ViewModel() {

	init {
		Log.d("viewmodel","prod")
	}

	private val _viewState= MutableStateFlow<ProductViewState>(ProductViewState(""))
	val viewState=_viewState.asStateFlow()


	fun handleEvent(event: ProductUiEvent){
		when(event){
			ProductUiEvent.OnProductSelected -> onProductSelected()
		}
	}
	fun onProductSelected(){
		viewModelScope.launch {
			navigationManager.navigate(Screen.ProductDetail)
		}
	}
}