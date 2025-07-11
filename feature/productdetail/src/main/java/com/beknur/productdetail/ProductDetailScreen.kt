package com.beknur.productdetail

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.beknur.productdetail.composables.SizeBox
import com.beknur.designsystem.R as coreR
import com.beknur.designsystem.ui.TndButton
import com.beknur.productdetail.composables.AboutBrand
import com.beknur.productdetail.composables.AboutProduct
import com.beknur.productdetail.composables.CardWhite
import com.beknur.productdetail.composables.ReviewsItem
import com.beknur.productdetail.data.ItemInfo

@Composable
fun ProductDetailScreen(
	photoList: List<String>
) {

	Column(
		modifier = Modifier
			.fillMaxSize()
			.background(color = Color.White)
			.verticalScroll(rememberScrollState()),

		) {

		ProductPhotoCarousel(photoList)
		Column(
			modifier = Modifier.padding(10.dp),
			verticalArrangement = Arrangement.spacedBy(20.dp)
		) {
			HeartRating(5.0)
			TndButton(
				true, {}, "Добавить", modifier = Modifier
					.fillMaxWidth()
					.height(57.dp)
			)
			Text("В других цветах")
			InOtherColorItem(
				"https://www.shoppingschool.ru/netcat_files/userfiles/Articles/2023/Travel_looks/travel5.jpeg",
				"Оранжевый"
			)
			CardWhite {
				AboutProduct(
					"25",
					listOf(
						ItemInfo("v", "s"),
						ItemInfo("l", "b"),
						ItemInfo("l", "b"),
						ItemInfo("l", "b"),
						ItemInfo("l", "b")
					)
				)
			}
			CardWhite {
				AboutBrand("Малчиьно")
			}
			CardWhite {
				ReviewsItem("5")
			}


		}


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
					.fillMaxWidth()
					.aspectRatio(3f / 4f)
					.background(Color.LightGray),
				onError = { Log.d("Async", it.toString(), it.result.throwable) })
		}
	}


}


@Composable
fun InOtherColorItem(img: String, colorText: String) {
	Box(modifier = Modifier.size(60.dp), contentAlignment = Alignment.Center) {
		AsyncImage(
			model = img,
			contentDescription = "",
			contentScale = ContentScale.Crop,
			modifier = Modifier
				.fillMaxWidth()
				.aspectRatio(3f / 4f)
				.clip(RoundedCornerShape(2.dp))
				.background(Color.Gray)
				.padding(5.dp)


		)
	}
	Text(colorText)
}

@Preview()
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


@Composable
fun HeartRating(rating: Double, max: Int = 5) {
	val sizes = listOf(
		SizeItem(35, true),
		SizeItem(36, true),
		SizeItem(37, true, count = 1),
		SizeItem(38, true),
		SizeItem(39, true),
		SizeItem(40, true),
		SizeItem(41, true),
		SizeItem(42, true),
		SizeItem(43, true),
		SizeItem(44, true),
		SizeItem(45, true),
		SizeItem(46, true)
	)


	Column(
		verticalArrangement = Arrangement.spacedBy(8.dp),

		) {
		Row(
			modifier = Modifier
				.fillMaxWidth()
				.height(50.dp),
			verticalAlignment = Alignment.CenterVertically
		) {

			repeat(max) { index ->
				val isFilled = index.toInt() < rating.toInt()
				Icon(
					imageVector = ImageVector.vectorResource(
						if (isFilled) coreR.drawable.star_4
						else coreR.drawable.star__1_
					),
					contentDescription = null,
					tint = Color.Unspecified,
					modifier = Modifier.size(24.dp)
				)


			}
			Spacer(modifier = Modifier.width(10.dp))
			Text("Рейтинг $rating")
			Spacer(modifier = Modifier.weight(1f))
			Icon(
				imageVector = ImageVector.vectorResource(coreR.drawable.shopicons_regular_heart),
				contentDescription = null,
				modifier = Modifier.size(40.dp)
			)


		}
		Text(
			"Dino Ricci Select",
			style = MaterialTheme.typography.bodyLarge
		)
		Text(
			"Ботильоны",
			style = MaterialTheme.typography.bodySmall
		)
		Text("26000 KZT", style = MaterialTheme.typography.bodyLarge)
		Spacer(modifier = Modifier.height(40.dp))
		Box(
			modifier = Modifier.fillMaxWidth(),
			contentAlignment = Alignment.Center
		) {
			SizeGrid(sizes = sizes, 2) { }
		}
	}
}


@Composable
fun SizeGrid(
	sizes: List<SizeItem>,
	selectedSize: Int?,
	onSizeSelected: (Int) -> Unit
) {
	FlowRow(

		verticalArrangement = Arrangement.spacedBy(8.dp),
		horizontalArrangement = Arrangement.spacedBy(8.dp)
	) {
		sizes.forEach { sizeItem ->
			Box(
				contentAlignment = Alignment.TopCenter
			) {
				Box(
					modifier = Modifier
						.size(55.dp)
						.clip(RoundedCornerShape(8.dp))
						.background(
							if (selectedSize == sizeItem.size) Color(0xFF66FF66)
							else Color.LightGray
						)
						.clickable { onSizeSelected(sizeItem.size) },
					contentAlignment = Alignment.Center
				) {
					Text(text = sizeItem.size.toString(), color = Color.Black)
				}

				if (sizeItem.count > 0) {
					Box(
						modifier = Modifier
							.offset(y = (-10).dp)
							.background(Color(0xFFFFCC99), shape = RoundedCornerShape(4.dp))
							.padding(horizontal = 4.dp, vertical = 2.dp)
					) {
						Text(
							text = "${sizeItem.count} шт.",
							fontSize = 10.sp,
							color = Color.Black
						)
					}
				}
			}
		}
	}
}

data class SizeItem(
	val size: Int,
	val isAvailable: Boolean,
	val count: Int = 0
)
