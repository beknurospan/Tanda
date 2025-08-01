package com.beknur.domain.model

data class CartProduct(
	val productId:Int,
	val isSelected: Boolean,
	val detailText: String,
	val brandName: String,
	val size: String,
	val pricePerOne: Int,
	val sum: Int,
	val count: Int
)
