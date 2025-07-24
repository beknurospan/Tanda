package com.beknur.profile.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import com.beknur.designsystem.theme.GreenDark
import com.beknur.designsystem.theme.WhiteGray

@Composable
fun ProfileItem(
	icon: Int,
	text: String,
	onClick:()->Unit
) {


	Column(
		modifier = Modifier
			.fillMaxWidth()
			.height(50.dp)
			.background(Color.White)
			.clickable { onClick.invoke() }

	) {

		Row(
			modifier = Modifier
				.fillMaxSize()
				.padding(horizontal = 20.dp),
			verticalAlignment = Alignment.CenterVertically,
			horizontalArrangement = Arrangement.spacedBy(5.dp)
		) {
			Icon(
				imageVector = ImageVector.vectorResource(id = icon),
				contentDescription = "", tint = GreenDark
			)
			Text(text)
		}
		HorizontalDivider(thickness = 1.dp, color = WhiteGray)

	}
}
