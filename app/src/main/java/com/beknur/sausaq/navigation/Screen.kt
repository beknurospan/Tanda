package com.beknur.sausaq.navigation

import androidx.navigation3.runtime.NavKey
import kotlinx.serialization.Serializable

@kotlinx.serialization.Serializable
sealed class Screen: NavKey {
	@kotlinx.serialization.Serializable
	data object Home : Screen()

	@kotlinx.serialization.Serializable
	data object Cart : Screen()
	@kotlinx.serialization.Serializable
	data object Catalog : Screen()
	@kotlinx.serialization.Serializable
	data object Favorites : Screen()
	@kotlinx.serialization.Serializable
	data object Login : Screen()

	@kotlinx.serialization.Serializable
	data object Payment : Screen()

	@kotlinx.serialization.Serializable
	data object Orders : Screen()

	@kotlinx.serialization.Serializable
	data object Product:Screen()
	@kotlinx.serialization.Serializable
	data object Search:Screen()
	@kotlinx.serialization.Serializable
	data object Offer :Screen()
	@kotlinx.serialization.Serializable
	data object ProductDetail :Screen()
	@kotlinx.serialization.Serializable
	data object Notifications :Screen()
	@kotlinx.serialization.Serializable
	data object Profile :Screen()
	@Serializable
	data object Checkout: Screen()



}