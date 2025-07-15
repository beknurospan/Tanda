package com.beknur.productdetail.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.beknur.designsystem.theme.WhiteGray

@Composable
fun InOtherColorItem(img: String, colorText: String,modifier: Modifier) {

	Column (modifier=modifier){

		AsyncImage(
			model = img,
			contentDescription = "",
			contentScale = ContentScale.Fit,
			modifier = Modifier
				.width(60.dp)
				.aspectRatio(3f / 4f)
				.shadow(elevation = 1.dp, RoundedCornerShape(8.dp))
				.clip(RoundedCornerShape(8.dp))
				.background(Color.White)
				.padding(5.dp)

		)
		Spacer(modifier = Modifier.height(15.dp))
		Text(colorText)

	}


}
