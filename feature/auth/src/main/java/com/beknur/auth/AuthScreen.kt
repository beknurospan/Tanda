package com.beknur.auth

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.beknur.designsystem.theme.Gray

@Preview
@Composable
fun AuthScreen() {
	Column(
		modifier = Modifier
			.fillMaxSize()
			.background(Color.White),
	) {

		LazyColumn(
			modifier = Modifier
				.fillMaxSize()
				.background(Color.White),
			contentPadding = PaddingValues(vertical = 16.dp),
			verticalArrangement = Arrangement.spacedBy(12.dp)
		) {
			items(9) {
				ProfileItem()
			}

		}


	}
}

@Preview
@Composable
fun ProfileItem() {
	Card(
		modifier = Modifier
			.fillMaxWidth()
			.height(60.dp)
			.padding(horizontal = 20.dp),
		colors = CardDefaults.cardColors(containerColor = Color.White),
		elevation = CardDefaults.cardElevation(defaultElevation = 8.dp)
	) {

	}
}



