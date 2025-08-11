package com.beknur.address.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.beknur.designsystem.theme.WhiteAdd
import java.nio.file.WatchEvent


@Composable
fun SearchResultItem(
	addressName: String,
	fullName: String,
	onItemClick: () -> Unit,
) {
	Column(modifier = Modifier
		.fillMaxWidth()
		.height(64.dp)
		.clickable { onItemClick.invoke() }
		.background(Color.White)
		.padding(10.dp)
		,
		verticalArrangement = Arrangement.Center
	) {
		Text(addressName)
		Text(fullName)

	}
	HorizontalDivider(thickness = 1.dp)
}

@Preview
@Composable
fun AddressResultItemPreview() {
	SearchResultItem("address name","full name",{})
}