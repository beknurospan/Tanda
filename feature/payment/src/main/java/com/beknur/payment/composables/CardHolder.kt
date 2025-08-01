package com.beknur.payment.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.beknur.designsystem.theme.WhiteGray


@Composable
fun CardHolder(onClick:()->Unit) {
	Column (modifier = Modifier
		.fillMaxWidth()
		.height(200.dp)
		.background(Color.White)
		.padding(20.dp),
		verticalArrangement = Arrangement.spacedBy(20.dp)
	) {
		Text("Способы оплаты:")
		LazyRow(horizontalArrangement = Arrangement.spacedBy(15.dp)) {
			item {
				AddCardItem(onClick)
			}
			items(5) {
				CardItem()
			}
		}

	}
}


@Preview
@Composable
fun CardHolderPreview() {
	CardHolder({})
}