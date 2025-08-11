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


val TIME_SLOTS = listOf(
	"07:00 - 09:00",
	"08:00 - 10:00",
	"09:00 - 11:00",
	"10:00 - 12:00",
	"11:00 - 13:00",
	"12:00 - 14:00",
	"13:00 - 15:00",
	"14:00 - 16:00",
	"15:00 - 17:00",
	"16:00 - 18:00",
	"17:00 - 19:00",
	"18:00 - 20:00",
	"19:00 - 21:00",
	"20:00 - 22:00",
	"21:00 - 23:00",
	"22:00 - 00:00"
)


@Composable
fun TimePicker(onButtonClick:(String)->Unit) {
	var selectedTime by remember { mutableStateOf<String>("") }

	Column(
		modifier = Modifier
			.background(Color.White)
			.padding(16.dp),
		verticalArrangement = Arrangement.spacedBy(5.dp)
	) {
		Text("Выберите удобное вам время доставки")
		Spacer(modifier = Modifier.height(10.dp))
		TIME_SLOTS.chunked(2).forEach { row ->
			Row(
				modifier = Modifier.fillMaxWidth(),
				horizontalArrangement = Arrangement.spacedBy(5.dp)
			) {
				row.forEach { timeRange ->
					TimeItem(
						timeRange = timeRange,
						isSelected = selectedTime == timeRange,
						onClick = { selectedTime = timeRange },
						modifier = Modifier.weight(1f)
					)
				}
			}
		}

		val isButtonEnabled= selectedTime.isNotBlank()
		TndButton(isEnabled = isButtonEnabled, onClick = {onButtonClick.invoke(selectedTime.toString())}, "Применить", modifier = Modifier.fillMaxWidth())
	}
}


@Preview
@Composable
fun TimePickerPreview() {
	TimePicker(){}
}