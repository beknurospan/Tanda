package com.beknur.data.repository




import com.beknur.data.mappers.toCartEntity
import com.beknur.data.mappers.toCartProduct
import com.beknur.database.dao.CartDao
import com.beknur.domain.model.CartProduct
import com.beknur.domain.repository.CartRepository
import com.beknur.network.api.ProductApi

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map



class CartRepositoryImpl(private val cartDao: CartDao,private val productApi: ProductApi) :
	CartRepository {
	override fun getCartItems(): Flow<List<CartProduct>> {

		return cartDao.getCartEntities().map { it.map { it.toCartProduct() } }

	}

	override suspend fun incrementItem(productId: Int) {
		cartDao.incrementItem(productId)
	}

	override suspend fun decrementItem(productId: Int) {
		cartDao.decrementItem(productId)
	}

	override suspend fun toggleSelect(productId: Int) {
		cartDao.toggleSelect(productId)
	}

	override suspend fun selectAll() {
		cartDao.selectAll()
	}

	override suspend fun deleteSelected() {
		cartDao.deleteSelected()
	}
	override suspend fun insertItem(product: CartProduct) {
		cartDao.insertCartEntity(product.toCartEntity())
	}
}