package com.beknur.productdetail

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.beknur.designsystem.theme.WhiteGray
import com.beknur.designsystem.ui.TndButton
import com.beknur.domain.model.Characteristic
import com.beknur.domain.model.ProductDetail
import com.beknur.domain.model.SizeItem
import com.beknur.domain.util.Loadable
import com.beknur.productdetail.composables.AboutProduct
import com.beknur.productdetail.composables.CardWhite
import com.beknur.productdetail.composables.HeartRating
import com.beknur.productdetail.composables.InOtherColorItem
import com.beknur.productdetail.composables.ProductPhotoCarousel
import com.beknur.productdetail.composables.ReviewsItem


@Composable
fun ProductDetailRoute(viewModel: ProductDetailViewModel) {

	val viewState by viewModel.viewState.collectAsStateWithLifecycle()


	ProductDetailScreen(viewState, viewModel::handleEvent)

}


@Composable
fun ProductDetailScreen(

	viewState: ProductDetailViewState,
	sendUiEvent: (ProductDetailUiEvent) -> Unit
) {

	when (viewState.productDetail) {
		is Loadable.Error -> {}
		Loadable.Idle -> {}
		Loadable.Loading -> {}
		is Loadable.Success<ProductDetail> -> {
			val productDetail = viewState.productDetail.data

			Column(
				modifier = Modifier
					.fillMaxSize()
					.background(color = WhiteGray)
					.verticalScroll(rememberScrollState()),
				verticalArrangement = Arrangement.spacedBy(5.dp)

			) {

				ProductPhotoCarousel(productDetail.imageList)
				Column(
					modifier = Modifier.padding(horizontal = 5.dp),
					verticalArrangement = Arrangement.spacedBy(5.dp)
				) {
					CardWhite {
						HeartRating(
							productDetail.rating,
							5,
							productDetail.sizes,
							name = productDetail.name,
							brandName = productDetail.brandName,
							price = productDetail.price.toString(),
							onSizeSelected = { sendUiEvent(ProductDetailUiEvent.OnSizeSelected(it)) },
							selectedSize = viewState.selectedSize,
							onHeartClick = { sendUiEvent(ProductDetailUiEvent.OnHeartClicked) },
							isFavorite = productDetail.isFavorite
						)
						Spacer(modifier = Modifier.height(60.dp))
						TndButton(
							true, {
								sendUiEvent(
									ProductDetailUiEvent.OnAddCartClicked(
										productDetail.productId,
										productDetail.sizes.first { it.size == viewState.selectedSize }.skuId
									)
								)
							}, "Добавить", modifier = Modifier
								.fillMaxWidth()
								.height(57.dp)
						)
						Spacer(modifier = Modifier.height(60.dp))

					}

				}
				InOtherColorItem(
					"https://www.pngplay.com/wp-content/uploads/12/Running-Shoes-PNG-Clip-Art-HD-Quality.png",
					"Оранжевый",
					Modifier
						.fillMaxWidth()
						.padding(horizontal = 10.dp)
				)
				Column(
					modifier = Modifier.padding(horizontal = 5.dp),
					verticalArrangement = Arrangement.spacedBy(3.dp)
				) {
					AboutProduct(
						"25",
						productDetail.characteristics
					)
					ReviewsItem(productDetail.rating.toString())

				}


			}
		}
	}
}

@Preview()
@Composable
fun ProductDetailScreenPreview() {
	ProductDetailScreen(
		ProductDetailViewState(
			productDetail = Loadable.Success(
				ProductDetail(
					productId = 1,
					price = 4500.0,
					sizes = listOf(
						SizeItem(skuId = 1,size=37, isAvailable = false, count = 0),
						SizeItem(skuId = 2,size=38, isAvailable = true, count = 5),
						SizeItem(skuId=3,size = 41, isAvailable = true, count = 10),
					),
					rating = 4.5,
					name = "Dino Ricce Кроссовки Черный",
					brandName = "Adidas",
					imageList = listOf(""),
					isFavorite = false,
					otherColors = listOf(),
					characteristics = listOf(Characteristic(1, "", ""))
				),
			)
		),
		sendUiEvent = {},
	)
}



