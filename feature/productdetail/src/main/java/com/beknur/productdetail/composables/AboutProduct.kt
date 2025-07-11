package com.beknur.productdetail.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.beknur.productdetail.data.ItemInfo

@Preview
@Composable
fun AboutProductPreview() {
	AboutProduct("25", listOf(ItemInfo("v" , "s"), ItemInfo("l","b")))

}


@Composable
fun AboutProduct(articule:String,mapData:List<ItemInfo>) {

	Column {
		Text("О товаре")
		for(item in mapData){
			Text(item.key)
			Text(item.value)
		}
		Text(articule)
	}



}