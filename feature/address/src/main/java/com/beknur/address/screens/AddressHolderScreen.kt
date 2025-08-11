package com.beknur.address.screens


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.beknur.address.AddressUiEvent
import com.beknur.address.composables.AddressConfigDialog
import com.beknur.designsystem.ui.AddressItem
import com.beknur.designsystem.ui.TndButton
import com.beknur.domain.model.Address

@Composable
fun AddressHolderScreen(
	isAddressExist: Boolean,
	addressList: List<Address>,
	showDialog: Boolean,
	onAddButtonClick: () -> Unit,
	onItemClick: (Int) -> Unit,
	onActionEditClick: () -> Unit,
	onActionDeleteClick: () -> Unit,
	onActionMakePrimaryClick: () -> Unit,
	onActionCancelClick: () -> Unit
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
			if (isAddressExist) {
				Text("Здесь пока ничего нет")
			} else {
				LazyColumn(
					modifier = Modifier
						.weight(1f)
						.padding(20.dp),
					verticalArrangement = Arrangement.spacedBy(10.dp)
				) {
					items(addressList) { item ->
						AddressItem(
							address = item.address,
							apartment = item.apartment,
							floor = item.floor,
							entrance = item.entrance
						) {
							onItemClick.invoke(item.id)
						}
					}
				}
			}
			TndButton(
				isEnabled = true,
				onClick = onAddButtonClick,
				text = "Добавить новый адрес",
				modifier = Modifier
					.fillMaxWidth()
					.padding(horizontal = 20.dp)
			)
			Spacer(modifier = Modifier.height(100.dp))
		}
		if (showDialog){
			AddressConfigDialog(
				onDismiss =onActionCancelClick,
				onDelete = onActionDeleteClick,
				onEdit = onActionEditClick,
				onMakePrimary = onActionMakePrimaryClick
			)
		}

	}
}

@Preview
@Composable
fun AddressHolderScreenPreview() {
	AddressHolderScreen(
		false,
		listOf<Address>(
			Address(
				address = "",
				apartment = "",
				entrance = "",
				floor = ""
			)
		),
		showDialog = false,
		onAddButtonClick = {},
		onItemClick = {},
		onActionEditClick = {},
		onActionDeleteClick = {},
		onActionCancelClick = {},
		onActionMakePrimaryClick = {},
	)
}