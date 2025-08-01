package com.beknur.domain.repository

import com.beknur.domain.model.CartProduct
import kotlinx.coroutines.flow.Flow

interface CartRepository {
	fun getCartItems(): Flow<List<CartProduct>>

	suspend fun incrementItem(productId: Int)

	suspend fun decrementItem(productId: Int)

	suspend fun toggleSelect(productId: Int)

	suspend fun selectAll()

	suspend fun deleteSelected()

	suspend fun insertItem(product:CartProduct)
}