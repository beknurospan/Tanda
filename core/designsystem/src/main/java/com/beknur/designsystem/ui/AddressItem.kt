package com.beknur.designsystem.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Composable
fun AddressItem(
	address: String,
	apartment: String,
	floor: String,
	entrance: String,
	onClick: () -> Unit
) {
	Column(
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
			Text(address)
			if(apartment.isNotBlank()){
				Text("кв "+apartment)
			}
			if (floor.isNotBlank()){
				Text("этаж "+floor)
			}
			if (entrance.isNotBlank()){
				Text("подьезд "+entrance)
			}
		}
	}
}


@Preview
@Composable
fun AddressItemPreview() {
	AddressItem(
		"Almaty ыввввввввввввввввввввввввввввввввввввввввввввв ыыыыыыыыы",
		apartment = "8",
		floor = "9",
		entrance = "5"
	) {}
}