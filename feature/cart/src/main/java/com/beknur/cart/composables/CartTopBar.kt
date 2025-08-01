package com.beknur.cart.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.beknur.designsystem.theme.Green
import com.beknur.designsystem.theme.WhiteAdd
import com.beknur.designsystem.theme.WhiteGray
import com.beknur.designsystem.theme.WhiteLight


@Composable
fun CartTopBar(
	onTrashClick:()->Unit,
	onSelectAllClick:()->Unit,
	isAllSelected:Boolean,
	selectedCount:String
) {
	Row(
		modifier = Modifier
			.fillMaxWidth()
			.height(70.dp)
			.background(WhiteLight)
			.padding(start=10.dp,top=20.dp,end=10.dp),
		verticalAlignment = Alignment.CenterVertically
	) {
		IconButton({onTrashClick.invoke()}) {
			Icon(
				imageVector = ImageVector.vectorResource(com.beknur.designsystem.R.drawable.basket_alt_2_light),
				contentDescription = null
			)
		}
		Text(selectedCount)

		Spacer(modifier = Modifier.weight(1f))

		Text("выбрать все", modifier = Modifier.clickable { onSelectAllClick.invoke() })
		IconButton({onSelectAllClick.invoke()}) {
			Icon(
				imageVector = ImageVector.vectorResource(com.beknur.designsystem.R.drawable.ellipse_99),
				contentDescription = null,

			)
			if (isAllSelected){
				Icon(
					imageVector = ImageVector.vectorResource(com.beknur.designsystem.R.drawable.line_1),
					contentDescription = null,
					tint = Green
				)
			}

		}


	}
}


@Preview
@Composable
fun CartTopBarPreview() {
	CartTopBar({},{},true,"6")
}