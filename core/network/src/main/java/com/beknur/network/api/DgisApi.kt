package com.beknur.network.api

import com.beknur.network.model.DgisSuggestResponse
import com.beknur.network.model.SuggestItem
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.parameter



interface DgisApi {
	suspend fun fetchSuggestions(query: String): List<SuggestItem>
}

class DgisApiImpl(private val client: HttpClient) : DgisApi {
	override suspend fun fetchSuggestions(query: String): List<SuggestItem> {
		val response: DgisSuggestResponse = client.get("https://catalog.api.2gis.com/3.0/suggests") {
			parameter("q", query)
			parameter("location", "76.9,43.25")
			parameter("suggest_type", "address")
			parameter("key", "8d657ddd-062a-4e9f-b196-b4d3c5ada981")
		}.body()

		return response.result.items
	}
}



