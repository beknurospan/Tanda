package com.beknur.productdetail.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.content.MediaType.Companion.Text
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Composable
fun SizeBox(size:String,color:Color,onClick: () -> Unit) {
	Box(
		modifier = Modifier
			.size(34.dp)
			.clickable { onClick.invoke() }
			.background(color),
		contentAlignment = Alignment.Center
	) {
		Text(size)
	}
}

@Preview()
@Composable
fun SizeBoxPreview() = SizeBox(size="36",Color.White) { }