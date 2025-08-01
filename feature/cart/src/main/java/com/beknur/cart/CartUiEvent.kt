package com.beknur.cart

sealed interface CartUiEvent {
	data object OnPayButtonClick:CartUiEvent
	data object OnSelectAllClick:CartUiEvent
	data object OnTrashClick:CartUiEvent
	data class OnAddProduct(val id:Int):CartUiEvent
	data class OnDelProduct(val id:Int):CartUiEvent
	data class OnSelectProductClick(val id: Int):CartUiEvent
}