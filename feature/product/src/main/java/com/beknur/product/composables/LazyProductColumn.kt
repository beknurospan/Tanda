package com.beknur.product.composables

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import com.beknur.designsystem.ui.ProductDetailCard

@Composable
fun LazyProductColumn(onClick:()->Unit) {
	LazyVerticalGrid(
		columns = GridCells.Fixed(2),
		contentPadding = PaddingValues(12.dp),
		horizontalArrangement = Arrangement.spacedBy(14.dp),
		verticalArrangement = Arrangement.spacedBy(14.dp)
	) {
		items(20) { index ->

			ProductDetailCard(onClick)


		}
	}
}