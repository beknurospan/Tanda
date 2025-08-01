package com.beknur.address

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.beknur.designsystem.ui.TndButton


@Preview
@Composable
fun AddressScreenPreview() {
	AddressScreen(viewState = AddressViewState(""),{})
}

@Composable
fun AddressScreenRoute(viewModel: AddressViewModel){
		val viewState by viewModel.viewState.collectAsStateWithLifecycle()
		AddressScreen(viewState,viewModel::handleEvent)
}

@Composable
fun AddressScreen(
	viewState: AddressViewState,
	sendUiEvent: (AddressUiEvent)->Unit
) {
	Box(
		modifier = Modifier
			.fillMaxSize()
			.background(Color.White),
		contentAlignment = Alignment.Center
	) {
		Column(
			horizontalAlignment = Alignment.CenterHorizontally,
			verticalArrangement = Arrangement.spacedBy(20.dp)
		) {
			Text("Здесь пока ничего нет")
			TndButton(isEnabled = true, onClick = {}, text = "Добавить новый адрес")
		}

	}
}


@Preview
@Composable
fun AddressScreenFill() {
	Column(
		modifier = Modifier
			.fillMaxSize()
			.background(Color.White)
			.padding(20.dp),
		verticalArrangement = Arrangement.spacedBy(15.dp)
	) {
		Spacer(modifier = Modifier.height(30.dp))
		OutlinedTextField(
			value = "Алматы",
			onValueChange = {},
			modifier = Modifier
				.fillMaxWidth(),
			label = { Text("Город") }
		)
		OutlinedTextField(
			value = "",
			onValueChange = {},
			modifier = Modifier
				.fillMaxWidth(),
			label = { Text("Улица и номер дома") }

		)
		Row(
			modifier = Modifier
				.fillMaxWidth(),
			horizontalArrangement = Arrangement.spacedBy(10.dp)
		) {
			OutlinedTextField(
				value = "",
				onValueChange = {},
				modifier = Modifier
					.weight(1f),
				label = { Text("Кв") }

			)
			OutlinedTextField(
				value = "",
				onValueChange = {},
				modifier = Modifier
					.weight(1f),
				label = { Text("Подъезд") }

			)
			OutlinedTextField(
				value = "",
				onValueChange = {},
				modifier = Modifier
					.weight(1f),
				label = { Text("Этаж") }

			)

		}
		OutlinedTextField(
			value = "",
			onValueChange = {},
			modifier = Modifier
				.fillMaxWidth(),
			label = { Text("Дополнение к адресу") }

		)
		Spacer(modifier = Modifier.height(30.dp))
		TndButton(
			isEnabled = true,
			text = "Подвердить адрес",
			onClick = {},
			modifier = Modifier.fillMaxWidth()
		)
	}
}