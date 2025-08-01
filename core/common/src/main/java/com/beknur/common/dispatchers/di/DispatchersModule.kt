package com.beknur.common.dispatchers.di


import com.beknur.common.dispatchers.DispatcherProvider
import kotlinx.coroutines.Dispatchers
import org.koin.dsl.module

val DispatchersModule = module {
	single<DispatcherProvider> {
		DispatcherProvider
	}
}
