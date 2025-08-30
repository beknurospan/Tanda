package com.beknur.product.composables

import androidx.annotation.DrawableRes
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
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
import com.beknur.designsystem.R


@Composable
fun ButtonFilter(
	modifier: Modifier=Modifier,
	text:String,
	@DrawableRes imgRes:Int,
	onClick:()->Unit
) {
	Row(
		modifier = modifier
			.height(30.dp)
			.clip(RoundedCornerShape(2.dp))
			.clickable{onClick.invoke()}
			.border(1.dp, Color.Black, shape = RoundedCornerShape(2.dp)),
		verticalAlignment =Alignment.CenterVertically
	) {
		Spacer(modifier=Modifier.width(5.dp))
		Icon(
			imageVector = ImageVector.vectorResource(imgRes),
			contentDescription = "",
			modifier = Modifier.size(24.dp)
		)
		Spacer(modifier = Modifier.weight(1f))
		Text(text, style = MaterialTheme.typography.bodyLarge)
		Spacer(modifier = Modifier.weight(1f))
		Icon(
			imageVector = ImageVector.vectorResource(R.drawable.vector_9),
			contentDescription = "",
			modifier = Modifier.size(24.dp)
		)
		Spacer(modifier=Modifier.width(5.dp))
	}
}