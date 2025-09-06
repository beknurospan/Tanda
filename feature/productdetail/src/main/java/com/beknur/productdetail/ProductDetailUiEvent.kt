package com.beknur.productdetail

sealed interface ProductDetailUiEvent {
	data class OnSizeSelected(val size: Int) : ProductDetailUiEvent
	data class OnAddCartClicked(val productId:Int,val skuId:Int) : ProductDetailUiEvent
	data object OnHeartClicked : ProductDetailUiEvent
}