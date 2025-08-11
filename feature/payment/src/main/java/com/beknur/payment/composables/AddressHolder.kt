package com.beknur.payment.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.beknur.designsystem.ui.AddressItem

@Preview
@Composable
fun AddressHolderPreview() {
	AddressHolder(
		additionalAddress = "",
		address = "",
		apartment = "",
		entrance = "",
		floor = "",
		onClick = {},
		onAdditionalInfoChange = {}
	)
}


@Composable
fun AddressHolder(
	additionalAddress: String,
	address: String,
	floor: String,
	apartment: String,
	entrance: String,
	onClick:()->Unit,
	onAdditionalInfoChange:(String)->Unit
) {
	Column(modifier = Modifier
		.fillMaxWidth()
		.background(Color.White)
		.padding(10.dp),
		verticalArrangement = Arrangement.spacedBy(20.dp)
	) {
		Row {
			Text("Адрес Доставки")
			Spacer(modifier = Modifier.weight(1f))

			Text("Изменить", modifier = Modifier.clickable {onClick.invoke() })


		}
		AddressItem(
			address=address,
			apartment = apartment,
			floor = floor,
			entrance = entrance,
			onClick = onClick
		)
		OutlinedTextField(
			value = additionalAddress,
			onValueChange = { newText->
				onAdditionalInfoChange(newText)
			},
			modifier = Modifier
				.fillMaxWidth(),
			label = { Text("Дополнение к адресу") }

		)
	}
}