package com.beknur.network.api

import com.beknur.network.model.ProductResponse
import com.beknur.network.model.SuggestItem
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.put
import io.ktor.http.HttpMethod
import io.ktor.http.encodedPath
import io.ktor.http.path
import org.koin.core.qualifier.named
import org.koin.mp.KoinPlatform.getKoin

interface ProductApi {
	suspend fun fetchName(): String
}


class ProductApiImpl(private val client: HttpClient) : ProductApi {
	override suspend fun fetchName(): String {
		val response: ProductResponse = client.get {
			url {
				encodedPath="names"
			}
		}.body()
		return response.name
	}

}