package com.beknur.sausaq.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.runtime.saveable.Saver
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation3.runtime.NavKey
import com.beknur.sausaq.R
import com.beknur.designsystem.R as coreR
import kotlinx.serialization.Serializable

val bottomBarItems= listOf<BottomBarScreen>(
	BottomBarScreen.Home,
	BottomBarScreen.Catalog,
	BottomBarScreen.Basket,
	BottomBarScreen.Favorites,
	BottomBarScreen.Login,
)

@Serializable
sealed class BottomBarScreen(
	val icon: Int,
	val title:String
):NavKey{

	@Serializable
	data object Home:BottomBarScreen(
		icon = coreR.drawable.s1,
		title ="Главная"
	)

	@Serializable
	data object Basket:BottomBarScreen(
		icon = coreR.drawable.shopicons_light_cart3,
		title = "Корзина"
	)

	@Serializable
	data object Favorites:BottomBarScreen(
		icon = coreR.drawable.s2,
		title = "Избранное"
	)

	@Serializable
	data object Catalog:BottomBarScreen(
		icon = coreR.drawable.shopicons_light_store,
		title = "Каталог"
	)
	@Serializable
	data object Login:BottomBarScreen(
		icon = coreR.drawable.s3,
		title = "Профиль"
	)


}

val BottomBarScreenSaver = Saver<BottomBarScreen, String>(
	save = { it::class.simpleName ?: "Unknown" },
	restore = {
		when (it) {
			BottomBarScreen.Home::class.simpleName -> BottomBarScreen.Home
			BottomBarScreen.Catalog::class.simpleName -> BottomBarScreen.Catalog
			BottomBarScreen.Login::class.simpleName -> BottomBarScreen.Login
			BottomBarScreen.Basket::class.simpleName -> BottomBarScreen.Basket
			BottomBarScreen.Favorites::class.simpleName -> BottomBarScreen.Favorites
			else -> BottomBarScreen.Home
		}
	}
)