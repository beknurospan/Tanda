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
import androidx.compose.runtime.getValue
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
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import coil.compose.AsyncImage
import com.beknur.designsystem.theme.GreenDark
import com.beknur.designsystem.theme.WhiteGray
import com.beknur.designsystem.theme.WhiteLight
import com.beknur.designsystem.R as coreR
import com.beknur.designsystem.ui.TndButton
import com.beknur.productdetail.composables.AboutBrand
import com.beknur.productdetail.composables.AboutProduct
import com.beknur.productdetail.composables.CardWhite
import com.beknur.productdetail.composables.HeartRating
import com.beknur.productdetail.composables.InOtherColorItem
import com.beknur.productdetail.composables.ProductPhotoCarousel
import com.beknur.productdetail.composables.ReviewsItem
import com.beknur.productdetail.composables.SizeGrid
import com.beknur.productdetail.data.ItemInfo
import com.beknur.productdetail.data.SizeItem


@Composable
fun ProductDetailRoute(viewModel: ProductDetailViewModel) {

	val viewState by viewModel.viewState.collectAsStateWithLifecycle()
	ProductDetailScreen(viewState, viewModel::handleEvent)

}


@Composable
fun ProductDetailScreen(

	viewState: ProductDetialViewState,
	sendUiEvent: (ProductDetailUiEvent) -> Unit
) {

	val photoList = listOf(
		"https://www.pngplay.com/wp-content/uploads/12/Running-Shoes-PNG-Clip-Art-HD-Quality.png",
		"https://www.pngplay.com/wp-content/uploads/12/Running-Shoes-PNG-Clip-Art-HD-Quality.png",
		"https://www.pngplay.com/wp-content/uploads/12/Running-Shoes-PNG-Clip-Art-HD-Quality.png"
	)

	Column(
		modifier = Modifier
			.fillMaxSize()
			.background(color = WhiteGray)
			.verticalScroll(rememberScrollState()),
		verticalArrangement = Arrangement.spacedBy(5.dp)

		) {

		ProductPhotoCarousel(photoList)
		Column(
			modifier = Modifier.padding(horizontal = 5.dp),
			verticalArrangement = Arrangement.spacedBy(5.dp)
		) {
			CardWhite {
				HeartRating(5.0)
				Spacer(modifier = Modifier.height(60.dp))
				TndButton(
					true, {}, "Добавить", modifier = Modifier
						.fillMaxWidth()
						.height(57.dp)
				)
				Spacer(modifier = Modifier.height(60.dp))

			}

		}
		InOtherColorItem(
			"https://www.pngplay.com/wp-content/uploads/12/Running-Shoes-PNG-Clip-Art-HD-Quality.png",
			"Оранжевый",
			Modifier.fillMaxWidth().padding(horizontal = 10.dp)
		)
		Column(modifier = Modifier.padding(horizontal = 5.dp), verticalArrangement = Arrangement.spacedBy(3.dp)) {
			AboutProduct(
				"25",
				listOf(
					ItemInfo("Качество", "Говно"),
					ItemInfo("Страна", "Китай"),
					ItemInfo("Размер", "Руский"),
					ItemInfo("Цена", "норм")
				)
			)
			AboutBrand("Малчиьно")
			ReviewsItem("5")

		}



	}
}

@Preview()
@Composable
fun ProductDetailScreenPreview() {
	ProductDetailScreen(ProductDetialViewState(""), {})
}



