package com.beknur.notifications

import android.app.Notification
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview


@Composable
fun NotificationScreen() {
	Column(modifier = Modifier
		.fillMaxSize()
		.background(Color.White)) {

	}
}

@Preview
@Composable
fun NotificationScreenPreview() {
	NotificationScreen()
}