package com.beknur.address.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

import com.beknur.address.composables.SearchResultHolder
import com.beknur.designsystem.ui.SearchTextField
import com.beknur.domain.model.MySearchResult


@Composable
fun AddressSearchScreen(
	searchQuery: String,
	onSearchQueryChange: (String) -> Unit,
	searchResults: List<MySearchResult>,
	onResultClick:(MySearchResult)->Unit
) {
	Column(
		Modifier
			.fillMaxSize()
			.background(Color.White)
			.padding(top=20.dp, start = 20.dp, end = 20.dp)
	) {
		SearchTextField(
			isEnabled = true,
			value = searchQuery,
			onValueChange = {newQuery->onSearchQueryChange.invoke(newQuery)}
		)
		Spacer(modifier = Modifier.height(15.dp))
		SearchResultHolder(
			searchResults=searchResults,
			onItemClick = onResultClick
		)
	}
}

@Preview
@Composable
fun AddressSearchScreenPreview() {
	AddressSearchScreen(
		"",
		{},
		listOf(
			MySearchResult("Т мусабаев 23 2","full adress"),
			MySearchResult("address","full adress"),
			MySearchResult("address","full adress"),
			MySearchResult("address","full adress"),
			MySearchResult("address","full adress"),
			MySearchResult("address","full adress"),
			MySearchResult("address","full adress"),
			MySearchResult("address","full adress"),


		),
		{}
	)
}