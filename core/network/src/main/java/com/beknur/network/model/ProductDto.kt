package com.beknur.network.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ProductTypesDto(
	@SerialName("product_variants")
	val variants: List<ProductVariantDto>
)


@Serializable
data class ProductVariantDto(
	@SerialName("sku_id")
	val skuId: Int,
	@SerialName("size")
	val size: Int,
)


@Serializable
data class ProductDto(
	@SerialName("product_id")
	val productId: Int,

	@SerialName("sku_id")
	val skuId: Int,

	@SerialName("detail_text")
	val detailText: String,

	@SerialName("brand_name")
	val brandName: String,

	@SerialName("size")
	val size: String,

	@SerialName("price_per_one")
	val pricePerOne: Int,
)

@Serializable
data class ProductCategoryDto(
	val productId:Int,
	val skuId: Int,
	val price: Int,
	val sizes:List<Int>,
	val rating: Double,
	val name:String,
	val img:String,
	val brandName: String
)
