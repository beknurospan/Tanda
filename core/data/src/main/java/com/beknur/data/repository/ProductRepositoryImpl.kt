package com.beknur.data.repository

import com.beknur.data.mappers.toCartProduct
import com.beknur.data.mappers.toFilterParams
import com.beknur.data.mappers.toProduct
import com.beknur.data.mappers.toProductCategory
import com.beknur.data.mappers.toProductDetail
import com.beknur.domain.model.CartProduct
import com.beknur.domain.model.FilterParams
import com.beknur.domain.model.Product
import com.beknur.domain.model.ProductCategory
import com.beknur.domain.model.ProductDetail
import com.beknur.domain.repository.ProductRepository
import com.beknur.domain.util.Resource
import com.beknur.network.api.ProductApi


class ProductRepositoryImpl(
	private val productApi: ProductApi
): ProductRepository {


	override suspend fun getProductsByCategory(productCategory: String): List<ProductCategory> {
		return productApi.getProductsByCategory(productCategory).map { it.toProductCategory() }
	}

	override suspend fun getFiltersForCategory(filterCategory: String): Resource<FilterParams> {
		return try {
			val filterParams = productApi.getFiltersForCategory(filterCategory).toFilterParams()
			Resource.Success(filterParams)
		} catch (e: Exception) {
			Resource.Error(e)
		}
	}

	override suspend fun getProductDetail(id: Int, skuId: Int): Resource<ProductDetail> {
		return try {
			val productDetail = productApi.getProductDetail(id,skuId).toProductDetail()
			Resource.Success(productDetail)
		} catch (e: Exception) {
			Resource.Error(e)
		}
	}

	override suspend fun getProduct(id: Int, skuId: Int): Resource<Product> {
		return try {
			val resource=productApi.getProduct(id, skuId).toProduct()
			Resource.Success(resource)
		} catch (e: Exception) {
			Resource.Error(e)
		}
	}
}