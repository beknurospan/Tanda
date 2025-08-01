package com.beknur.payment.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.beknur.designsystem.theme.Green
import com.beknur.designsystem.theme.GreenDark
import com.beknur.designsystem.theme.WhiteAdd
import com.beknur.designsystem.theme.WhiteGray
import com.beknur.payment.R


@Composable
fun AddCardItem(
	onClick: () -> Unit
) {
	Column(
		horizontalAlignment = Alignment.CenterHorizontally,
		verticalArrangement = Arrangement.Center,
		modifier = Modifier
			.width(140.dp)
			.height(80.dp)
			.clip(RoundedCornerShape(8.dp))
			.background(GreenDark)
			.clickable { onClick.invoke() }
			.padding(10.dp)
	) {
		Text("Добавить карту")

		Icon(
			imageVector = ImageVector.vectorResource(com.beknur.designsystem.R.drawable.add_light),
			contentDescription = ""
		)


	}
}

@Preview
@Composable
fun AddCardItemPreview() {
	AddCardItem({})
}