package com.beknur.productdetail.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.beknur.designsystem.theme.Gray
import com.beknur.designsystem.theme.GreenDark
import com.beknur.domain.model.SizeItem

@Composable
fun SizeGrid(
	sizes: List<SizeItem>,
	selectedSize: Int?,
	onSizeSelected: (Int) -> Unit
) {
	FlowRow(

		verticalArrangement = Arrangement.spacedBy(8.dp),
		horizontalArrangement = Arrangement.spacedBy(8.dp)
	) {
		sizes.forEach { sizeItem ->

				Box(
					modifier = Modifier
						.size(40.dp)
						.shadow(elevation = 2.dp, RoundedCornerShape(8.dp))
						.clip(RoundedCornerShape(8.dp))
						.background(
							if (selectedSize == sizeItem.size) GreenDark
							else Gray
						)
						.clickable { onSizeSelected(sizeItem.size) },
					contentAlignment = Alignment.Center
				) {
					Text(text = sizeItem.size.toString(), color = Color.Black)
				}

		}
	}
}

