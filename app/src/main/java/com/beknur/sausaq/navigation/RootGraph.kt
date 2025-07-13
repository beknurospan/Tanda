package com.beknur.sausaq.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.key
import androidx.lifecycle.viewmodel.navigation3.rememberViewModelStoreNavEntryDecorator
import androidx.navigation3.runtime.NavBackStack
import androidx.navigation3.runtime.entry
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberSavedStateNavEntryDecorator
import androidx.navigation3.ui.NavDisplay
import com.beknur.about_app.AboutAppScreen
import com.beknur.address.AddressScreen
import com.beknur.cart.CartScreen
import com.beknur.catalog.CatalogScreen
import com.beknur.catalog.CatalogScreenRoute
import com.beknur.catalog.CatalogViewModel
import com.beknur.favorites.FavoritesScreen
import com.beknur.navigation.NavigationCommand
import com.beknur.navigation.NavigationManager
import com.beknur.navigation.Screen
import com.beknur.notifications.NotificationScreen
import com.beknur.orders.OrdersScreen
import com.beknur.product.ProductScreen
import com.beknur.product.ProductScreenRoute
import com.beknur.product.ProductViewModel
import com.beknur.productdetail.ProductDetailRoute
import com.beknur.productdetail.ProductDetailScreen
import com.beknur.productdetail.ProductDetailViewModel
import com.beknur.profile.ProfileScreen
import com.beknur.profile.ProfileScreenRoute
import com.beknur.profile.ProfileViewModel
import com.beknur.support.SupportScreen
import org.koin.androidx.compose.koinViewModel

@Composable
fun RootGraph(backStack: NavBackStack,navigationManager: NavigationManager){

	key(backStack) {
		NavDisplay(
			entryProvider = entryProvider {
				entry<Screen.Home> {

				}
				entry<Screen.Search> {}
				entry<Screen.Offer> {}
				entry<Screen.Favorites> { FavoritesScreen() }
				entry<Screen.Catalog> {
					val viewModel = koinViewModel<CatalogViewModel>()
					CatalogScreenRoute(viewModel)
				}
				entry<Screen.Product> { key ->
					val viewModel = koinViewModel<ProductViewModel>()
					ProductScreenRoute(viewModel)
				}
				entry<Screen.Cart> { CartScreen() }
				entry<Screen.ProductDetail> {
					val viewModel = koinViewModel<ProductDetailViewModel>()
					ProductDetailRoute(viewModel)
				}
				entry<Screen.Checkout> {}
				entry<Screen.Profile> {
					val viewModel = koinViewModel<ProfileViewModel>()
					ProfileScreenRoute(viewModel)
				}
				entry<Screen.Address> {
					AddressScreen()
				}
				entry<Screen.Cards> {
					AddressScreen()
				}
				entry<Screen.Orders> {
					OrdersScreen()
				}
				entry<Screen.Notifications> {
					NotificationScreen()
				}
				entry<Screen.AboutApp> {
					AboutAppScreen()
				}
				entry<Screen.Support> {
					SupportScreen()
				}

			},
			backStack = backStack,
			entryDecorators = listOf(
				rememberSavedStateNavEntryDecorator(),
				rememberViewModelStoreNavEntryDecorator()
			)
		)
		LaunchedEffect(Unit) {
			navigationManager.commands.collect {
				when (it) {
					NavigationCommand.Back -> Unit
					is NavigationCommand.Navigate -> backStack.add(it.screen)
				}
			}
		}
	}
}