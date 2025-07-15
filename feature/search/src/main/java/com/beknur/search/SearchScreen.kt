package com.beknur.search

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.beknur.designsystem.ui.SearchTextField

@Preview
@Composable
fun SearchScreen() {
	Column(
		modifier = Modifier
			.fillMaxSize()
			.background(Color.White)
			.padding(horizontal = 30.dp)
	) {
		Spacer(modifier = Modifier.height(30.dp))
		SearchTextField()
	}
}


@Preview
@Composable
fun SearchScreenPreivew() {
	SearchScreen()
}