package com.beknur.product.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
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


@Composable
fun TopBar(text:String){
	Row(
		modifier = Modifier
			.fillMaxWidth()
			.height(58.dp)
			.background(color = Color.White),
		verticalAlignment = Alignment.CenterVertically
	) {
		Icon(
			imageVector = ImageVector.vectorResource(R.drawable.arrow_left_light),
			contentDescription = "",
			modifier = Modifier.size(36.dp)
		)
		Spacer(modifier = Modifier.weight(1f))
		Text(text)
		Spacer(modifier = Modifier.weight(1f))
		Icon(
			imageVector = ImageVector.vectorResource(R.drawable.shopicons_light_store),
			contentDescription = "",
			modifier = Modifier.size(36.dp)
		)

	}
}

@Preview
@Composable
fun TopBarPreview(){
	TopBar("обувь")
}