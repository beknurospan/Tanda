package com.beknur.favorites

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.beknur.designsystem.ui.ProductDetailCard
import com.beknur.domain.model.Favorite
import org.koin.androidx.compose.getViewModel


@Composable
fun FavoriteScreenRoute(
	viewModel: FavoriteViewModel
) {
	val viewState by viewModel.viewState.collectAsStateWithLifecycle()
	Log.d("beknurslog", "FavoriteScreenRoute: ${viewState.favorites} ")
	FavoritesScreen(viewState,viewModel::handleEvent)
}



@Composable
fun FavoritesScreen(
	viewState:FavoriteViewState,
	sendUiEvent:(FavoriteUiEvent)->Unit
) {
	Column(
		modifier = Modifier
			.fillMaxSize()
			.background(Color.White)

	) {
		ProductItem(
			viewState.favorites,
			onFavoriteClick = {},
			onHeartClick = {}
		)
	}
}


@Composable
fun ProductItem(
	favorites: List<Favorite>,
	onFavoriteClick:(Int)->Unit,
	onHeartClick:()->Unit
) {
	LazyVerticalGrid(
		modifier = Modifier.fillMaxSize(),
		columns = GridCells.Fixed(2),
		contentPadding = PaddingValues(horizontal = 10.dp, vertical = 20.dp),
		horizontalArrangement = Arrangement.spacedBy(10.dp),
		verticalArrangement = Arrangement.spacedBy(10.dp)
	) {
		items(favorites) { favorite ->
			ProductDetailCard(
				rating="",
				brandName=favorite.brandName,
				name=favorite.name,
				image = favorite.img,
				price = favorite.price.toString(),
			){
				
			}
		}
	}
}
