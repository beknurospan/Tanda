package com.beknur.productdetail

import com.beknur.domain.model.ProductDetail
import com.beknur.domain.util.Loadable

data class ProductDetailViewState(
	val productDetail: Loadable<ProductDetail>,
	val selectedSize: Int? = null
)

