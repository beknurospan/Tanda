package com.beknur.profiledata

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview


@Composable
fun ProfileDataScreen(){
	Column(modifier = Modifier.fillMaxSize().background(Color.White)) {
		Text("Имя")
		TextField("Бекнур",{})
		Text("Дата")
		TextField("9 June 2025",{})
		Text("Номер")
		TextField("Номер телефона",{})


	}

}


@Preview
@Composable
fun ProfileDataScreenPreview(){
	ProfileDataScreen()
}