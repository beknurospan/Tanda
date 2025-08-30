package com.beknur.product

sealed interface ProductUiEvent {
	data object OnFilterClicked:ProductUiEvent
	data object OnSortClicked:ProductUiEvent
	data class OnProductSelected(val productId:Int,val skuId:Int):ProductUiEvent
	data class OnParameterClicked(val attributeId:Int,val paramId:Int):ProductUiEvent
	data object OnDissmiss:ProductUiEvent

}