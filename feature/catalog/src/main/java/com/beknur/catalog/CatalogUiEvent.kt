package com.beknur.catalog

sealed interface CatalogUiEvent {
	data class OnProductCategoryClick(val code:String, val gender:String):CatalogUiEvent
	data class OnGenderChanged(val index:Int):CatalogUiEvent
	data object OnSearchClick:CatalogUiEvent
}