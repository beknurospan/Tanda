package com.beknur.domain.model

data class Product(
	val productId: Int,
	val skuId: Int,
	val price: Int,
	val sizes: List<Int>,
	val rating: Double,
	val name: String,
	val brandName: String,
	val img: String
)



