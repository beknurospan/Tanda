package com.beknur.address.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.beknur.designsystem.ui.TndButton
import com.beknur.domain.model.Address
import com.beknur.domain.model.MySearchResult


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddressScreenFill(
	onAddressClick: () -> Unit,
	address: String,
	apartment: String,
	entrance: String,
	floor: String,
	streetNumber: String,
	onApartmentChange: (String) -> Unit,
	onEntranceChange: (String) -> Unit,
	onFloorChange: (String) -> Unit,
	showBottomSheet: Boolean,
	onDismissRequest: () -> Unit,
	searchQuery: String,
	onSearchQueryChange: (String) -> Unit,
	searchQueryResult: List<MySearchResult>,
	onResultClick: (MySearchResult) -> Unit,
	onConfirmAddress: (Address) -> Unit
) {

	val sheetState = rememberModalBottomSheetState(
		skipPartiallyExpanded = true
	)
	val coroutineScope = rememberCoroutineScope()
	Column(
		modifier = Modifier
			.fillMaxSize()
			.background(Color.White)
			.padding(20.dp),
		verticalArrangement = Arrangement.spacedBy(15.dp)
	) {
		Spacer(modifier = Modifier.height(30.dp))
		OutlinedTextField(
			enabled = false,
			value = "Алматы",
			onValueChange = {},
			modifier = Modifier
				.fillMaxWidth(),
			label = { Text("Город") }
		)

		OutlinedTextField(
			enabled = false,
			value = address,
			onValueChange = {},
			modifier = Modifier
				.fillMaxWidth()
				.clickable { onAddressClick.invoke() },
			label = { Text(streetNumber) },
			colors = OutlinedTextFieldDefaults.colors(
				disabledTextColor = Color.Black,
				disabledBorderColor = Color.Black,
				disabledLabelColor = Color.Black,
				disabledPlaceholderColor = Color.Black
			)

		)


		Row(
			modifier = Modifier
				.fillMaxWidth(),
			horizontalArrangement = Arrangement.spacedBy(10.dp)
		) {
			OutlinedTextField(
				value = apartment,
				onValueChange = { newApartment ->
					onApartmentChange.invoke(newApartment)
				},
				modifier = Modifier
					.weight(1f),
				label = { Text("Кв") }

			)
			OutlinedTextField(
				value = entrance,
				onValueChange = { newEntrance ->
					onEntranceChange.invoke(newEntrance)
				},
				modifier = Modifier
					.weight(1f),
				label = { Text("Подъезд") }

			)
			OutlinedTextField(
				value = floor,
				onValueChange = { newFloor ->
					onFloorChange.invoke(newFloor)
				},
				modifier = Modifier
					.weight(1f),
				label = { Text("Этаж") }

			)

		}

		Spacer(modifier = Modifier.height(30.dp))
		TndButton(
			isEnabled = true,
			text = "Подвердить адрес",
			onClick = {
				onConfirmAddress.invoke(
					Address(
						address = address,
						apartment = apartment,
						entrance = entrance,
						floor = floor
					)
				)
			},
			modifier = Modifier.fillMaxWidth()
		)
		if (showBottomSheet) {
			ModalBottomSheet(
				onDismissRequest = { onDismissRequest.invoke() },
				sheetState = sheetState
			) {

				AddressSearchScreen(
					searchQuery = searchQuery,
					onSearchQueryChange = onSearchQueryChange,
					searchResults = searchQueryResult,
					onResultClick = onResultClick
				)


			}
		}
	}
}

@Preview
@Composable
fun AddressScreenPreview() {
	AddressScreenFill(
		{}, "", "", "", "", "", {}, {}, {}, false, {},
		searchQuery = "TODO()",
		onSearchQueryChange = {},
		searchQueryResult = listOf(MySearchResult("", "")),
		onResultClick = {},
		onConfirmAddress = {}
	)
}