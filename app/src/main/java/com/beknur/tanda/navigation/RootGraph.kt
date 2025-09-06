package com.beknur.tanda.navigation

import AuthScreenRoute
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.key
import androidx.lifecycle.viewmodel.navigation3.rememberViewModelStoreNavEntryDecorator
import androidx.navigation3.runtime.NavBackStack
import androidx.navigation3.runtime.NavKey
import androidx.navigation3.runtime.entry
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberSavedStateNavEntryDecorator
import androidx.navigation3.ui.NavDisplay
import com.beknur.about_app.AboutAppScreen
import com.beknur.address.AddressScreenRoute
import com.beknur.address.AddressViewModel
import com.beknur.auth.AuthViewModel
import com.beknur.cards.CardsScreen
import com.beknur.cart.CartScreenRoute
import com.beknur.cart.CartViewModel
import com.beknur.catalog.CatalogScreenRoute
import com.beknur.catalog.CatalogViewModel
import com.beknur.favorites.FavoriteScreenRoute
import com.beknur.favorites.FavoriteViewModel
import com.beknur.favorites.FavoritesScreen
import com.beknur.navigation.NavigationCommand
import com.beknur.navigation.NavigationManager
import com.beknur.navigation.Screen
import com.beknur.notifications.NotificationScreen
import com.beknur.orders.OrdersScreen
import com.beknur.payment.PaymentScreenRoute
import com.beknur.payment.PaymentViewModel
import com.beknur.product.ProductViewModel
import com.beknur.product.screens.ProductScreenRoute
import com.beknur.productdetail.ProductDetailRoute
import com.beknur.productdetail.ProductDetailViewModel
import com.beknur.profile.ProfileScreenRoute
import com.beknur.profile.ProfileViewModel
import com.beknur.search.SearchScreen
import com.beknur.support.SupportScreen
import com.beknur.tanda.MainViewModel
import org.koin.androidx.compose.koinViewModel
import org.koin.core.parameter.parametersOf

@Composable
fun RootGraph(backStack: NavBackStack,navigationManager: NavigationManager,mainViewModel : MainViewModel){

	key(backStack) {
		fun navigate(screen: NavKey){
			backStack.add(screen)
		}
		fun navigateBack(){
			if (backStack.isNotEmpty()) {
				backStack.removeAt(backStack.lastIndex)
			}
		}
		fun backShowBottom(screen: NavKey){
			backStack.remove(screen)
			mainViewModel.setBottomBarVisibility(true)
		}
		fun navigateHideBottom(screen: NavKey){
			backStack.add(screen)
			mainViewModel.setBottomBarVisibility(false)
		}
		fun popUntilNavigate(currentScreen: NavKey,screenNavigate: NavKey){
			backStack.clear()
			backStack.add(screenNavigate)
			mainViewModel.setBottomBarVisibility(true)
		}
		NavDisplay(
			entryProvider = entryProvider {
				entry<Screen.Home> {

				}
				entry<Screen.Search> {
					SearchScreen()
				}
				entry<Screen.Offer> {}
				entry<Screen.Favorites> {
					val viewModel = koinViewModel<FavoriteViewModel>()
					FavoriteScreenRoute(viewModel)
				}
				entry<Screen.Catalog> {
					val viewModel = koinViewModel<CatalogViewModel>()
					CatalogScreenRoute(viewModel)
				}
				entry<Screen.Product> { key ->
					val viewModel = koinViewModel<ProductViewModel>()
					ProductScreenRoute(viewModel)
				}
				entry<Screen.Cart> {
					val viewModel= koinViewModel<CartViewModel>()
					CartScreenRoute(viewModel)
				}
				entry<Screen.ProductDetail> { entry ->
					val id = entry.product
					val skuId = entry.skuId

					val viewModel = koinViewModel<ProductDetailViewModel> { parametersOf(id, skuId) }

					ProductDetailRoute(viewModel = viewModel)
				}
				entry<Screen.Checkout> {}
				entry<Screen.Profile> {
					val viewModel = koinViewModel<ProfileViewModel>()
					ProfileScreenRoute(viewModel)
				}
				entry<Screen.Address> {
					val viewModel = koinViewModel<AddressViewModel>()
					AddressScreenRoute(viewModel)
				}
				entry<Screen.Cards> {
					CardsScreen()
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
				entry<Screen.Auth>{
					val viewModel = koinViewModel<AuthViewModel>()
					AuthScreenRoute(viewModel)
				}
				entry<Screen.Payment>{
					val viewModel= koinViewModel<PaymentViewModel>()
					PaymentScreenRoute(viewModel)
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

					is NavigationCommand.Navigate -> navigate(it.screen)
					is NavigationCommand.BackShowBottom -> backShowBottom(it.screen)
					is NavigationCommand.NavigateHideBottom-> navigateHideBottom(it.screen)
					is NavigationCommand.PopUntilNavigate -> popUntilNavigate(it.currentScreen,it.screenNavigate)
					NavigationCommand.NavigateBack -> navigateBack()
				}
			}

		}


	}

}