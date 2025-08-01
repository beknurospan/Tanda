package com.beknur.database.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(
	tableName = "cart",
)
data class CartEntity(
	@PrimaryKey
	val productId:Int,
	val isSelected: Boolean,
	val detailText: String,
	val brandName: String,
	val size: String,
	val pricePerOne: Int,
	val count: Int
)
