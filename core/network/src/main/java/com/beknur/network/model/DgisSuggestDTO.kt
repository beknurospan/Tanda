package com.beknur.network.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable



@Serializable
data class DgisSuggestResponse(
	@SerialName("result")
	val result: DgisResult
)

@Serializable
data class DgisResult(
	@SerialName("items")
	val items: List<SuggestItem>
)

@Serializable
data class SuggestItem(
	@SerialName("full_name")
	val fullName: String? = null,

	@SerialName("address_name")
	val addressName: String? = null
)