package com.beknur.product.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.beknur.designsystem.theme.GreenDark
import com.beknur.designsystem.theme.WhiteGray


@Composable
fun CategoryButtonCard(text: String = "",onClick:()->Unit,isSelected:Boolean) {
	val color=if(isSelected) GreenDark else WhiteGray
	Box(
		modifier = Modifier
			.height(30.dp)
			.clip(RoundedCornerShape(4.dp))
			.clickable { onClick.invoke() }
			.background(color),
		contentAlignment = Alignment.Center

	) {
		Text(text, modifier = Modifier.padding(horizontal = 12.dp))
	}
}