package com.beknur.profile.composables

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.beknur.designsystem.R

@Preview
@Composable
fun MyData() {
	Row(
		modifier = Modifier
			.fillMaxWidth()
			.height(150.dp)
			.padding(horizontal = 20.dp),
		verticalAlignment = Alignment.CenterVertically,
		horizontalArrangement = Arrangement.spacedBy(5.dp)
	) {

		Icon(
			imageVector = ImageVector.vectorResource(id = R.drawable.penguin_svgrepo_com_1),
			contentDescription = "", tint = Color.Unspecified
		)
		Column {
			Text("Бекнур Оспан")
			Text("8 775 629 44 55")
		}


	}
}
