package com.beknur.data.repository


import android.util.Log
import com.beknur.data.mappers.toCartEntity
import com.beknur.data.mappers.toCartProduct
import com.beknur.data.mappers.toProductType
import com.beknur.database.dao.CartDao
import com.beknur.domain.model.CartProduct
import com.beknur.domain.model.ProductType
import com.beknur.domain.repository.CartRepository
import com.beknur.network.api.ProductApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map


class CartRepositoryImpl(
	private val cartDao: CartDao, private val productApi: ProductApi
) : CartRepository {


	override fun getCartItems(): Flow<List<CartProduct>> {

		return cartDao.getCartEntities().map { it.map { it.toCartProduct() } }

	}

	override suspend fun decrementItem(productId: Int, skuId: Int) {
		cartDao.decrementItem(productId = productId, skuId = skuId)
	}

	override suspend fun toggleSelect(productId: Int, skuId: Int) {
		cartDao.toggleSelect(productId = productId, skuId = skuId)
	}

	override suspend fun selectAll() {
		cartDao.selectAll()
	}

	override suspend fun deleteSelected() {
		cartDao.deleteSelected()
	}

	override suspend fun getProductType(id: Int): ProductType {
		return productApi.getProductType(id).toProductType()
	}

	override suspend fun getProduct(id: Int, skuId: Int): Flow<CartProduct> {
		return flow {
			emit(productApi.getProduct(id = id, skuId = skuId).toCartProduct())
		}.flowOn(Dispatchers.IO)
	}

	override suspend fun insertOrAdd(product: CartProduct) {
		cartDao.addOrIncrement(product.toCartEntity())
	}

}