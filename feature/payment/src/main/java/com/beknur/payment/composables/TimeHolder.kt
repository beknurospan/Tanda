package com.beknur.payment.composables

import android.R.attr.onClick
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview
@Composable
fun TimeHolderPreview() {
	TimeHolder("08:00-10:00"){}
}


@Composable
fun TimeHolder(timeRange:String,onClick:()->Unit) {
	Column(modifier = Modifier
		.fillMaxWidth()
		.background(Color.White)
		.padding(20.dp),
		verticalArrangement = Arrangement.spacedBy(10.dp)

	) {
		Text("Удобное для вас время доставки")
		TimeItem(timeRange,false, modifier = Modifier.fillMaxWidth(),onClick=onClick)
	}
}