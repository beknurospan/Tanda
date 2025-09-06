package com.beknur.payment.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview


@Composable
fun SuccessResultScreen(
	numberOrder:String,

){
	Column(
		modifier = Modifier.fillMaxSize()
			.background(Color.White),
		verticalArrangement = Arrangement.Center,
		horizontalAlignment = Alignment.CenterHorizontally
	){
		Text("Спасибо за покупку!")
		Text("Номер Заказа №#$numberOrder")
		Text("Вы можете отследить заказ в разделе мои заказы")
	}
}

@Preview
@Composable
fun SuccessResultScreenPreview(){
	SuccessResultScreen("2121155")
}