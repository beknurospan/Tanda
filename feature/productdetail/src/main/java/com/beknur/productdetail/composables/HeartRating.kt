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
import androidx.compose.material3.IconButton
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
import com.beknur.domain.model.SizeItem


@Composable
fun HeartRating(
	rating: Double,
	max: Int = 5,
	sizes:List<SizeItem>,
	onSizeSelected: (Int) -> Unit,
	onHeartClick: () -> Unit,
	isFavorite: Boolean,
	name: String,
	brandName: String,
	price: String,
	selectedSize: Int?
) {
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
			IconButton(onClick = onHeartClick) {
				when(isFavorite){
					false-> {
						Icon(
							imageVector = ImageVector.vectorResource(R.drawable.shopicons_regular_heart),
							contentDescription = null,
							tint = Color.Unspecified,
							modifier = Modifier.size(40.dp)
						)
					}
					true-> {
						Icon(
							imageVector = ImageVector.vectorResource(R.drawable.heart_filled),
							contentDescription = null,
							tint = Color.Unspecified,
							modifier = Modifier.size(40.dp)
						)
					}
				}


			}



		}
		Text(
			brandName,
			style = MaterialTheme.typography.bodyLarge
		)
		Text(
			name,
			style = MaterialTheme.typography.bodySmall
		)
		Text("$price KZT", style = MaterialTheme.typography.bodyLarge)
		Spacer(modifier = Modifier.height(40.dp))
		Box(
			modifier = Modifier.fillMaxWidth(),
			contentAlignment = Alignment.TopStart
		) {
			SizeGrid(sizes = sizes, selectedSize = selectedSize, onSizeSelected = onSizeSelected)
		}
	}
}

