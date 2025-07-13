package com.beknur.product

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.getValue
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.input.key.Key.Companion.G
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.beknur.designsystem.theme.Gray
import com.beknur.designsystem.R as coreR
import  com.beknur.designsystem.theme.Green
import com.beknur.designsystem.theme.GreenDark
import com.beknur.designsystem.theme.Orange


@Composable
fun ProductScreenRoute(viewModel: ProductViewModel) {

	val viewState by viewModel.viewState.collectAsStateWithLifecycle()
	ProductScreen(viewState,viewModel::handleEvent)
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

		TopField("",{sendUiEvent(ProductUiEvent.OnProductSelected)})
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


@Composable
fun TopField(text: String,onClick:()->Unit) {

	Row(
		modifier = Modifier
			.fillMaxWidth()
			.height(58.dp)
			.background(color = Color.White),
		verticalAlignment = Alignment.CenterVertically
	) {
		Spacer(modifier = Modifier.width(8.dp))
		Icon(
			imageVector = ImageVector.vectorResource(coreR.drawable.arrow_left_light),
			contentDescription = "",
			modifier = Modifier.size(36.dp)
		)
		Spacer(modifier = Modifier.weight(1f))
		Text(text)
		Spacer(modifier = Modifier.weight(1f))
		Icon(
			imageVector = ImageVector.vectorResource(coreR.drawable.search_light),
			contentDescription = "",
			modifier = Modifier.size(36.dp)
		)
		Spacer(modifier = Modifier.width(8.dp))

	}

	LazyRow(modifier = Modifier.height(60.dp), verticalAlignment = Alignment.CenterVertically) {
		items(10) {
			CategoryButtonCard()
		}
	}
	LazyRow(modifier = Modifier) {

		item {
			FilterButton()
		}
		item {
			SortButton()
		}


		items(7) {
			ButtonProperties()
		}
	}
	LazyVerticalGrid(
		columns = GridCells.Fixed(2),
		contentPadding = PaddingValues(12.dp),
		horizontalArrangement = Arrangement.spacedBy(14.dp),
		verticalArrangement = Arrangement.spacedBy(14.dp)
	) {
		items(20) { index ->

			Column(verticalArrangement = Arrangement.spacedBy(5.dp)) {

				Box(
					modifier = Modifier
						.fillMaxWidth()
						.aspectRatio(3f / 4f)
						.clickable { onClick.invoke() }
						.shadow(
							elevation = 1.dp, // ← тень здесь
							shape = RoundedCornerShape(2.dp), // для лучшего эффекта
						)
						.clip(shape = RoundedCornerShape(8.dp)),
					contentAlignment = Alignment.Center,
				) {

				}
				Text("Brand")
				Text("Имя Товара")
				Row(
					modifier = Modifier
						.fillMaxWidth()
						.clip(RoundedCornerShape(4.dp))
						.height(30.dp),
					verticalAlignment = Alignment.CenterVertically,
					horizontalArrangement = Arrangement.Absolute.Center
				) {
					Text("30 000 ", fontWeight = FontWeight.Bold)
					Icon(
						modifier = Modifier.size(10.dp),
						imageVector = ImageVector.vectorResource(coreR.drawable.tenge_svgrepo_com),
						contentDescription = ""
					)
				}
			}


		}
	}


}


@Preview
@Composable
fun CategoryButtonCard(text: String = "что то") {
	Box(
		modifier = Modifier
			.height(50.dp)
			.padding(horizontal = 4.dp, vertical = 6.dp)
			.clip(RoundedCornerShape(4.dp))
			.background(Green),
		contentAlignment = Alignment.Center

	) {
		Text(text, modifier = Modifier.padding(horizontal = 12.dp))
	}
}

@Preview
@Composable
fun FilterButton() {
	Box(
		modifier = Modifier
			.padding(horizontal = 4.dp, vertical = 3.dp)
			.size(34.dp)
			.clip(RoundedCornerShape(2.dp))
			.border(1.dp, Color.Black, shape = RoundedCornerShape(2.dp)),
		contentAlignment = Alignment.Center


	) {


		Icon(
			imageVector = ImageVector.vectorResource(coreR.drawable.filter_alt_light),
			contentDescription = "",
			modifier = Modifier.size(24.dp)
		)

	}
}

@Preview
@Composable
fun SortButton() {
	Box(
		modifier = Modifier
			.padding(horizontal = 4.dp, vertical = 3.dp)
			.size(34.dp)
			.clip(RoundedCornerShape(2.dp))
			.border(1.dp, Color.Black, shape = RoundedCornerShape(2.dp)),
		contentAlignment = Alignment.Center


	) {


		Icon(
			imageVector = ImageVector.vectorResource(coreR.drawable.sort_arrow_light),
			contentDescription = "",
			modifier = Modifier.size(24.dp)
		)

	}
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


