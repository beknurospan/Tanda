package com.beknur.cart

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.beknur.cart.composables.AddProduct
import com.beknur.cart.composables.CartTopBar
import com.beknur.cart.composables.PayButton
import com.beknur.cart.data.ProductItem
import com.beknur.designsystem.theme.WhiteAdd
import com.beknur.designsystem.theme.WhiteGray
import com.beknur.domain.model.CartProduct


@Composable
fun CartScreenRoute(viewModel: CartViewModel) {

	val viewState by viewModel.viewState.collectAsStateWithLifecycle()
	CartScreen(viewState, viewModel::handleEvent)
}


@Composable
fun CartScreen(
	viewState: CartViewState,
	sendUiEvent: (CartUiEvent) -> Unit
) {


	Column {

		CartTopBar(
			onTrashClick = {sendUiEvent(CartUiEvent.OnTrashClick)},
			onSelectAllClick = {sendUiEvent(CartUiEvent.OnSelectAllClick)},
			isAllSelected = viewState.isAllSelected,
			selectedCount = viewState.selectedCount.toString()
		)
		Box(
			modifier = Modifier
				.fillMaxSize()
				.background(WhiteGray)
		) {
			LazyColumn(
				verticalArrangement = Arrangement.spacedBy(5.dp),
				contentPadding = PaddingValues(10.dp)
			) {
				items(viewState.products, key = { it.productId } ) { product->

					Log.d("Count",product.count.toString())
					AddProduct(
						product.isSelected,
						product.detailText,
						product.brandName,
						product.size,
						product.pricePerOne.toString(),
						product.sum.toString(),
						product.count.toString(),
						onAddProduct = {sendUiEvent(CartUiEvent.OnAddProduct(product.productId))},
						onDelProduct = {sendUiEvent(CartUiEvent.OnDelProduct(product.productId))},
						onSelect = {sendUiEvent(CartUiEvent.OnSelectProductClick(product.productId))}
					)
				}
			}

			PayButton(amount = viewState.amount.toString(), selectedCount = viewState.selectedCount.toString(),Modifier.align(Alignment.BottomCenter)) {
				sendUiEvent(CartUiEvent.OnPayButtonClick)
			}
		}


	}

}


@Preview
@Composable
fun CartScreenPreview() {
	CartScreen(CartViewState(
		listOf(
			CartProduct(
				1,
				true,
				"66",
				"",
				"",
				580,
				1200,
				2
			)
		),
		isAllSelected = true,
		0,
		0
	)) { }
}


