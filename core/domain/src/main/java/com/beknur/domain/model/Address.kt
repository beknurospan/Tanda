package com.beknur.domain.model

import android.annotation.SuppressLint
import kotlinx.serialization.Serializable


@SuppressLint("UnsafeOptInUsageError")
@Serializable
data class Address(
	val id: Int = -1,
	val address: String,
	val apartment: String,
	val entrance: String,
	val floor: String,
)