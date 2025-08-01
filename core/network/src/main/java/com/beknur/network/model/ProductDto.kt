package com.beknur.network.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ProductResponse(
	@SerialName("name")
	val name: String
)