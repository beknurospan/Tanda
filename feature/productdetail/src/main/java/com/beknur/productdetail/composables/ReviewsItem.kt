package com.beknur.productdetail.composables

import android.graphics.drawable.Icon
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.key.Key.Companion.I
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Composable
fun ReviewsItem(rating:String) {
	CardWhite {
		Row(modifier = Modifier
			.fillMaxWidth()
			.padding(5.dp)) {

		}
		Text(rating)
	}
}


@Preview
@Composable
fun ReviewsItemPreview(){
	ReviewsItem("4.0")
}