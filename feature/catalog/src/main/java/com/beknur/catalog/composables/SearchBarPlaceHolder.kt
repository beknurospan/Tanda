package com.beknur.catalog.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import com.beknur.catalog.R
import com.beknur.designsystem.theme.Gray


@Composable
fun SearchBarPlaceholder(onClick: () -> Unit) {
	Row(
		modifier = Modifier
			.fillMaxWidth()
			.height(56.dp)
			.clip(RoundedCornerShape(10.dp))
			.background(MaterialTheme.colorScheme.surfaceVariant)
			.clickable { onClick.invoke() },
		verticalAlignment = Alignment.CenterVertically
	) {
		Icon(
			modifier = Modifier.padding(start = 8.dp),
			imageVector = Icons.Default.Search,
			contentDescription = ""
		)
		Spacer(modifier = Modifier.width(20.dp))
		Text(
			text = stringResource(R.string.feature_catalog_find),
			color = Color.Gray
		)
	}
}

@Preview
@Composable
fun SearchBarPlaceHolderPreview() {
	SearchBarPlaceholder { }
}


