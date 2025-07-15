package com.beknur.catalog


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.beknur.catalog.composables.AnimatedSegmentedControl
import com.beknur.catalog.composables.ProductIcon
import com.beknur.catalog.data.ProductCategory
import com.beknur.designsystem.ui.SearchTextField


@Composable
fun CatalogScreenRoute(viewModel: CatalogViewModel) {
	val viewState by viewModel.viewState.collectAsStateWithLifecycle()
	CatalogScreen(viewState, viewModel::handleEvent)
}

@Composable
fun CatalogScreen(
	viewState: CatalogViewState,
	sendUiEvent: (CatalogUiEvent) -> Unit
) {
	val options = listOf(
		stringResource(R.string.feature_catalog_option_men),
		stringResource(R.string.feature_catalog_option_woman),
		stringResource(R.string.feature_catalog_option_kids)
	)
	Column(
		Modifier
			.fillMaxSize()
			.background(Color.White)
			.padding(horizontal = 30.dp),
		horizontalAlignment = Alignment.CenterHorizontally,
		verticalArrangement = Arrangement.spacedBy(25.dp)
	) {
		Spacer(modifier = Modifier.height(5.dp))
		SearchTextField(false){sendUiEvent(CatalogUiEvent.OnSearchClick)}
		AnimatedSegmentedControl(
			options = options,
			selectedIndex = viewState.selectedIndex,
			onSelectedChange = { sendUiEvent(CatalogUiEvent.OnGenderChanged(it)) }
		)
		LazyColumn(
			modifier = Modifier.fillMaxHeight(),
			verticalArrangement = Arrangement.spacedBy(10.dp)
		) {
			items(viewState.categories) { category ->
				ProductIcon(
					category.name,
					onClick = {
						sendUiEvent(
							CatalogUiEvent.OnProductCategoryClick(
								category.name, category.gender
							)
						)
					}
				)
			}

		}

	}
}

@Preview
@Composable
fun CatalogScreenPreview() {
	CatalogScreen(CatalogViewState(
		listOf(ProductCategory("", "", "")),
		selectedIndex = 1
	), {})
}





