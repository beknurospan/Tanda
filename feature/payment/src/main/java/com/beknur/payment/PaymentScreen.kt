package com.beknur.payment

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.beknur.designsystem.theme.WhiteLight
import com.beknur.designsystem.ui.TndButton
import com.beknur.domain.model.Address
import com.beknur.payment.composables.AddressHolder
import com.beknur.payment.composables.AmountToPay
import com.beknur.payment.composables.CardHolder
import com.beknur.payment.composables.NameHolder
import com.beknur.payment.composables.NameSheetContent
import com.beknur.payment.composables.TimeHolder
import com.beknur.payment.composables.TimePicker


@Composable
fun PaymentScreenRoute(viewModel: PaymentViewModel) {
	val viewState by viewModel.viewState.collectAsStateWithLifecycle()
	PaymentScreen(viewState, viewModel::handleEvent)
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PaymentScreen(viewState: PaymentViewState, sendUiEvent: (PaymentUiEvent) -> Unit) {
	Box() {
		val sheetState = rememberModalBottomSheetState(
			skipPartiallyExpanded = true
		)
		Column(
			modifier = Modifier
				.fillMaxSize()
				.background(color = WhiteLight)
				.verticalScroll(
					rememberScrollState()
				),
			verticalArrangement = Arrangement.spacedBy(15.dp)
		) {

			NameHolder(viewState.name) { sendUiEvent(PaymentUiEvent.OnFillNameClick) }
			TimeHolder(viewState.time) { sendUiEvent(PaymentUiEvent.OnChangeTimeClick) }
			AddressHolder(
				additionalAddress = viewState.additionalAddressInfo,
				address = viewState.chosenAddress.address,
				floor = viewState.chosenAddress.floor,
				apartment = viewState.chosenAddress.apartment,
				entrance = viewState.chosenAddress.entrance,
				onAdditionalInfoChange = { sendUiEvent(PaymentUiEvent.OnAdditionalInfoChange(it)) },
				onClick= { sendUiEvent(PaymentUiEvent.OnChangeAddressClick) }
			)
			CardHolder() { sendUiEvent(PaymentUiEvent.OnAddCardClick) }
			AmountToPay(
				viewState.totalPrice
			)

		}
		Column(
			modifier = Modifier
				.fillMaxWidth()
				.height(80.dp)
				.align(Alignment.BottomCenter),
			verticalArrangement = Arrangement.Center
		) {
			TndButton(isEnabled = true, {

			}, "Оплатить", modifier = Modifier.fillMaxWidth())

		}
		if (viewState.showBottomSheet) {
			ModalBottomSheet(
				onDismissRequest = { sendUiEvent(PaymentUiEvent.ChangeBottomSheetState) },
				sheetState = sheetState,
			) {
				when (viewState.sheetType) {
					SheetType.NAME -> {
						NameSheetContent { name -> sendUiEvent(PaymentUiEvent.OnSaveNameClick(name)) }
					}

					SheetType.TIME -> {
						TimePicker() { time ->
							sendUiEvent(PaymentUiEvent.OnSaveTimeClick(time))
						}
					}
				}
			}
		}


	}

}


@Preview
@Composable
fun PaymentScreenPreview() {
	PaymentScreen(
		viewState = PaymentViewState(
			additionalAddressInfo = "", sheetType = SheetType.NAME,
			chosenAddress = Address(
				address = "address",
				apartment = "apartment",
				entrance = "entrance",
				floor = "floor"
			),
			name = "",
			time = "TODO()",
			showBottomSheet = false,
			totalPrice = "",
		), {})
}