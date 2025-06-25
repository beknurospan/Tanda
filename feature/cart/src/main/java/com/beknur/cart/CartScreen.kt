package com.beknur.cart

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.beknur.designsystem.R
import com.beknur.designsystem.theme.Gray
import com.beknur.designsystem.theme.Orange

@Preview
@Composable
fun CartScreen() {

	Box(modifier = Modifier
		.fillMaxSize()
		.background(Color.White)){

		ProductItem()

		Box(
			modifier = Modifier
				.align(Alignment.BottomCenter)
				// регулируй под высоту NavigationBar
				.fillMaxWidth()
				.background(Color(0xFF00C853), shape = RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp))
				.padding(vertical = 22.dp, horizontal = 16.dp)
		) {
			Row(
				modifier = Modifier.fillMaxWidth(),
				horizontalArrangement = Arrangement.SpaceBetween,
				verticalAlignment = Alignment.CenterVertically
			) {
				Text("Перейти к оплате", color = Color.White)
				Row {
					Text("1 товар", color = Color.White)
					Spacer(modifier = Modifier.width(8.dp))
					Text("2175 ₸", color = Color.White)
				}
			}
		}
	}


}



@Preview
@Composable
fun ProductItem() {
	Row(modifier = Modifier
		.fillMaxWidth()
		.padding(20.dp)
		.clip(shape = RoundedCornerShape(10.dp))
		.background(Gray),
		verticalAlignment = Alignment.CenterVertically
	) {
		Image(
			painter = painterResource(R.drawable.image),
			contentDescription = "Локальное изображение",
			modifier = Modifier.width(120.dp).aspectRatio(3f/4f).padding(10.dp).background(Orange)
		)
		Column(verticalArrangement = Arrangement.spacedBy(20.dp)){
			Text("кроссовки")
			Text("рейтинг")
			Text("Цена")
		}


	}
}

