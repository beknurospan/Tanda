package com.beknur.data.mappers

import android.util.Log.e
import com.beknur.database.model.AddressEntity
import com.beknur.database.model.CartEntity
import com.beknur.domain.model.Address
import com.beknur.domain.model.CartProduct
import com.beknur.domain.model.FilterAttribute
import com.beknur.domain.model.FilterParams
import com.beknur.domain.model.MySearchResult
import com.beknur.domain.model.Params
import com.beknur.domain.model.PriceRange
import com.beknur.domain.model.Product
import com.beknur.domain.model.ProductType
import com.beknur.domain.model.ProductVariants
import com.beknur.network.model.FilterAttributeDto
import com.beknur.network.model.FilterParamsDto
import com.beknur.network.model.MySearchResultDto
import com.beknur.network.model.ParamDto
import com.beknur.network.model.PriceRangeDto
import com.beknur.network.model.ProductCategoryDto
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
fun ProductCategoryDto.toProduct()=
	Product(
		productId = productId,
		skuId = skuId,
		price = price,
		sizes = sizes,
		rating = rating,
		name = name,
		img = img,
		brandName = brandName
	)


fun FilterParamsDto.toFilterParams() =
	FilterParams(
		category = category ?: throw IllegalArgumentException("Category is required"),
		sizeAttribute = sizeAttribute?.toFilterAttribute()
			?: throw IllegalArgumentException("Size attribute is required"),
		brandAttribute = brandAttribute?.toFilterAttribute()
			?: throw IllegalArgumentException("Brand attribute is required"),
		priceRange = priceRangeDto?.toPriceRange()
			?: throw IllegalArgumentException("Price range is required"),
		filterAttributes = filterAttributes?.map { it.toFilterAttribute() } ?: emptyList(),
	)


fun FilterAttributeDto.toFilterAttribute()=
	FilterAttribute(
		id = id,
		nameAttribute = name,
		params = parameters.map { it.toParams() }.toSet()
	)
fun ParamDto.toParams()=
	Params(
		id = id,
		name = name
	)
fun PriceRangeDto.toPriceRange()=
	PriceRange(
		min = min,
		max = max
	)

fun FilterAttribute.toFilterAttributeDto()=
	FilterAttributeDto(
		id = id,
		name = nameAttribute,
		parameters = params.map { it.toParamDto() }
	)
fun Params.toParamDto()=
	ParamDto(
		id = id,
		name = name
	)
fun PriceRange.toPriceRangeDto()=
	PriceRangeDto(
		min = min,
		max = max
	)