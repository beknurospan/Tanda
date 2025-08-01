package com.beknur.data.mappers

import com.beknur.database.model.CartEntity
import com.beknur.domain.model.CartProduct

fun CartEntity.toCartProduct()=
	CartProduct(
		productId = productId,
		isSelected = isSelected,
		detailText = detailText,
		brandName = brandName,
		size = size,
		pricePerOne = pricePerOne,
		sum = count*pricePerOne,
		count = count
	)
fun CartProduct.toCartEntity()=
	CartEntity(
		productId = productId,
		isSelected = isSelected,
		detailText = detailText,
		brandName = brandName,
		size = size,
		pricePerOne = pricePerOne,
		count = count
	)