package com.beknur.productdetail

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage


@Composable
fun ProductDetailScreen(
	photoList: List<String>
) {

	Column(
		modifier = Modifier
			.fillMaxSize()
			.background(color = Color.White)
	) {

		ProductPhotoCarousel(photoList)
	}

}

@Composable
fun ProductPhotoCarousel(photoUrls: List<String>) {
	LazyRow(
		modifier = Modifier
			.fillMaxWidth()
			.height(240.dp),
	) {
		items(photoUrls) { url ->
			AsyncImage(
				model = url,
				contentDescription = null,
				contentScale = ContentScale.Crop,
				modifier = Modifier
					.width(200.dp)
					.fillMaxHeight()
					.background(Color.LightGray),
				onError = { Log.d("Async", it.toString(), it.result.throwable) }
			)
		}
	}

	Row(modifier = Modifier
		.fillMaxWidth()
		.height(20.dp)) {

	}
}

@Preview
@Composable
fun ProductDetailScreenPreview() {
	ProductDetailScreen(
		listOf(
			"https://www.shoppingschool.ru/netcat_files/userfiles/Articles/2023/Travel_looks/travel5.jpeg",
			"https://www.shoppingschool.ru/netcat_files/userfiles/Articles/2023/Travel_looks/travel5.jpeg",
			"https://www.shoppingschool.ru/netcat_files/userfiles/Articles/2023/Travel_looks/travel5.jpeg"
		)
	)
}