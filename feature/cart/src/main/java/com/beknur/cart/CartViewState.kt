package com.beknur.cart


import com.beknur.domain.model.CartProduct
import com.beknur.domain.model.ProductVariants

data class CartViewState(
	val products:List<CartProduct>,
	val isAllSelected:Boolean,
	val selectedCount:Int,
	val amount:Int,
	val openedProductId:Int,
	val showBottomSheet:Boolean,
	val productVariants: Loadable<List<ProductVariants>> = Loadable.Idle
)



sealed class Loadable<out T> {
	object Idle : Loadable<Nothing>()
	object Loading : Loadable<Nothing>()
	data class Success<T>(val data: T) : Loadable<T>()
	data class Error(val message: String) : Loadable<Nothing>()
}


