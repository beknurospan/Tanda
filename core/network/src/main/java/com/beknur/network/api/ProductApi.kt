package com.beknur.network.api


import com.beknur.network.model.ProductDto
import com.beknur.network.model.ProductTypesDto
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.parameter
import io.ktor.http.encodedPath

interface ProductApi {
	suspend fun getProductType(id:Int): ProductTypesDto
	suspend fun getProduct(id:Int,skuId: Int): ProductDto
}


class ProductApiImpl(private val client: HttpClient) : ProductApi {
	override suspend fun getProductType(id:Int): ProductTypesDto {
		val response: ProductTypesDto = client.get {
			url {
				encodedPath="product/variants"
			}
			parameter("id",id)

		}.body()
		return response
	}

	override suspend fun getProduct(id: Int,skuId:Int): ProductDto {
		val response: ProductDto = client.get {
			url{
				encodedPath="product"
			}
			parameter("id",id)
			parameter("sku_id",skuId)
		}.body()
		return response
	}

}






