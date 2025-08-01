package com.beknur.payment.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.beknur.designsystem.theme.Orange


@Composable
fun CardItem() {
	Column(modifier = Modifier
		.height(80.dp)
		.width(140.dp)
		.clip(RoundedCornerShape(8.dp))
		.background(Orange)
		.padding(20.dp)
	) {
		Text("Jusan Bank")
		Text("***** 5895")
	}
}



@Preview
@Composable
fun CardItemPreview() {
	CardItem()
}