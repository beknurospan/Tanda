package com.beknur.data.repository

import com.beknur.data.mappers.toFilterParams
import com.beknur.data.mappers.toProduct
import com.beknur.domain.model.FilterParams
import com.beknur.domain.model.Product
import com.beknur.domain.repository.ProductRepository
import com.beknur.domain.util.Resource
import com.beknur.network.api.ProductApi


class ProductRepositoryImpl(
	private val productApi: ProductApi
): ProductRepository {


	override suspend fun getProductsByCategory(productCategory: String): List<Product> {
		return productApi.getProductsByCategory(productCategory).map { it.toProduct() }
	}

	override suspend fun getFiltersForCategory(filterCategory: String): Resource<FilterParams> {
		return try {
			val filterParams = productApi.getFiltersForCategory(filterCategory).toFilterParams()
			Resource.Success(filterParams)
		} catch (e: Exception) {
			Resource.Error(e)
		}
	}

}