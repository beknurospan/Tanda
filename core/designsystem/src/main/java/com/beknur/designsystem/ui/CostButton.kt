package com.beknur.designsystem.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.beknur.designsystem.theme.CustomTypography
import com.beknur.designsystem.theme.GreenDark
import com.beknur.designsystem.R as coreR


@Composable
fun CostButton(text: String) {
	Row(
		modifier = Modifier
			.height(37.dp)
			.clip(RoundedCornerShape(4.dp))
			.background(GreenDark)
			.padding(horizontal = 8.dp),
		verticalAlignment = Alignment.CenterVertically,
		horizontalArrangement = Arrangement.spacedBy(4.dp)
	) {
		Text(
			text,
			style = CustomTypography.Typography
		)
		Text(
			text = "KZT",
			fontFamily = CustomTypography.PoppinsFontFamily
		)
		Icon(
			imageVector = ImageVector.vectorResource(coreR.drawable.shopicons_regular_hangtag),
			contentDescription = null
		)
	}
}


@Preview
@Composable
fun CostButtonPreview() {
	CostButton("32000")
}