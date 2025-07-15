package com.beknur.designsystem.ui

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.beknur.designsystem.R
import com.beknur.designsystem.theme.WhiteGray


@Composable
fun ProductDetailCard(onClick: () -> Unit) {
	Column(
		verticalArrangement = Arrangement.spacedBy(5.dp),
		modifier = Modifier
			.shadow(
				elevation = 2.dp,
				shape = RoundedCornerShape(4.dp),
				clip = false
			)
			.clip(RoundedCornerShape(4.dp))
			.background(WhiteGray)
			.padding(10.dp)
			.clickable { onClick.invoke() }
	) {

		Box(
			modifier = Modifier
				.fillMaxWidth()
				.aspectRatio(3f / 4f),
		) {

			AsyncImage(
				model = "https://www.pngplay.com/wp-content/uploads/12/Running-Shoes-PNG-Clip-Art-HD-Quality.png",
				contentDescription = null,
				contentScale = ContentScale.Fit,
				modifier = Modifier
					.fillMaxWidth()
					.aspectRatio(3f / 4f)
					.background(WhiteGray),
				onError = { Log.d("Async", it.toString(), it.result.throwable) })
			Row(
				modifier = Modifier
					.height(20.dp)
					.fillMaxWidth(),
				verticalAlignment = Alignment.CenterVertically
			) {
				Icon(
					imageVector = ImageVector.vectorResource(R.drawable.star_4),
					contentDescription = null,
					tint = Color.Unspecified,
					modifier = Modifier.size(15.dp)
				)
				Spacer(modifier = Modifier.width(5.dp))
				Text("4.9", style = MaterialTheme.typography.bodySmall)
			}

		}
		HorizontalDivider(
			thickness = 1.dp,
			color = Color.Black
		)
		Text("Brand")
		Text("Имя Товара")
		CostButton("32000")
	}
}

@Preview
@Composable
fun ProductDetailCardPreview() {
	ProductDetailCard { }
}