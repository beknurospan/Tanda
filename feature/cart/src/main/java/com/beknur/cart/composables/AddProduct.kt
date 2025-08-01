package com.beknur.cart.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.input.pointer.motionEventSpy
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.beknur.cart.R
import com.beknur.designsystem.theme.Green
import com.beknur.designsystem.theme.GreenDark
import com.beknur.designsystem.theme.WhiteAdd
import com.beknur.designsystem.theme.WhiteGray
import com.beknur.designsystem.ui.CostButton
import com.beknur.designsystem.ui.ProductDetailCard


@Composable
fun AddProduct(
	isSelected: Boolean,
	detailText: String,
	brandName: String,
	size: String,
	pricePerOne: String,
	sum: String,
	count: String,
	onAddProduct: () -> Unit,
	onDelProduct: () -> Unit,
	onSelect: () -> Unit
) {


	Row(
		modifier = Modifier
			.height(200.dp)
			.fillMaxWidth()
			.shadow(elevation = 1.dp, RoundedCornerShape(8.dp))
			.clip(RoundedCornerShape(8.dp))
			.background(Color.White),
		verticalAlignment = Alignment.CenterVertically,

		) {
		Row(
			modifier = Modifier.padding(10.dp),
			horizontalArrangement = Arrangement.spacedBy(10.dp)
		) {
			AsyncImage(
				model = "https://cdn.intertop.com/load/mp304663/1600x2133/MAIN.jpeg",
				contentDescription = null,
				modifier = Modifier
					.height(180.dp)
					.aspectRatio(3f / 4f)
					.background(WhiteGray),
				contentScale = ContentScale.Fit
			)
			Column(verticalArrangement = Arrangement.spacedBy(5.dp)) {
				Row(modifier = Modifier.height(120.dp)) {
					Column(
						modifier = Modifier
							.weight(1f),
						verticalArrangement = Arrangement.spacedBy(5.dp),

						) {
						Spacer(modifier = Modifier.height(2.dp))
						Text(
							detailText + "saaaaaaaaaaaaaaaaa dsssssssssssssdddddddddd",
							maxLines = 2
						)
						Spacer(modifier = Modifier.weight(1f))
						Text(brandName)
						Text(size)
						Text("$pricePerOne/шт")


					}
					Column {
						Box(
							modifier = Modifier
								.size(40.dp)
								.clickable { onSelect.invoke() },
							contentAlignment = Alignment.TopEnd
						) {

							Icon(
								modifier = Modifier.size(20.dp),
								imageVector = ImageVector.vectorResource(com.beknur.designsystem.R.drawable.ellipse_99),
								contentDescription = null,
								tint = if (isSelected) Green else Color.Black
							)
							if (isSelected) {
								Icon(
									modifier = Modifier
										.size(20.dp)
										.padding(5.dp),
									imageVector = ImageVector.vectorResource(com.beknur.designsystem.R.drawable.line_1),
									contentDescription = null
								)
							}

						}
					}

				}
				Spacer(modifier = Modifier.weight(1f))
				Row {
					Row(
						modifier = Modifier
							.height(40.dp)
							.clip(RoundedCornerShape(8.dp))
							.background(color = GreenDark),
						verticalAlignment = Alignment.CenterVertically
					) {
						IconButton({ onDelProduct.invoke() }) {
							Icon(
								imageVector = ImageVector.vectorResource(com.beknur.designsystem.R.drawable.trash_light),
								contentDescription = null
							)
						}
						Text(count)
						IconButton({ onAddProduct.invoke() }) {
							Icon(
								imageVector = ImageVector.vectorResource(com.beknur.designsystem.R.drawable.add_light),
								contentDescription = null
							)
						}
					}

					Box(
						modifier = Modifier
							.height(40.dp)
							.fillMaxWidth()
							.padding(10.dp)
							.clip(RoundedCornerShape(4.dp)),
						contentAlignment = Alignment.Center
					) {
						Text("$sum ₸")
					}


				}
				Spacer(modifier = Modifier.height(2.dp))


			}


		}

	}


}


@Preview
@Composable
fun AddProductPreview() {
	AddProduct(true, "Кроссовки американские", "Dardas", "42", "2888", "28500", "12", {}, {}, {})
}
