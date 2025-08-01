package com.beknur.network.test


import com.beknur.network.NetworkModule
import com.beknur.network.api.DgisApi
import com.beknur.network.api.ProductApi
import kotlinx.coroutines.runBlocking
import org.koin.core.context.GlobalContext
import org.koin.core.context.startKoin
import org.koin.java.KoinJavaComponent.inject
import org.koin.mp.KoinPlatform.getKoin

fun main() = runBlocking {
	startKoin { modules(NetworkModule) }

	val Api = GlobalContext.get().get<ProductApi>()
	val Api2 = GlobalContext.get().get<DgisApi>()
	MyFeature(Api2).run()
}

class MyFeature(private val api: DgisApi) {
	suspend fun run() {
		val result = api.fetchSuggestions("Сатпаев")
		println(result)
	}
}
