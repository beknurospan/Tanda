package com.beknur.product.composables

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.dp

data class Collestions(val isSelected:Boolean,val name:String)
val collestions = listOf(Collestions(true,"Все"),Collestions(false,"Темные"))
@Composable
fun LazyCollectionsRow(text: String) {
	LazyRow(
		verticalAlignment = Alignment.CenterVertically,
		horizontalArrangement = Arrangement.spacedBy(5.dp),
		contentPadding = PaddingValues(horizontal = 12.dp)
	) {
		items(collestions) { item->
			CategoryButtonCard(item.name,{},item.isSelected)
		}
	}
}