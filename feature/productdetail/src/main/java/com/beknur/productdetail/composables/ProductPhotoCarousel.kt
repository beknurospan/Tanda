package com.beknur.productdetail.composables

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.beknur.productdetail.R
import com.beknur.designsystem.R as coreR

@Composable
fun ProductPhotoCarousel(photoUrls: List<String>) {
	Box(

	) {
		LazyRow(
			modifier = Modifier
				.fillMaxWidth()
				.height(240.dp),
		) {
			items(photoUrls) { url ->
				AsyncImage(
					model = url,
					contentDescription = null,
					contentScale = ContentScale.Fit,
					modifier = Modifier
						.fillMaxWidth()
						.aspectRatio(3f / 4f)
						.background(Color.White),
					onError = { Log.d("Async", it.toString(), it.result.throwable) })
			}
		}
		Row(modifier = Modifier.padding(10.dp)){
			Icon(
				modifier = Modifier.size(30.dp),
				imageVector = ImageVector.vectorResource(coreR.drawable.shopicons_regular_arrowleft),
				contentDescription = null
			)
			Spacer(modifier = Modifier.weight(1f))
			Icon(
				modifier = Modifier.size(30.dp),
				imageVector = ImageVector.vectorResource(coreR.drawable.shopicons_regular_upload),
				contentDescription = null
			)

		}


	}

}


@Preview
@Composable
fun ProductPhotoCarouselPreview() {
	ProductPhotoCarousel(listOf("d"))
}