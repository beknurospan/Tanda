package com.beknur.navigation

import androidx.navigation3.runtime.NavKey
import kotlinx.serialization.Serializable


@Serializable
sealed class Screen: NavKey {

	@Serializable
	data object Home : Screen()

	@Serializable
	data object Cart : Screen()
	@Serializable
	data object Catalog : Screen()
	@Serializable
	data object Favorites : Screen()
	@Serializable
	data object Login : Screen()

	@Serializable
	data object Payment : Screen()

	@Serializable
	data object Orders : Screen()

	@Serializable
	data class Product(val code:String,val gender:String): Screen()
	@Serializable
	data object Search: Screen()
	@Serializable
	data object Offer : Screen()
	@Serializable
	data object ProductDetail : Screen()
	@Serializable
	data object Notifications : Screen()
	@Serializable
	data object Profile : Screen()
	@Serializable
	data object Checkout: Screen()
	@Serializable
	data object AboutApp: Screen()
	@Serializable
	data object Support: Screen()
	@Serializable
	data object Address: Screen()
	@Serializable
	data object Cards: Screen()



}