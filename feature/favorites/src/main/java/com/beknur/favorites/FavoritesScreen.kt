package com.beknur.favorites

import android.widget.ImageView
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.beknur.designsystem.theme.Gray
import com.beknur.designsystem.R as coreR

@Preview
@Composable
fun FavoritesScreen() {
	Column(
		modifier = Modifier
			.fillMaxSize()
			.background(Color.White)
	) {
		ProductItem()
	}
}

@Preview
@Composable
fun ProductItem() {
	Row(modifier = Modifier
		.fillMaxWidth()
		.padding(20.dp)
		.clip(shape = RoundedCornerShape(10.dp))
		.background(Gray)
		) {
		Image(
			painter = painterResource(coreR.drawable.image),
			contentDescription = "Локальное изображение",
			modifier = Modifier.width(80.dp).aspectRatio(3f/4f).padding(10.dp)
		)
	}
}