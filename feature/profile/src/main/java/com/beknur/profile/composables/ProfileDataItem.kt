package com.beknur.profile.composables

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview
@Composable
fun ProfileDataItemPreview(){
	ProfileDataItem()
}



@Composable
fun ProfileDataItem(){
	Row (modifier = Modifier.fillMaxWidth().height(77.dp).padding(10.dp)){

		Column {
			Text("Бекнур")
			Text("87756294455")
		}
	}
}