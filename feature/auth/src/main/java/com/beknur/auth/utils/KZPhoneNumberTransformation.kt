package com.beknur.auth.utils

import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.input.OffsetMapping
import androidx.compose.ui.text.input.TransformedText
import androidx.compose.ui.text.input.VisualTransformation

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






