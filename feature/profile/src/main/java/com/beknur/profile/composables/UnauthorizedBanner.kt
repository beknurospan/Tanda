package com.beknur.profile.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.beknur.designsystem.theme.Gray
import com.beknur.designsystem.ui.TndButton
import com.beknur.profile.R
import com.beknur.designsystem.R as coreR


@Composable
fun UnauthorizedBanner(
	onClick: () -> Unit
) {
	Column(
		modifier = Modifier
			.fillMaxWidth()
			.height(300.dp)
			.background(Gray),
		horizontalAlignment = Alignment.CenterHorizontally,
		verticalArrangement = Arrangement.SpaceAround
	) {
		Image(
			imageVector = ImageVector.vectorResource(coreR.drawable.penguin_svgrepo_com_1),
			contentDescription = "",
			modifier = Modifier.size(100.dp)
		)
		Text(stringResource(R.string.feature_profile_auth_title))
		TndButton(
			isEnabled = true, onClick = { onClick.invoke() },
			stringResource(R.string.feature_profile_authorization)
		)
	}
}
@Preview
@Composable
fun UnauthorizedPreview(){
	UnauthorizedBanner {  }
}