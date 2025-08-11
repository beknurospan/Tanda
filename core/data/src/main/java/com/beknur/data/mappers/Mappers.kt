package com.beknur.data.mappers

import com.beknur.database.model.AddressEntity
import com.beknur.database.model.CartEntity
import com.beknur.domain.model.Address
import com.beknur.domain.model.CartProduct
import com.beknur.domain.model.MySearchResult
import com.beknur.domain.model.ProductType
import com.beknur.domain.model.ProductVariants
import com.beknur.network.model.MySearchResultDto
import com.beknur.network.model.ProductDto
import com.beknur.network.model.ProductTypesDto
import com.beknur.network.model.ProductVariantDto

fun CartEntity.toCartProduct()=
	CartProduct(
		productId = productId,
		skuId=skuId,
		isSelected = isSelected,
		detailText = detailText,
		brandName = brandName,
		size = size,
		pricePerOne = pricePerOne,
		count = count
	)
fun CartProduct.toCartEntity()=
	CartEntity(
		productId = productId,
		skuId=skuId,
		isSelected = isSelected,
		detailText = detailText,
		brandName = brandName,
		size = size,
		pricePerOne = pricePerOne,
		count = count
	)

fun ProductTypesDto.toProductType()=
	ProductType(
		variants = variants.map { it.toProductVariants() }
	)

fun ProductVariantDto.toProductVariants()=
	ProductVariants(
		skuId=skuId,
		size=size
	)
fun ProductDto.toCartProduct()=
	CartProduct(
		isSelected = true,
		productId = productId,
		skuId = skuId,
		detailText = detailText,
		brandName = brandName,
		size = size,
		pricePerOne = pricePerOne
	)
fun MySearchResultDto.toMySearchResult()=
	MySearchResult(
		name= addressName ?:"",
		fullName= fullName ?:""
	)

fun AddressEntity.toAddress()=
	Address(
		id=id,
		address = address,
		apartment = apartment,
		entrance = entrance,
		floor = floor
	)

fun Address.toAddressEntity()=
	AddressEntity(
		address = address,
		apartment = apartment,
		entrance = entrance,
		floor = floor
	)