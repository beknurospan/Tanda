package com.beknur.catalog

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.beknur.navigation.NavigationManager
import com.beknur.navigation.Screen
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class CatalogViewModel(
	private val navigationManager: NavigationManager
):ViewModel() {

	private val _viewState= MutableStateFlow<CatalogViewState>(CatalogViewState(""))
	val viewState=_viewState.asStateFlow()


	fun handleEvent(event: CatalogUiEvent){
		when(event){
			is CatalogUiEvent.OnGenderChanged -> {}
			is CatalogUiEvent.OnProductCategoryClick -> onProductClick(event.code,event.gender)
			CatalogUiEvent.OnSearchClick -> {}
		}
	}
	fun onProductClick(code:String,gender:String){
		viewModelScope.launch {
			navigationManager.navigate(Screen.Product(code,gender))
		}
	}
}