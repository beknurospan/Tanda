package com.beknur.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.beknur.database.model.CartEntity
import kotlinx.coroutines.flow.Flow


@Dao
interface CartDao {
	@Query("SELECT * FROM cart")
	fun getCartEntities(): Flow<List<CartEntity>>

	@Insert
	suspend fun insertCartEntity(cartEntity: CartEntity)

	@Query("UPDATE cart SET count = count + 1 WHERE productId = :productId")
	suspend fun incrementItem(productId: Int)

	@Query("UPDATE cart SET count = count - 1 WHERE productId = :productId")
	suspend fun decrementItem(productId: Int)

	@Query("UPDATE cart SET isSelected = NOT isSelected WHERE productId = :productId")
	suspend fun toggleSelect(productId: Int)

	@Query("UPDATE cart SET isSelected = 1")
	suspend fun selectAll()

	@Query("DELETE FROM cart WHERE isSelected = 1")
	suspend fun deleteSelected()

}