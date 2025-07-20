package com.beknur.network

import io.ktor.client.HttpClient
import io.ktor.client.engine.cio.CIO
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.http.ContentType.Application.Json
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json


object HttpClientProvider {

	val client: HttpClient by lazy {
		HttpClient(CIO) {
			install(ContentNegotiation) {
				json(
					Json {
						ignoreUnknownKeys = true
						prettyPrint = true
						isLenient = true
					}
				)
			}
		}
	}
}
