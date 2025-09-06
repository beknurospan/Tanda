package com.beknur.productdetail.composables

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.beknur.domain.model.Characteristic

@Preview
@Composable
fun AboutProductPreview() {
	AboutProduct("25", listOf(Characteristic(1,"v" , "s"), Characteristic(2,"l","b")))

}


@Composable
fun AboutProduct(articule:String,mapData:List<Characteristic>) {
	CardWhite {
		Column(
			modifier = Modifier.fillMaxWidth(),
			horizontalAlignment = Alignment.Start,
			verticalArrangement = Arrangement.spacedBy(10.dp)
		) {
			Text("О товаре")
			for(item in mapData){
				Text(item.name,color = Color.Black)
				Text(item.definition, color = Color.DarkGray)
			}
			Text(articule)
		}

	}

}