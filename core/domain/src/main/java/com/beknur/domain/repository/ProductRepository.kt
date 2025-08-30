package com.beknur.domain.repository

import com.beknur.domain.model.FilterParams
import com.beknur.domain.model.Product
import com.beknur.domain.util.Resource
import kotlinx.coroutines.flow.Flow

interface ProductRepository {
	suspend fun getProductsByCategory(productCategory: String): List<Product>
	suspend fun getFiltersForCategory(filterCategory: String): Resource<FilterParams>
}


