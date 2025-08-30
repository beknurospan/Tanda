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


@Preview
@Composable
fun SortDialogPreview() {
	SortDialog(
		onDismiss = {},
		onDelete = {},
		onEdit = {},
		onMakePrimary = {}
	)
}


@Composable
fun SortDialog(
	onDismiss: () -> Unit,
	onDelete: () -> Unit,
	onEdit: () -> Unit,
	onMakePrimary: () -> Unit
) {
	AlertDialog(
		onDismissRequest = onDismiss,
		title = { Text("Выберите действие") },
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
							onClick = {
								onMakePrimary()
							},
							modifier = Modifier.fillMaxWidth()
						) {
							Text("По новизне")
						}
						HorizontalDivider()
						TextButton(
							onClick = {
								onEdit()
							},
							modifier = Modifier.fillMaxWidth()
						) {
							Text("Cначала дешёвые")
						}
						HorizontalDivider()
						TextButton(
							onClick = {
								onEdit()
							},
							modifier = Modifier.fillMaxWidth()
						) {
							Text("Сначала дорогие")
						}
						HorizontalDivider()
						TextButton(
							onClick = {
								onEdit()
							},
							modifier = Modifier.fillMaxWidth()
						) {
							Text("По рейтингу")
						}
						HorizontalDivider()

						TextButton(
							onClick = {
								onDelete()
							},
							modifier = Modifier.fillMaxWidth()
						) {
							Text("Удалить", color = Color.Red)
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
