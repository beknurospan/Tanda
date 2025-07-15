package com.beknur.productdetail.composables

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable


@Composable
fun AboutBrand(text: String) {
	CardWhite {
		Column {
			Text("О Бренде")
			Text("Бренд назвние")
			Text(text)

		}
	}
}