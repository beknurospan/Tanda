package com.beknur.payment.composables

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
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
import com.beknur.designsystem.theme.Gray
import com.beknur.designsystem.theme.Green


@Composable
fun TimeItem(
	timeRange: String,
	isSelected: Boolean,
	modifier: Modifier = Modifier,
	onClick: () -> Unit
) {


	val bgColor=if (isSelected) Green else Gray

	Box(
		modifier = modifier
			.clip(RoundedCornerShape(2.dp))
			.background(Color.White)
			.border(border = BorderStroke(2.dp, color = bgColor), shape = RoundedCornerShape(2.dp))
			.clickable(onClick = onClick)
			.padding(16.dp),
		contentAlignment = Alignment.Center
	) {
		Text(timeRange, color = Color.Black)
	}
}


@Preview
@Composable
fun TimeItemPreview() {
	TimeItem("07:00 - 09:00", true) {}
}