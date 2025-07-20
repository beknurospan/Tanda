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


		) {
		Spacer(modifier = Modifier.height(30.dp))
		Column(	verticalArrangement = Arrangement.spacedBy(20.dp), modifier = Modifier.padding(20.dp)) {
			Text("Привет")
			Text(
				"Введите ваш номер телефона, так мы \n" +
						"поймем заказывали ли вы у нас раньше"
			)
			Text("Номер")
			Box (contentAlignment = Alignment.Center, modifier = Modifier.height(150.dp).fillMaxWidth()){
				CodeInput(4,"56") { }

			}


			Button(
				onClick = {},
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
fun PhoneTextField(
	focusRequester: FocusRequester,
	phoneNumber: String
) {
	var phoneNumber1 = phoneNumber
	OutlinedTextField(
		modifier = Modifier
			.focusRequester(focusRequester)
			.fillMaxWidth()
			.height(60.dp),
		value = phoneNumber1,
		onValueChange = {
			phoneNumber1 = it.filter { it.isDigit() }.take(10)
		},
		colors = OutlinedTextFieldDefaults.colors(
			unfocusedBorderColor = Color.Green,
			focusedBorderColor = Color.Green
		),
		visualTransformation = KZPhoneNumberTransformation(),
		keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
		singleLine = true,
	)
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

@Composable
fun CodeInput(
	codeLength: Int = 4,
	code: String,
	onCodeChange: (String) -> Unit
) {
	val focusRequester = remember { FocusRequester() }

	Row(
		horizontalArrangement = Arrangement.spacedBy(16.dp),
		verticalAlignment = Alignment.CenterVertically
	) {
		repeat(codeLength) { index ->
			Box(
				modifier = Modifier
					.width(40.dp)
					.height(56.dp)
					.border(
						width = 1.dp,
						color = Color.Transparent,
						shape = RoundedCornerShape(4.dp)
					)
					.drawBehind {
						val strokeWidth = 2.dp.toPx()
						drawLine(
							color = Color(0xFF00C853), // зелёный цвет
							start = Offset(0f, size.height),
							end = Offset(size.width, size.height),
							strokeWidth = strokeWidth
						)
					},
				contentAlignment = Alignment.Center
			) {
				val char = code.getOrNull(index)?.toString() ?: ""
				Text(
					text = char,
					style = MaterialTheme.typography.titleLarge,
					color = Color.Black
				)
			}
		}
	}


	LaunchedEffect(Unit) {
		focusRequester.requestFocus()
	}

	Box(modifier = Modifier.size(0.dp)) {
		BasicTextField(
			value = code,
			onValueChange = {
				if (it.length <= codeLength && it.all { c -> c.isDigit() }) {
					onCodeChange(it)
				}
			},
			keyboardOptions = KeyboardOptions.Default.copy(
				keyboardType = KeyboardType.Number
			),
			singleLine = true,
			modifier = Modifier.focusRequester(remember { FocusRequester() })
		)
	}
}





@Preview
@Composable
fun OtpCode() {

}









