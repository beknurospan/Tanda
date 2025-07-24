package com.beknur.profile.composables

import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.beknur.profile.R



@Composable
fun LogoutDialog(
	onDismiss:()->Unit,
	onConfirm:()->Unit
) {

	AlertDialog(
		onDismissRequest = { onDismiss.invoke() },
		confirmButton = {
			TextButton(onClick = { onConfirm.invoke() }) {
				Text(stringResource(R.string.feature_profile_logout))
			}
		},
		dismissButton = {
			TextButton(onClick = { onDismiss.invoke() }) {
				Text(stringResource(R.string.feature_profile_cancel))
			}
		},
		title = { Text(stringResource(R.string.feature_profile_exit)) },
		text = { Text(stringResource(R.string.feature_profile_logout_dialog_message)) }
	)

}
@Preview
@Composable
fun LogoutDialogPreview(){
	LogoutDialog({},{})
}
