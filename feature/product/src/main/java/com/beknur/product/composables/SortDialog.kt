package com.beknur.product.composables

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.beknur.product.SortType


@Preview
@Composable
fun SortDialogPreview() {
	SortDialog(
		onDismiss = {},
		onTypeClicked = {},
	)
}


@Composable
fun SortDialog(
	onDismiss: () -> Unit,
	onTypeClicked: (SortType) -> Unit,
) {
	AlertDialog(
		containerColor = Color.Transparent,
		onDismissRequest = onDismiss,
		text = {
			Column(
				verticalArrangement = Arrangement.spacedBy(12.dp)
			) {
				Card(
					shape = RoundedCornerShape(12.dp),
					elevation = CardDefaults.cardElevation(4.dp)
				) {
					Column {
						TextButton(
							onClick = {onTypeClicked.invoke(SortType.NEWEST)},
							modifier = Modifier.fillMaxWidth()
						) {
							Text("По новизне")
						}
						HorizontalDivider()
						TextButton(
							onClick = {onTypeClicked.invoke(SortType.PRICE_ASC)},
							modifier = Modifier.fillMaxWidth()
						) {
							Text("Cначала дешёвые")
						}
						HorizontalDivider()
						TextButton(
							onClick = {onTypeClicked.invoke(SortType.PRICE_DESC)},
							modifier = Modifier.fillMaxWidth()
						) {
							Text("Сначала дорогие")
						}
						HorizontalDivider()
						TextButton(
							onClick = {onTypeClicked.invoke(SortType.RATING)},
							modifier = Modifier.fillMaxWidth()
						) {
							Text("По рейтингу")
						}
					}
				}


				Card(
					shape = RoundedCornerShape(12.dp),
					elevation = CardDefaults.cardElevation(4.dp)
				) {
					TextButton(
						onClick = onDismiss,
						modifier = Modifier.fillMaxWidth()
					) {
						Text("Отменить", color = Color.Black)
					}
				}
			}
		},
		confirmButton = {}
	)
}
