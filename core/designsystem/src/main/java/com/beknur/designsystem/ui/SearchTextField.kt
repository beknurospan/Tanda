package com.beknur.designsystem.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.beknur.designsystem.theme.Gray


@Composable
fun SearchTextField(
	isEnabled: Boolean=true,
	value: String="",
	onValueChange: (String) -> Unit={},
	onClick: () -> Unit={}
) {
	val clickableModifier = if (!isEnabled) {
		Modifier.clickable { onClick.invoke() }
	} else {
		Modifier
	}

	OutlinedTextField(
		enabled = isEnabled,
		value = value,
		onValueChange = onValueChange,
		modifier = Modifier
			.then(clickableModifier)
			.fillMaxWidth()
			.height(56.dp),
		placeholder = {
			Text(
				text = "Поиск",
				style = MaterialTheme.typography.bodySmall,
				color = Color.Black
			)
		},
		leadingIcon = {
			Icon(
				modifier = Modifier.padding(start = 8.dp),
				imageVector = Icons.Default.Search,
				contentDescription = null
			)
		},
		shape = RoundedCornerShape(10.dp),
		colors = OutlinedTextFieldDefaults.colors(
			disabledContainerColor = Gray,
			focusedBorderColor = Color.DarkGray,
			unfocusedBorderColor = Color.DarkGray,
			disabledBorderColor = Color.DarkGray,
			errorBorderColor = Color.Red
		),
		singleLine = true
	)
}
