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
import androidx.navigation3.runtime.NavKey
import androidx.navigation3.runtime.entry
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberSavedStateNavEntryDecorator
import androidx.navigation3.ui.NavDisplay

import kotlinx.serialization.Serializable




@Composable
fun CartGraph(backStack:NavBackStack){
	NavDisplay(

		backStack =backStack ,
		entryDecorators = listOf(
			rememberSavedStateNavEntryDecorator(),
			rememberViewModelStoreNavEntryDecorator()
		),
		entryProvider = entryProvider {
			entry<Screen.Cart>{
				Box(
					modifier = Modifier.fillMaxSize(),
					contentAlignment = Alignment.Center
				) {
					Button(onClick = { backStack.add(Screen.ProductDetail) }) {
						Text(text = "Detail")
					}
				}
			}
			entry<Screen.ProductDetail>{
				Box(
					modifier = Modifier.fillMaxSize(),
					contentAlignment = Alignment.Center
				) {
					Button(onClick = { backStack.add(Screen.Checkout) }) {
						Text(text = "Checkout")
					}
				}
			}
			entry<Screen.Checkout>{
				Text("dadfg")
			}


		}

	)


}