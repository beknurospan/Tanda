import androidx.activity.compose.BackHandler
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.beknur.auth.AuthUiEvent
import com.beknur.auth.AuthViewModel
import com.beknur.auth.AuthViewState
import com.beknur.auth.composables.CodeInput
import com.beknur.auth.composables.PhoneTextField
import com.beknur.designsystem.theme.Gray


@Composable
fun AuthScreenRoute(viewModel: AuthViewModel) {
	val viewState by viewModel.viewState.collectAsStateWithLifecycle()
	AuthScreen(viewState, viewModel::handleEvent)
}


@Composable
fun AuthScreen(
	viewState: AuthViewState,
	sendUiEvent: (AuthUiEvent) -> Unit
) {
	Column(
		modifier = Modifier
			.fillMaxSize()
			.background(Color.White),


		) {
		Spacer(modifier = Modifier.height(30.dp))
		Column(
			verticalArrangement = Arrangement.spacedBy(20.dp),
			modifier = Modifier.padding(20.dp)
		) {
			Text("Привет")
			Text(
				"Введите ваш номер телефона, так мы \n" +
						"поймем заказывали ли вы у нас раньше"
			)
			Text("Номер")
			Box(
				contentAlignment = Alignment.Center, modifier = Modifier
					.height(100.dp)
					.fillMaxWidth()
			) {

				if (viewState.isOtpMode) {
					BackHandler(true) {
						sendUiEvent(
							AuthUiEvent.OnBackClick
						)
					}

					CodeInput(code = viewState.code) { code ->
						sendUiEvent(
							AuthUiEvent.OnCodeChanged(code)
						)
					}
				} else {
					BackHandler(true) {
						sendUiEvent(
							AuthUiEvent.OnBackClick
						)
					}
					PhoneTextField(phoneNumber = viewState.phoneNumber) { number ->
						sendUiEvent(
							AuthUiEvent.OnPhoneNumberChanged(number)
						)
					}

				}
			}
			Button(
				onClick = { sendUiEvent(AuthUiEvent.OnSendButtonClick) },
				colors = ButtonColors(
					containerColor = Color.Green,
					contentColor = Color.White,
					disabledContentColor = Gray,
					disabledContainerColor = Gray,

					),
				shape = RoundedCornerShape(6.dp),
				modifier = Modifier
					.fillMaxWidth()
			) {
				Text("Продолжить")
			}
		}
	}
}

@Composable
@Preview
fun AuthScreenPreview(){
	AuthScreen(AuthViewState("",true,"","")) { }
}






