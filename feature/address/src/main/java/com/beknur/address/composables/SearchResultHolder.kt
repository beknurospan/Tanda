package com.beknur.address.composables

import android.app.appsearch.SearchResult
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.beknur.domain.model.MySearchResult

@Preview
@Composable
fun SearchResultHolderPreview() {
	SearchResultHolder(listOf(MySearchResult("address","full name"))){}
}



@Composable
fun SearchResultHolder(
	searchResults:List<MySearchResult>,
	onItemClick:(MySearchResult)->Unit
) {
	LazyColumn(modifier = Modifier
		.fillMaxSize()
		.background(Color.White)
	) {
		items(searchResults){ result->
			SearchResultItem(result.name,result.fullName){
				onItemClick(result)
			}
		}

	}
}