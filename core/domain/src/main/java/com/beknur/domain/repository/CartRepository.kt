package com.beknur.domain.repository

import com.beknur.domain.model.CartProduct
import com.beknur.domain.model.ProductType
import kotlinx.coroutines.flow.Flow

interface CartRepository {
	fun getCartItems(): Flow<List<CartProduct>>



	suspend fun decrementItem(productId: Int,skuId: Int)

	suspend fun toggleSelect(productId: Int,skuId: Int)

	suspend fun selectAll()

	suspend fun deleteSelected()
	suspend fun getProductType(id:Int): ProductType
	suspend fun getProduct(id:Int,skuId: Int): Flow<CartProduct>
	suspend fun insertOrAdd(id:CartProduct)
}