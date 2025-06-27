import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.text.input.InputTransformation.Companion.keyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
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
import androidx.compose.ui.graphics.RectangleShape
import com.beknur.designsystem.theme.Gray

@Preview
@Composable
fun AuthScreen() {
	var phoneNumber by remember { mutableStateOf("") }
	val focusRequester = remember { FocusRequester() }


	LaunchedEffect(Unit) {
		focusRequester.requestFocus()
	}

	Column(
		modifier = Modifier
			.fillMaxSize()
			.background(Color.White),
		verticalArrangement = Arrangement.spacedBy(20.dp)
	) {
		Text("Привет")
		Text(
			"Введите ваш номер телефона, так мы \n" +
					"поймем заказывали ли вы у нас раньше"
		)

		OutlinedTextField(
			modifier = Modifier
				.focusRequester(focusRequester)
				.fillMaxWidth()
				.height(60.dp)
				.padding(horizontal = 30.dp),
			value = phoneNumber,
			onValueChange = {
				phoneNumber = it.filter { it.isDigit() }.take(10)
			},
			colors = OutlinedTextFieldDefaults.colors(
				unfocusedBorderColor = Color.Green,
				focusedBorderColor = Color.Green
			),
			visualTransformation = KZPhoneNumberTransformation(),
			keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
			singleLine = true,
		)

		Button(
			onClick = {},
			colors = ButtonColors(
				containerColor = Color.Green,
				contentColor = Color.White,
				disabledContentColor = Gray,
				disabledContainerColor = Gray,

				),
			shape = RoundedCornerShape(6.dp),
			modifier = Modifier.fillMaxWidth().padding(horizontal = 20.dp)
		) {
			Text("Продолжить")
		}

	}
}


fun KZPhoneNumberTransformation(): VisualTransformation {
	return VisualTransformation { text ->
		val digits = text.text.filter { it.isDigit() }.take(10)

		val formatted = buildString {
			append("+7 ")
			if (digits.length >= 3) append(digits.substring(0, 3)) else append(digits)
			if (digits.length >= 6) append(
				" ${
					digits.substring(
						3,
						6
					)
				}"
			) else if (digits.length > 3) append(" ${digits.substring(3)}")
			if (digits.length >= 8) append(
				" ${
					digits.substring(
						6,
						8
					)
				}"
			) else if (digits.length > 6) append(" ${digits.substring(6)}")
			if (digits.length >= 10) append(
				" ${
					digits.substring(
						8,
						10
					)
				}"
			) else if (digits.length > 8) append(" ${digits.substring(8)}")
		}


		val offsetMapping = object : OffsetMapping {
			override fun originalToTransformed(offset: Int): Int {
				return when {
					offset <= 3 -> offset + 3
					offset <= 6 -> offset + 4
					offset <= 8 -> offset + 5
					offset <= 10 -> offset + 6
					else -> formatted.length
				}
			}

			override fun transformedToOriginal(offset: Int): Int {
				return when {
					offset <= 3 -> 0
					offset <= 7 -> offset - 3
					offset <= 11 -> offset - 4
					offset <= 14 -> offset - 5
					offset <= 17 -> offset - 6
					else -> 10
				}
			}
		}

		TransformedText(AnnotatedString(formatted), offsetMapping)
	}
}

@Preview
@Composable
fun OtpCode(){

}









