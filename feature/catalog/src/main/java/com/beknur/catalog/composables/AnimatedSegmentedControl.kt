package com.beknur.catalog.composables

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.beknur.designsystem.theme.Gray
import com.beknur.designsystem.theme.GreenDark

@Composable
fun AnimatedSegmentedControl(
	options: List<String>,
	selectedIndex: Int,
	onSelectedChange: (Int) -> Unit
) {
	BoxWithConstraints {
		val maxWidth = maxWidth
		val segmentWidth = maxWidth / options.size
		val indicatorOffset by animateDpAsState(targetValue = segmentWidth * selectedIndex)

		Box(
			modifier = Modifier
				.fillMaxWidth()
				.height(36.dp)
				.background(Gray)
				.clip(
					RoundedCornerShape(4.dp)
				),
			contentAlignment = Alignment.CenterStart
		) {

			Box(
				modifier = Modifier
					.offset(x = indicatorOffset)
					.width(segmentWidth)
					.fillMaxHeight()
					.shadow(6.dp, shape = RoundedCornerShape(4.dp))
					.clip(RoundedCornerShape(4.dp))
					.background(GreenDark)

			)

			Row(modifier = Modifier.fillMaxWidth()) {
				options.forEachIndexed { index, title ->
					Box(
						modifier = Modifier
							.width(segmentWidth)
							.fillMaxHeight()
							.clickable { onSelectedChange(index) },
						contentAlignment = Alignment.Center
					) {
						Text(
							text = title,
							color = if (index == selectedIndex) Color.Black else Color.DarkGray
						)
					}
				}
			}
		}
	}
}

@Preview
@Composable
fun AnimatedSegmentPreview(){
	AnimatedSegmentedControl(listOf("men","women","gey"),1,{})
}