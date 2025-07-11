package com.beknur.designsystem.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Composable
fun TndButton(isEnabled: Boolean, onClick: () -> Unit, text: String,modifier: Modifier=Modifier) {
	val bgColor = if (isEnabled) Color.Green else Color.Gray

	Button(
		enabled = isEnabled,
		shape = RoundedCornerShape(8.dp),
		modifier = modifier,
		colors =ButtonDefaults.buttonColors(
			containerColor = Color.Green,
			contentColor = Color.White,
			disabledContentColor = Color.Gray,
			disabledContainerColor = Color.Gray
		),
		onClick = { onClick.invoke() }) {
		Text(text)
	}
}

@Preview
@Composable
fun TndButtonPreview() {
	TndButton(true, {}, "Добавить в корзину")
}