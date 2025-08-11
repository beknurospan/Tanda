package com.beknur.cart

import android.R.attr.data
import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.SheetValue
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.beknur.cart.composables.AddProduct
import com.beknur.cart.composables.BottomSheetComponent
import com.beknur.cart.composables.CartTopBar
import com.beknur.cart.composables.PayButton
import com.beknur.designsystem.theme.WhiteAdd
import com.beknur.designsystem.theme.WhiteGray
import com.beknur.domain.model.CartProduct
import com.beknur.domain.model.ProductVariants
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch


@Composable
fun CartScreenRoute(viewModel: CartViewModel) {

	val viewState by viewModel.viewState.collectAsStateWithLifecycle()
	CartScreen(viewState, viewModel::handleEvent)
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CartScreen(
	viewState: CartViewState,
	sendUiEvent: (CartUiEvent) -> Unit
) {

	val sheetState = rememberModalBottomSheetState(
		skipPartiallyExpanded = true
	)

	Column {

		CartTopBar(
			onTrashClick = { sendUiEvent(CartUiEvent.OnTrashClick) },
			onSelectAllClick = { sendUiEvent(CartUiEvent.OnSelectAllClick) },
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
				items(viewState.products, key = { Pair(it.productId, it.skuId) }) { product ->

					Log.d("Count", product.count.toString())
					AddProduct(
						product.isSelected,
						product.detailText,
						product.brandName,
						product.size,
						product.pricePerOne.toString(),
						product.sum.toString(),
						product.count.toString(),
						onAddProduct = { sendUiEvent(CartUiEvent.OnAddProduct(product.productId)) },
						onDelProduct = {
							sendUiEvent(
								CartUiEvent.OnDelProduct(
									product.productId,
									product.skuId
								)
							)
						},
						onSelect = {
							sendUiEvent(
								CartUiEvent.OnSelectProductClick(
									product.productId,
									product.skuId
								)
							)
						}
					)
				}
			}

			PayButton(
				amount = viewState.amount.toString(),
				selectedCount = viewState.selectedCount.toString(),
				Modifier.align(Alignment.BottomCenter)
			) {
				sendUiEvent(CartUiEvent.OnPayButtonClick)
			}
			if (viewState.showBottomSheet) {
				ModalBottomSheet(
					onDismissRequest = {
						sendUiEvent(CartUiEvent.OnDismissBottomSheet)
					},
					sheetState = sheetState,
				) {

					when (viewState.productVariants) {

						is Loadable.Success -> {
							val variants = viewState.productVariants.data
							BottomSheetComponent(variants) { skuId ->
								sendUiEvent(
									CartUiEvent.OnSizeSelected(
										viewState.openedProductId,
										skuId
									)
								)
							}
						}

						is Loadable.Error -> {}
						Loadable.Idle -> {}
						Loadable.Loading -> {
							Box(
								modifier = Modifier
									.fillMaxWidth()
									.fillMaxHeight(0.6f)
									.background(Color.White)
							) {
								Box(
									modifier = Modifier
										.fillMaxWidth()
										.fillMaxHeight(0.5f),
									contentAlignment = Alignment.Center
								) {
									CircularProgressIndicator()
								}

							}
						}
					}

				}
			}
		}


	}

}


@Preview
@Composable
fun CartScreenPreview() {
	CartScreen(
		CartViewState(
			listOf(
				CartProduct(
					productId = 1,
					skuId = 2,
					isSelected = true,
					detailText = "Красивые",
					brandName = "Катона",
					size = "12",
					pricePerOne = 500,
					count = 2
				)
			),
			isAllSelected = true,
			0,
			0,
			showBottomSheet = true,
			openedProductId = 0
		)
	) { }
}


