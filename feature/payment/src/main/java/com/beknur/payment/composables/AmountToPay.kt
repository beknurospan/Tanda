package com.beknur.payment.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp




@Composable
fun AmountToPay(
	amount: String,
	currency: String = "₸",
	modifier: Modifier = Modifier
) {
	Column (
		modifier = modifier
			.fillMaxWidth()
			.height(400.dp)
			.background(Color.White)
	) {
		Column(modifier = Modifier.padding(16.dp)) {

			Text(
				text = "К ОПЛАТЕ",
				modifier = Modifier.fillMaxWidth(),
				style = MaterialTheme.typography.labelLarge.copy(
					fontFamily = FontFamily.Monospace,
					fontWeight = FontWeight.Medium,
					fontSize = 16.sp,
					textAlign = TextAlign.Center
				)
			)

			Spacer(Modifier.height(12.dp))

			Divider(
				color = Color.Gray,
				thickness = 1.dp,
				modifier = Modifier
					.fillMaxWidth()
					.drawWithContent {
						val dashWidth = 10.dp.toPx()
						val gapWidth = 5.dp.toPx()
						val totalWidth = size.width
						var currentX = 0f
						while (currentX < totalWidth) {
							drawLine(
								color = Color.Gray,
								start = Offset(currentX, 0f),
								end = Offset(currentX + dashWidth, 0f),
								strokeWidth = 2f
							)
							currentX += dashWidth + gapWidth
						}
					}
			)

			Spacer(Modifier.height(12.dp))

			Row(
				modifier = Modifier.fillMaxWidth(),
				horizontalArrangement = Arrangement.SpaceBetween
			) {
				Text(
					text = "Сумма:",
					style = MaterialTheme.typography.bodyLarge.copy(
						fontFamily = FontFamily.Monospace,
						fontSize = 18.sp
					)
				)
				Text(
					text = "$amount $currency",
					style = MaterialTheme.typography.bodyLarge.copy(
						fontFamily = FontFamily.Monospace,
						fontSize = 20.sp,
						fontWeight = FontWeight.Bold
					)
				)
			}

			Spacer(Modifier.height(12.dp))

			Divider(
				color = Color.Gray,
				thickness = 1.dp,
				modifier = Modifier
					.fillMaxWidth()
					.drawWithContent {
						val dashWidth = 10.dp.toPx()
						val gapWidth = 5.dp.toPx()
						val totalWidth = size.width
						var currentX = 0f
						while (currentX < totalWidth) {
							drawLine(
								color = Color.Gray,
								start = Offset(currentX, 0f),
								end = Offset(currentX + dashWidth, 0f),
								strokeWidth = 2f
							)
							currentX += dashWidth + gapWidth
						}
					}
			)
		}
	}
}


@Preview
@Composable
fun AmountToPayPreview(){
	AmountToPay("5777")
}
