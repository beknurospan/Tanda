package com.beknur.catalog

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.beknur.catalog.data.ProductCategory
import com.beknur.catalog.data.ProductCategoryInfo
import com.beknur.navigation.NavigationManager
import com.beknur.navigation.Screen
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class CatalogViewModel(
	private val navigationManager: NavigationManager
):ViewModel() {

	init {
		Log.d("viewmodel","каталог")
	}

	private val _viewState= MutableStateFlow<CatalogViewState>(CatalogViewState(ProductCategoryInfo.categoriesMen,1))
	val viewState=_viewState.asStateFlow()


	fun handleEvent(event: CatalogUiEvent){
		when(event){
			is CatalogUiEvent.OnGenderChanged -> onGenderChanged(event.index)
			is CatalogUiEvent.OnProductCategoryClick -> onProductClick(event.code,event.gender)
			CatalogUiEvent.OnSearchClick -> onSearchClick()
		}
	}
	fun onProductClick(code:String,gender:String){
		viewModelScope.launch {
			navigationManager.navigate(Screen.Product(code,gender))
		}
	}
	fun onGenderChanged(index:Int){
		_viewState.update {
			it.copy(selectedIndex = index)
		}
	}
	fun onSearchClick(){
		viewModelScope.launch {
			Log.d("nav","nn")
			navigationManager.navigate(Screen.Search)
		}
	}
}