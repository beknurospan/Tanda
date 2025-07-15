package com.beknur.product

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.getValue
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.beknur.designsystem.R as coreR
import com.beknur.product.composables.ButtonFilter
import com.beknur.product.composables.LazyCollectionsRow
import com.beknur.product.composables.LazyProductColumn
import com.beknur.product.composables.TopBar


@Composable
fun ProductScreenRoute(viewModel: ProductViewModel) {

	val viewState by viewModel.viewState.collectAsStateWithLifecycle()
	ProductScreen(viewState, viewModel::handleEvent)
}


@Composable
fun ProductScreen(
	viewState: ProductViewState,
	sendUiEvent: (ProductUiEvent) -> Unit
) {
	Column(
		modifier = Modifier
			.fillMaxSize()
			.background(Color.White)
			.padding(8.dp),
	) {
		TopBar("обувь")
		LazyCollectionsRow("обувь")
		Row(
			modifier = Modifier
				.height(50.dp)
				.fillMaxWidth()
				.padding(horizontal = 12.dp),
			horizontalArrangement = Arrangement.spacedBy(14.dp),
			verticalAlignment = Alignment.CenterVertically
		) {
			ButtonFilter(Modifier.weight(1f),"Фильтр",coreR.drawable.filter_alt_light)
			ButtonFilter(Modifier.weight(1f),"По новизне",coreR.drawable.sort_arrow_light)
		}
		LazyProductColumn(onClick ={sendUiEvent(ProductUiEvent.OnProductSelected)})
	}
}



@Preview
@Composable
fun ProductScreenPreview() {
	ProductScreen(
		ProductViewState(" "),
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


