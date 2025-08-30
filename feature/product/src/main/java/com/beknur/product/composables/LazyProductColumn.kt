package com.beknur.product.composables

import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import com.beknur.designsystem.ui.ProductDetailCard
import com.beknur.domain.model.Product

@Composable
fun LazyProductColumn(products: List<Product>, onClick: (productId:Int,skuId:Int) -> Unit) {
	LazyVerticalGrid(
		columns = GridCells.Fixed(2),
		contentPadding = PaddingValues(12.dp),
		horizontalArrangement = Arrangement.spacedBy(14.dp),
		verticalArrangement = Arrangement.spacedBy(14.dp)
	) {
		items(products) { product ->

			ProductDetailCard(
				product.rating.toString(),
				product.brandName,
				product.name,
				product.price.toString(),
				image = product.img,
				onClick = { onClick.invoke(product.productId,product.skuId) }
			)


		}
	}
}

@Preview
@Composable
fun LazyProductColumnPreview() {
	LazyProductColumn(
		listOf(
			Product(
				1,
				5,
				5,
				listOf(1, 5, 6),
				4.7,
				"Кроссовки",
				"nike",
				img = ""
			)
		),
		onClick = {p1,p2-> Unit}
	)
}