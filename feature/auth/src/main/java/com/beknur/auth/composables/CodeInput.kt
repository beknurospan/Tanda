package com.beknur.auth.composables

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun CodeInput(
	codeLength: Int = 4,
	code: String,
	onCodeChange: (String) -> Unit
) {
	val focusRequester = remember { FocusRequester() }
	val focusManager = LocalFocusManager.current

	LaunchedEffect(Unit) {
		focusManager.clearFocus(force = true)
		focusRequester.requestFocus()
	}

	val boxModifier = Modifier
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
				color = Color(0xFF00C853),
				start = Offset(0f, size.height),
				end = Offset(size.width, size.height),
				strokeWidth = strokeWidth
			)
		}
	Box(contentAlignment = Alignment.Center){
		Row(
			horizontalArrangement = Arrangement.spacedBy(16.dp),
			verticalAlignment = Alignment.CenterVertically
		) {
			repeat(codeLength) { index ->
				Box(
					modifier = boxModifier,
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


		BasicTextField(
			value = code,
			onValueChange = {
				if (it.length <= codeLength && it.all { c -> c.isDigit() }) {
					onCodeChange(it)
				}
			},
			modifier = Modifier
				.fillMaxWidth()
				.alpha(0f)
				.focusRequester(focusRequester),
			keyboardOptions = KeyboardOptions.Default.copy(
				keyboardType = KeyboardType.Number
			),
			singleLine = true,
			cursorBrush = SolidColor(Color.Transparent)
		)



	}

}


@Preview
@Composable
fun CodeInputPreview() {
	CodeInput(code = "") { }
}
