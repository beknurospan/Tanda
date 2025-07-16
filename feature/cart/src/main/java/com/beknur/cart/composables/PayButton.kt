package com.beknur.cart.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.beknur.designsystem.theme.Green

@Composable
fun PayButton(modifier: Modifier) {
	Row(
		modifier = modifier
			.fillMaxWidth()
			.background(Green, shape = RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp))
			.padding(vertical = 22.dp, horizontal = 16.dp)
	) {
		Text("Перейти к оплате", color = Color.White)
		Spacer(modifier = Modifier.weight(1f))
		Text("1 товар", color = Color.White)
		Spacer(modifier = Modifier.width(8.dp))
		Text("2175 ₸", color = Color.White)
	}
}
