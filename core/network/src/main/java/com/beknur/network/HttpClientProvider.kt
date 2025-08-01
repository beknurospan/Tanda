package com.beknur.network

import com.beknur.network.api.DgisApi
import com.beknur.network.api.DgisApiImpl
import com.beknur.network.api.ProductApi
import com.beknur.network.api.ProductApiImpl
import io.ktor.client.HttpClient
import io.ktor.client.HttpClientConfig
import io.ktor.client.engine.cio.CIO
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.client.request.header
import io.ktor.http.ContentType.Application.Json
import io.ktor.http.URLProtocol
import io.ktor.http.encodedPath
import io.ktor.http.path
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import org.koin.core.qualifier.named
import org.koin.dsl.module




fun createHttpClient(configure: HttpClientConfig<*>.() -> Unit): HttpClient {
	return HttpClient(CIO) {
		install(ContentNegotiation) {
			json(
				Json {
					ignoreUnknownKeys = true
					prettyPrint = true
					isLenient = true
				}
			)
		}
		configure()
	}
}

val NetworkModule = module {

	single(named("DgisClient")) {
		createHttpClient {
			defaultRequest {
				url {
					protocol = URLProtocol.HTTPS
					host = "catalog.api.2gis.com"
					encodedPath = "/3.0/"
				}
			}
		}
	}

	single(named("BackendClient")) {
		createHttpClient {
			defaultRequest {
				url {
					protocol = URLProtocol.HTTP
					host = "localhost"
					port=8080
					encodedPath="/api/v1/"
				}
			}
		}
	}
	single<ProductApi> {
		ProductApiImpl(get(named("BackendClient")))
	}
	single<DgisApi> {
		DgisApiImpl(get(named("DgisClient")))
	}
}

