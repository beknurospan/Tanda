package com.beknur.productdetail.composables

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import com.beknur.designsystem.R
import com.beknur.productdetail.data.SizeItem

@Composable
fun HeartRating(rating: Double, max: Int = 5) {
	val sizes = listOf(
		SizeItem(35, true),
		SizeItem(36, true),
		SizeItem(37, true, count = 1),
		SizeItem(38, true),
		SizeItem(39, true),
		SizeItem(40, true),
		SizeItem(41, true),
		SizeItem(42, true),
		SizeItem(43, true),
		SizeItem(44, true),
		SizeItem(45, true),
		SizeItem(46, true)
	)


	Column(
		verticalArrangement = Arrangement.spacedBy(8.dp)

		) {
		Row(
			modifier = Modifier
				.fillMaxWidth()
				.height(50.dp),
			verticalAlignment = Alignment.CenterVertically
		) {

			repeat(max) { index ->
				val isFilled = index.toInt() < rating.toInt()
				Icon(
					imageVector = ImageVector.vectorResource(
						if (isFilled) R.drawable.star_4
						else R.drawable.star__1_
					),
					contentDescription = null,
					tint = Color.Unspecified,
					modifier = Modifier.size(24.dp)
				)


			}
			Spacer(modifier = Modifier.width(10.dp))
			Text("Рейтинг $rating")
			Spacer(modifier = Modifier.weight(1f))
			Icon(
				imageVector = ImageVector.vectorResource(R.drawable.shopicons_regular_heart),
				contentDescription = null,
				modifier = Modifier.size(40.dp)
			)


		}
		Text(
			"Dino Ricci Select",
			style = MaterialTheme.typography.bodyLarge
		)
		Text(
			"Ботильоны",
			style = MaterialTheme.typography.bodySmall
		)
		Text("26000 KZT", style = MaterialTheme.typography.bodyLarge)
		Spacer(modifier = Modifier.height(40.dp))
		Box(
			modifier = Modifier.fillMaxWidth(),
			contentAlignment = Alignment.TopStart
		) {
			SizeGrid(sizes = sizes, 2) { }
		}
	}
}

