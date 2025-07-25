package com.beknur.auth.composables


import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.TextRange
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import com.beknur.auth.utils.KZPhoneNumberTransformation


@Composable
fun PhoneTextField(
	phoneNumber: String,
	onValueChange: (String) -> Unit
) {
	val focusRequester = remember { FocusRequester() }
	val focusManager = LocalFocusManager.current

	// Храним TextFieldValue с выделением в конце
	var textFieldValue by remember(phoneNumber) {
		mutableStateOf(
			TextFieldValue(
				text = phoneNumber,
				selection = TextRange(phoneNumber.length)
			)
		)
	}

	// Устанавливаем фокус и курсор в конец при заходе
	LaunchedEffect(phoneNumber) {
		textFieldValue = TextFieldValue(
			text = phoneNumber,
			selection = TextRange(phoneNumber.length)
		)
		focusManager.clearFocus(force = true)
		focusRequester.requestFocus()
	}

	OutlinedTextField(
		modifier = Modifier
			.fillMaxWidth()
			.height(60.dp)
			.focusRequester(focusRequester),
		value = textFieldValue,
		onValueChange = { newValue ->
			// Обновляем текст и ставим курсор в конец
			textFieldValue = newValue.copy(selection = TextRange(newValue.text.length))
			onValueChange(newValue.text)
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
