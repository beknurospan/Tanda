package com.beknur.cart.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.content.MediaType.Companion.Text
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.beknur.domain.model.ProductVariants

@Composable
fun BottomSheetComponent(productVariants: List<ProductVariants>,onClick: (Int) -> Unit){
	Column(
		modifier = Modifier
			.fillMaxWidth()
			.fillMaxHeight(0.6f)
			.background(Color.White)
	) {
		Text("Выберите размер товара")
		LazyColumn {
			items(productVariants) { variant->
				SizeItemBottomSheet(variant.size.toString()){
					onClick.invoke(variant.skuId)
				}
			}
		}
	}
}