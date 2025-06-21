package com.beknur.catalog

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SearchBar

import androidx.compose.material3.Text

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalDensity
import com.beknur.designsystem.theme.Green


import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.max
import com.beknur.designsystem.theme.Gray
import com.beknur.designsystem.theme.GreenDark


@Composable
fun CatalogScreen(onClick: () -> Unit) {


	Column(
		Modifier
			.fillMaxSize()
			.background(Color.White),
		horizontalAlignment = Alignment.CenterHorizontally
	) {
		Spacer(modifier = Modifier.height(12.dp))
		SearchBarPlaceholder(onClick = onClick)
		Bar()
		Spacer(modifier = Modifier.height(24.dp))
		LazyColumn () {
			items(15) {
				ProductIcon("товар")
			}

		}

	}
}

@Preview
@Composable
fun CatalogScreenPreview() {
	CatalogScreen { {} }
}


@Composable
fun SearchBarPlaceholder(onClick: () -> Unit) {
	Box(
		modifier = Modifier
			.fillMaxWidth()
			.height(86.dp),
		contentAlignment = Alignment.Center

	) {
		Row(
			modifier = Modifier
				.fillMaxWidth()
				.height(36.dp)
				.padding(horizontal = 36.dp)
				.clip(RoundedCornerShape(10.dp))
				.background(MaterialTheme.colorScheme.surfaceVariant)
				.clickable { onClick() },
			verticalAlignment = Alignment.CenterVertically


		) {


			Icon(
				modifier = Modifier.padding(start = 8.dp),
				imageVector = Icons.Default.Search,
				contentDescription = ""
			)
			Spacer(modifier = Modifier.width(8.dp))
			Text(
				text = "Поиск",
				color = Color.Gray
			)
		}
	}
}

@Composable
fun AnimatedSegmentedControl(
	options: List<String>,
	selectedIndex: Int,
	onSelectedChange: (Int) -> Unit,
	maxWidth: Dp
) {
	val segmentWidth = (maxWidth-72.dp) / options.size
	val indicatorOffset by animateDpAsState(targetValue = segmentWidth * selectedIndex)

	Box(
		modifier = Modifier
			.fillMaxWidth()
			.padding(horizontal = 36.dp)
			.clip(RoundedCornerShape(14.dp))
			.background(Gray)
			.height(36.dp),
		contentAlignment = Alignment.CenterStart
	) {
		// Анимируемый зелёный индикатор
		Box(
			modifier = Modifier
				.offset(x = indicatorOffset)
				.width(segmentWidth)
				.fillMaxHeight()
				.shadow(6.dp, shape = RoundedCornerShape(14.dp))
				.clip(RoundedCornerShape(14.dp))
				.background(GreenDark)




		)

		Row(modifier = Modifier.fillMaxWidth()) {
			options.forEachIndexed { index, title ->
				Box(
					modifier = Modifier
						.width(segmentWidth)
						.fillMaxHeight()
						.clickable { onSelectedChange(index) },
					contentAlignment = Alignment.Center
				) {
					Text(
						text = title,
						color = if (index == selectedIndex) Color.Black else Color.DarkGray
					)
				}
			}
		}
	}
}

@Composable
fun Bar() {
	var selectedIndex by remember { mutableStateOf(0) }
	val options = listOf("мужчины", "женщины", "дети")
	val configuration = LocalConfiguration.current
	val screenWidthDp = configuration.screenWidthDp.dp
	AnimatedSegmentedControl(
		options = options,
		selectedIndex = selectedIndex,
		onSelectedChange = { selectedIndex = it },
		screenWidthDp
	)
}

@Preview
@Composable
fun ProductIcon(text:String) {

	Row (modifier = Modifier.fillMaxWidth().padding(horizontal = 36.dp, vertical = 12.dp), verticalAlignment = Alignment.CenterVertically){
		Box(
			modifier = Modifier
				.width(44.dp)
				.height(44.dp)
				.clip(
					RoundedCornerShape(8.dp)
				)
				.background(GreenDark)

		)

		Text(text, modifier = Modifier.padding(horizontal = 12.dp))

	}




}
