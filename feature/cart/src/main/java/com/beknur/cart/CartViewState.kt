package com.beknur.cart


import com.beknur.domain.model.CartProduct

data class CartViewState(
	val products:List<CartProduct>,
	val isAllSelected:Boolean,
	val selectedCount:Int,
	val amount:Int
)
