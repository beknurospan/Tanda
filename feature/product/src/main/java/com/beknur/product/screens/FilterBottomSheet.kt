import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.beknur.domain.model.FilterAttribute
import com.beknur.domain.model.Params
import com.beknur.domain.model.PriceRange

@Composable
fun FilterScreen(
	sizeAttribute:FilterAttribute,
	brandAttribute:FilterAttribute,
	priceRange: PriceRange,
	filterAttributes: List<FilterAttribute>,
	selectedParams: Map<Int, Set<Int>>,
	onClickParams: (Int, Int) -> Unit,
	onPriceChange:(PriceRange)->Unit,
	onBack: () -> Unit,
) {
	Column(
		modifier = Modifier
			.fillMaxSize()
			.background(Color.White)
	) {
		Row(
			modifier = Modifier
				.fillMaxWidth()
				.padding(16.dp),
			horizontalArrangement = Arrangement.SpaceBetween,
			verticalAlignment = Alignment.CenterVertically
		) {
			Text(
				text = "Фильтры",
				fontSize = 20.sp,
				fontWeight = FontWeight.Bold
			)

		}


		LazyColumn(
			modifier = Modifier.weight(1f)
		) {
			item {

				FilterSection(
					title = "Размер",
					params = sizeAttribute.params,
					selected = selectedParams[sizeAttribute.id] ?: emptySet(),
					onClick = { paramId -> onClickParams(sizeAttribute.id, paramId) }
				)
			}
			item {

				FilterSection(
					title = "Бренд",
					params = brandAttribute.params,
					selected = selectedParams[brandAttribute.id] ?: emptySet(),
					onClick = { paramId -> onClickParams(brandAttribute.id, paramId) }
				)
			}


			item {
				PriceFilter(
					min = priceRange.min,
					max = priceRange.max,
					current = priceRange,
					onChange = onPriceChange
				)
			}

			items(filterAttributes){ attribute ->
				FilterSection(
					title = attribute.nameAttribute,
					params = attribute.params,
					selected = selectedParams[attribute.id] ?: emptySet(),
					onClick = { paramId -> onClickParams(attribute.id, paramId) }
				)
			}
		}

	}
}

@Composable
fun FilterSection(
	title: String,
	params: Set<Params>,
	selected: Set<Int>,
	onClick: (Int) -> Unit
) {
	Column(modifier = Modifier.padding(16.dp)) {
		Text(title, fontWeight = FontWeight.Medium, fontSize = 16.sp)
		FlowRow(
			modifier = Modifier.fillMaxWidth(),
		) {
			params
				.sortedByDescending { it.id in selected }
				.forEach { param ->
					val isSelected = param.id in selected
					FilterChip(
						text = param.name,
						selected = isSelected,
						onClick = { onClick(param.id) }
					)
				}

		}
	}
}

@Composable
fun FilterChip(
	text: String,
	selected: Boolean,
	onClick: () -> Unit
) {
	Box(
		modifier = Modifier
			.clip(RoundedCornerShape(16.dp))
			.background(if (selected) Color.Black else Color.LightGray)
			.clickable { onClick() }
			.padding(horizontal = 12.dp, vertical = 8.dp)
	) {
		Text(
			text = text,
			color = if (selected) Color.White else Color.Black,
			fontSize = 14.sp
		)
	}
}

@Composable
fun PriceFilter(
	min: Long,
	max: Long,
	current: PriceRange?,
	onChange: (PriceRange) -> Unit
) {
	Column(modifier = Modifier.padding(16.dp)) {
		Text("Цена", fontWeight = FontWeight.Medium, fontSize = 16.sp)
		Spacer(modifier = Modifier.height(8.dp))
		Row(
			horizontalArrangement = Arrangement.SpaceBetween,
			modifier = Modifier.fillMaxWidth()
		) {
			OutlinedTextField(
				value = (current?.min ?: min).toString(),
				onValueChange = { onChange(
					PriceRange(
						it.toLongOrNull() ?: min,
						current?.max ?: max
					)
				) },
				label = { Text("От") },
				modifier = Modifier.weight(1f)
			)
			Spacer(modifier = Modifier.width(12.dp))
			OutlinedTextField(
				value = (current?.max ?: max).toString(),
				onValueChange = { onChange(
					PriceRange(
						current?.min ?: min,
						it.toLongOrNull() ?: max
					)
				) },
				label = { Text("До") },
				modifier = Modifier.weight(1f)
			)
		}
	}
}

@Preview(showBackground = true)
@Composable
fun FilterScreenPreview() {
	FilterScreen(
		sizeAttribute = FilterAttribute(
			id = 1,
			params = setOf(
				Params(id = 1, name = "36"),
				Params(id = 2, name = "37"),
				Params(id = 3, name = "38")
			),
			nameAttribute = "Размер"
		),
		brandAttribute = FilterAttribute(
			id = 2,
			nameAttribute = "Бренд",
			params = setOf(
				Params(id = 4, name = "Nike"),
				Params(id = 5, name = "Adidas"),
				Params(id = 6, name = "Puma")
			)
		),
		priceRange = PriceRange(0,1000),
		filterAttributes = emptyList(),
		selectedParams = mapOf(
			1 to setOf(1, 2,9),
			2 to setOf(3)
		),
		onClickParams = { attributeId, paramId ->
			println("Clicked param $paramId in attribute $attributeId")
		},
		onPriceChange = {range ->

		},
		onBack = {}
	)
}
