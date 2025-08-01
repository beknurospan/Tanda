package com.beknur.data.di

import com.beknur.data.repository.CartRepositoryImpl
import com.beknur.domain.repository.CartRepository
import org.koin.dsl.module

val DataModule=module{
	single<CartRepository>{CartRepositoryImpl(get(),get())}
}