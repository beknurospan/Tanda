package com.beknur.cart

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.beknur.cart.composables.AddProduct
import com.beknur.cart.composables.PayButton
import com.beknur.designsystem.theme.WhiteAdd
import com.beknur.designsystem.theme.WhiteGray

@Preview()
@Composable
fun CartScreen() {

	Box(
		modifier = Modifier
			.fillMaxSize()
			.background(WhiteGray)
	) {
		LazyColumn(
			verticalArrangement = Arrangement.spacedBy(5.dp),
			contentPadding = PaddingValues(10.dp)
		) {
			items(5) {
				AddProduct()
			}
		}

		PayButton(Modifier.align(Alignment.BottomCenter))
	}

}


