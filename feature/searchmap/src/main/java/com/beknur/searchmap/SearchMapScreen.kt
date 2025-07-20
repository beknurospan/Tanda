package com.beknur.searchmap

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview
@Composable
fun SearchMapScreenPreview() {

	SearchMapScreen()
}





@Composable
fun SearchMapScreen() {
	Column(
		modifier = Modifier
			.fillMaxSize()
			.background(Color.White)
			.padding(16.dp)
	) {
		OutlinedTextField(
			value = "",
			onValueChange = {},
			modifier = Modifier
				.fillMaxWidth(),
			label = { Text("Улица и номер дома") }

		)
	}
}


