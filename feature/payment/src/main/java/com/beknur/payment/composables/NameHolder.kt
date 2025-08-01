package com.beknur.payment.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.beknur.designsystem.theme.Gray
import com.beknur.designsystem.theme.WhiteAdd
import com.beknur.designsystem.ui.TndButton


@Composable
fun NameHolder(name: String) {
	val isNameExist = name.isNotBlank()

	Column(
		modifier = Modifier
			.fillMaxWidth()
			.background(Color.White)
			.padding(20.dp)
	) {
		Text(
			text = if (isNameExist) {
				"Заказ получить - $name"
			} else {
				"Заказ получить - Выйдет имя после заполнения"
			}
		)
		if (!isNameExist) {
			Button (
				onClick = {},
				modifier = Modifier.fillMaxWidth(),
				shape = RoundedCornerShape(4.dp),
				colors = ButtonColors(Color.Gray, WhiteAdd, Color.Gray, WhiteAdd)
			){
				Text("Нажмите чтобы заполнить ")
			}
		}
	}
}


@Preview
@Composable
fun NameHolderPreview() {
	NameHolder("")

}