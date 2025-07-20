package com.beknur.network.test

import com.beknur.network.HttpClientProvider.client
import com.beknur.network.api.DgisApiImpl
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext


import kotlinx.coroutines.*

fun main() = runBlocking {
	val api = DgisApiImpl(client)

	val deferred = async(Dispatchers.IO) {
		println("⚡ Старт main()")
		try {
			val results = api.fetchSuggestions("Саялы 24")
			println("✅ Получено результатов: ${results.size}")
			results.forEachIndexed { index, item ->
				println("Result #$index")
				println("Full name: ${item.fullName}")
				println("Address name: ${item.addressName}")
				println("---------")
			}
		} catch (e: Exception) {
			println("мок")
			println("❌ Ошибка: ${e.message}")
			e.printStackTrace()
		} finally {
			println("мок2")
			client.close()
		}
	}

	deferred.await() // дождаться выполнения
}

