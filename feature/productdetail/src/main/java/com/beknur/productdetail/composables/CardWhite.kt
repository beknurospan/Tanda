package com.beknur.productdetail.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Preview
@Composable
fun CardWhitePreview() {
	CardWhite{
		Text("Test")
	}
}

@Composable
fun CardWhite(content: @Composable () -> Unit) {
	Box(
		Modifier
			.fillMaxWidth()
			.clip(RoundedCornerShape(4.dp))
			.background(Color.Gray)
			.padding(5.dp),
		contentAlignment = Alignment.TopStart
	) {
		content()
	}
}
