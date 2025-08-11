package com.beknur.network.test

import com.beknur.network.api.ProductApiImpl
import io.ktor.client.HttpClient
import io.ktor.client.engine.cio.CIO
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.http.URLProtocol
import io.ktor.http.encodedPath
import io.ktor.serialization.kotlinx.json.json
import kotlinx.coroutines.runBlocking
import kotlinx.serialization.json.Json
import org.junit.Test // Import JUnit's Test annotation
import org.junit.Assert // For assertions

class NetworkClientTest {

	object TestClient { // Renamed to avoid conflict if you keep the original 'Test' object elsewhere
		val client = HttpClient(CIO) {
			install(ContentNegotiation) {
				json(
					Json {
						ignoreUnknownKeys = true
						prettyPrint = true
						isLenient = true
					}
				)
			}
			defaultRequest {
				url {
					protocol = URLProtocol.HTTP // Make sure your test server is running on HTTP
					host = "localhost"
					port = 8080
					encodedPath = "/api/v1/"
				}
			}
		}
	}

	@Test
	fun testGetProductType() = runBlocking {
		val api = ProductApiImpl(client = TestClient.client)
		// Assuming getProductType returns some DTO and doesn't throw an exception on success
		// You might want to add assertions here to verify the result
		try {
			val dto = api.getProductType(1)
			println(dto) // Or use Assert.assertNotNull(dto), etc.
			// Assert.assertEquals(expectedValue, dto.someProperty)
		} catch (e: Exception) {
			// Handle exceptions, perhaps fail the test
			e.printStackTrace()
			Assert.fail("API call failed: ${e.message}")
		}
	}
}
