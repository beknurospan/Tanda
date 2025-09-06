package com.beknur.domain.repository

import com.beknur.domain.model.FilterParams
import com.beknur.domain.model.Product
import com.beknur.domain.model.ProductCategory
import com.beknur.domain.model.ProductDetail
import com.beknur.domain.util.Resource
import kotlinx.coroutines.flow.Flow

interface ProductRepository {
	suspend fun getProductsByCategory(productCategory: String): List<ProductCategory>
	suspend fun getFiltersForCategory(filterCategory: String): Resource<FilterParams>
	suspend fun getProductDetail(id:Int,skuId:Int): Resource<ProductDetail>
	suspend fun getProduct(id:Int,skuId:Int): Resource<Product>
}


