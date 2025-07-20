package com.beknur.profiledata

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Composable
fun ProfileDataScreen() {
	Column(
		modifier = Modifier
			.fillMaxSize()
			.background(Color.White)
			.padding(30.dp),
		horizontalAlignment = Alignment.CenterHorizontally
	) {
		MyDataFields()
	}

}

@Composable
private fun MyDataFields() {
	Column(verticalArrangement = Arrangement.spacedBy(10.dp), modifier = Modifier.fillMaxWidth()) {
		Text("Имя")
		OutlinedTextField("Бекнур", {}, modifier = Modifier.fillMaxWidth())
		Text("Дата")
		OutlinedTextField("9 June 2025", {},modifier = Modifier.fillMaxWidth())
		Text("Номер")
		OutlinedTextField("Номер телефона", {},modifier = Modifier.fillMaxWidth())
	}
}


@Preview
@Composable
fun ProfileDataScreenPreview() {
	ProfileDataScreen()
}