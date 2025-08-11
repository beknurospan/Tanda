package com.beknur.payment.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.beknur.designsystem.ui.TndButton


@Composable
fun NameSheetContent(onClick:(String)->Unit) {
	var text by remember { mutableStateOf("") }
	Column(modifier = Modifier
		.fillMaxWidth()
		.background(Color.White)
		.padding(40.dp)
	) {
		OutlinedTextField(
			value = text,
			onValueChange = { text = it },
			modifier = Modifier.fillMaxWidth(),
			placeholder = { Text("Введите ваше имя") }
		)
		Spacer(modifier = Modifier.height(30.dp))
		TndButton(true, onClick = { onClick.invoke(text) }, "Сохранить", modifier = Modifier.fillMaxWidth())
	}
}

@Preview
@Composable
fun NameSheetContentPreview() {
	NameSheetContent({})
}