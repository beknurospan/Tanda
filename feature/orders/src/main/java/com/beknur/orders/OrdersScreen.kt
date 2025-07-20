package com.beknur.orders

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.layout.LazyLayout
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.beknur.designsystem.theme.WhiteGray

@Preview
@Composable
fun OrdersScreen() {
	Column(
		modifier = Modifier
			.fillMaxSize()
			.background(Color.White)
	) {
		LazyColumn(
			Modifier.padding(10.dp),
			verticalArrangement = Arrangement.spacedBy(10.dp)
		) {
			items(6) {
				OrderItem()
			}

		}

	}
}


@Composable
fun OrderItem() {


	Column(
		modifier = Modifier
			.fillMaxWidth()
			.height(160.dp)
			.clip(RoundedCornerShape(8.dp))
			.background(WhiteGray)
			.padding(20.dp),

		) {
		Row(modifier = Modifier.fillMaxWidth()) {

			AsyncImage(
				model="https://www.pngarts.com/files/3/Running-Shoes-PNG-Picture.png",
				modifier = Modifier
					.height(60.dp)
					.aspectRatio(3f / 4f),
				contentDescription = "",
				contentScale = ContentScale.Fit
			)

			Spacer(modifier = Modifier.weight(1f))
			Text("858 Т")
		}
		Text("в процессе")

		Text("заказ #235959444")


		Text("детали заказа")
	}
}