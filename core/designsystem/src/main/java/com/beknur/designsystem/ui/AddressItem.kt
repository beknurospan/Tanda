package com.beknur.designsystem.ui

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp



@Composable
fun AddressItem(text:String,onClick:()->Unit) {
	Column (
		modifier = Modifier
			.fillMaxWidth()
			.clip(RoundedCornerShape(8.dp))
			.background(Color.Transparent)
			.border(1.dp, Color.Black, RoundedCornerShape(8.dp))
			.clickable {
				onClick.invoke()
			}
	) {
		Column(modifier = Modifier.padding(16.dp)) {
			Text(text)
		}
	}
}


@Preview
@Composable
fun AddressItemPreview() {
	AddressItem("Almaty"){}
}