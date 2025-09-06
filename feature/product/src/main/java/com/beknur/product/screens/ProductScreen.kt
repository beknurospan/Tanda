package com.beknur.product.screens

import FilterScreen
import android.R.attr.type
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.beknur.domain.model.FilterParams
import com.beknur.domain.model.Product
import com.beknur.domain.model.ProductCategory
import com.beknur.domain.util.Loadable
import com.beknur.product.ProductUiEvent
import com.beknur.product.ProductViewModel
import com.beknur.product.ProductViewState
import com.beknur.product.SelectedFilters
import com.beknur.product.composables.ButtonFilter
import com.beknur.product.composables.LazyProductColumn
import com.beknur.product.composables.SortDialog
import com.beknur.product.composables.TopBar
import com.beknur.designsystem.R as coreR


@Composable
fun ProductScreenRoute(viewModel: ProductViewModel) {

	val viewState by viewModel.viewState.collectAsStateWithLifecycle()
	ProductScreen(viewState, viewModel::handleEvent)
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProductScreen(
	viewState: ProductViewState,
	sendUiEvent: (ProductUiEvent) -> Unit
) {

	val sheetState=rememberModalBottomSheetState(
		skipPartiallyExpanded = true
	)

	Column(
		modifier = Modifier
			.fillMaxSize()
			.background(Color.White)
			.padding(8.dp),
	) {
		TopBar("обувь")
		Row(
			modifier = Modifier
				.height(50.dp)
				.fillMaxWidth()
				.padding(horizontal = 12.dp),
			horizontalArrangement = Arrangement.spacedBy(14.dp),
			verticalAlignment = Alignment.CenterVertically
		) {
			ButtonFilter(
				Modifier.weight(1f), "Фильтр", coreR.drawable.filter_alt_light,
				onClick = { sendUiEvent(ProductUiEvent.OnFilterClicked) }
			)
			ButtonFilter(
				Modifier.weight(1f), "По новизне", coreR.drawable.sort_arrow_light,
				onClick = { sendUiEvent(ProductUiEvent.OnSortClicked) }
			)
		}
		LazyProductColumn(
			products = viewState.products,
			onClick = { productId, skuId ->
				sendUiEvent(
					ProductUiEvent.OnProductSelected(
						productId = productId,
						skuId = skuId
					)
				)
			})
		if (viewState.showBottomSheet) {
			ModalBottomSheet(
				sheetState = sheetState,
				onDismissRequest = {sendUiEvent(ProductUiEvent.OnDissmissModalBottomSheet)}
			) {
				when (viewState.filterParams) {
					is Loadable.Error -> {}
					Loadable.Idle -> {}
					Loadable.Loading -> {}
					is Loadable.Success<FilterParams> ->{
						FilterScreen(
							sizeAttribute = viewState.filterParams.data.sizeAttribute,
							brandAttribute = viewState.filterParams.data.brandAttribute,
							priceRange = viewState.filterParams.data.priceRange,
							filterAttributes = viewState.filterParams.data.filterAttributes,
							selectedParams = viewState.selectedFilters.selectedParams,
							onClickParams = { attributeId, paramId -> sendUiEvent(ProductUiEvent.OnParameterClicked(attributeId,paramId))},
							onPriceChange = { range -> },
							onBack = {}
						)
					}
				}
			}
		}
		if (viewState.showSortDialog){
			SortDialog(
				onDismiss = {
					sendUiEvent(ProductUiEvent.OnDissmissSortDialog)
				},
				onTypeClicked = { type->
					sendUiEvent( ProductUiEvent.OnSortDialogTypeClicked(type))
				},
			)
		}
	}
}


@Preview
@Composable
fun ProductScreenPreview() {
	ProductScreen(
		ProductViewState(
			products = listOf(
				ProductCategory(
					1,
					5,
					5.0,
					listOf(1, 5, 6),
					4.7,
					"Кроссовки",
					"nike",
					img = ""
				)
			),
			filterParams = Loadable.Idle,
			selectedFilters = SelectedFilters(),
			showBottomSheet = false,
			showSortDialog = false
		),
		sendUiEvent = {}
	)
}


@Preview
@Composable
fun ButtonProperties(text: String = "что то") {
	Row(
		modifier = Modifier
			.padding(horizontal = 4.dp, vertical = 3.dp)
			.height(34.dp)
			.clip(RoundedCornerShape(2.dp))
			.border(1.dp, Color.Black, shape = RoundedCornerShape(2.dp)),
		verticalAlignment = Alignment.CenterVertically


	) {

		Text(text, modifier = Modifier.padding(horizontal = 10.dp))
		Icon(
			imageVector = ImageVector.vectorResource(coreR.drawable.vector_9),
			contentDescription = "",
			modifier = Modifier
				.size(24.dp)
				.padding(end = 6.dp)
		)

	}
}


