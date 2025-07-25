import androidx.activity.compose.BackHandler
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.text.input.InputTransformation.Companion.keyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.OffsetMapping
import androidx.compose.ui.text.input.TransformedText
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.RectangleShape

import androidx.compose.ui.platform.LocalFocusManager
import androidx.lifecycle.ViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.beknur.auth.AuthUiEvent
import com.beknur.auth.AuthViewModel
import com.beknur.auth.AuthViewState
import com.beknur.auth.composables.CodeInput
import com.beknur.auth.composables.PhoneTextField
import com.beknur.designsystem.theme.Gray
import com.beknur.navigation.NavigationManager


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

					CodeInput(code = viewState.code) { code->
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
					PhoneTextField(phoneNumber = viewState.phoneNumber) { number->
						sendUiEvent(
							AuthUiEvent.OnPhoneNumberChanged(number)
						)
					}

				}
			}
			Button(
				onClick = {sendUiEvent(AuthUiEvent.OnSendButtonClick)},
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






