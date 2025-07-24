package com.beknur.orderdetail.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.beknur.designsystem.theme.WhiteGray
import com.beknur.designsystem.ui.TndButton

@Preview
@Composable
fun OrderDetailItemPreview() {
	Column(modifier = Modifier
		.fillMaxSize()
		.background(Color.White)) {
		Text("Заказ 156565656")
		OrderDetailItem()

	}

}


@Composable
fun OrderDetailItem() {
	Column(
		modifier = Modifier
			.fillMaxWidth()
			.height(240.dp)
			.clip(RoundedCornerShape(8.dp))
			.background(WhiteGray)
			.padding(20.dp),

		) {
		Row(modifier = Modifier.fillMaxWidth()) {

			AsyncImage(
				model = "https://www.pngarts.com/files/3/Running-Shoes-PNG-Picture.png",
				modifier = Modifier
					.height(100.dp)
					.aspectRatio(3f / 4f),
				contentDescription = "",
				contentScale = ContentScale.Fit
			)

			Spacer(modifier = Modifier.weight(1f))
			Text("858 Т")
		}
		TndButton(true, onClick = {}, "В корзину")
		TndButton(true, onClick = {}, "Оставить отзыв")
	}
}