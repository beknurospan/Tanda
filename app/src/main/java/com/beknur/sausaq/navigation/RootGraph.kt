package com.beknur.sausaq.navigation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.navigation3.rememberViewModelStoreNavEntryDecorator
import androidx.navigation3.runtime.NavBackStack
import androidx.navigation3.runtime.entry
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberSavedStateNavEntryDecorator
import androidx.navigation3.ui.NavDisplay
import com.beknur.cart.CartScreen
import com.beknur.catalog.CatalogScreen
import com.beknur.favorites.FavoritesScreen
import com.beknur.productdetail.ProductDetailScreen

@Composable
fun RootGraph(backStack: NavBackStack){
	NavDisplay(
		backStack =backStack ,
		entryDecorators = listOf(
			rememberSavedStateNavEntryDecorator(),
			rememberViewModelStoreNavEntryDecorator()
		),
		entryProvider = entryProvider {
			entry<Screen.Home>{
				ProductDetailScreen(		listOf(
					"https://streams.frend.dev/image/v1?url=https%3A%2F%2Fvikingfootwear.centracdn.net%2Fclient%2Fdynamic%2Fimages%2F1486_91ebd57e2f-3-55650-305-b-1350x0.jpg&width=1200&quality=80",
					"https://streams.frend.dev/image/v1?url=https%3A%2F%2Fvikingfootwear.centracdn.net%2Fclient%2Fdynamic%2Fimages%2F1486_91ebd57e2f-3-55650-305-b-1350x0.jpg&width=1200&quality=80",
					"https://streams.frend.dev/image/v1?url=https%3A%2F%2Fvikingfootwear.centracdn.net%2Fclient%2Fdynamic%2Fimages%2F1486_91ebd57e2f-3-55650-305-b-1350x0.jpg&width=1200&quality=80"
				))
			}
			entry<Screen.Search>{
				Box(
					modifier = Modifier.fillMaxSize(),
					contentAlignment = Alignment.Center
				) {
					Button(onClick = { backStack.add(Screen.Offer) }) {
						Text(text = "Offer")
					}
				}
			}
			entry<Screen.Offer>{
				Box(
					modifier = Modifier.fillMaxSize(),
					contentAlignment = Alignment.Center
				) {

					Text(text = "Offer")

				}
			}
			entry<Screen.Favorites>{
				FavoritesScreen()
			}
			entry<Screen.Catalog>{ CatalogScreen { {} } }
			entry<Screen.Product>{
				Text("dadfg")
			}
			entry<Screen.Cart>{
				CartScreen()
			}
			entry<Screen.ProductDetail>{

			}
			entry<Screen.Checkout>{
				Text("dadfg")
			}
			entry<Screen.Profile>{
				Box(
					modifier = Modifier.fillMaxSize(),
					contentAlignment = Alignment.Center
				) {
					Button(onClick = { backStack.add(Screen.Checkout) }) {
						Text(text = "Checkout")
					}
				}

			}


		}
	)
}