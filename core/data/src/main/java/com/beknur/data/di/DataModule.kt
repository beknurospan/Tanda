package com.beknur.data.di

import com.beknur.data.repository.AddressRepositoryImpl
import com.beknur.data.repository.CartRepositoryImpl
import com.beknur.data.repository.UserDataRepositoryImpl
import com.beknur.domain.repository.AddressRepository
import com.beknur.domain.repository.CartRepository
import com.beknur.domain.repository.UserDataRepository
import org.koin.dsl.module

val DataModule=module{
	single<CartRepository>{CartRepositoryImpl(get(),get())}
	single<UserDataRepository>{ UserDataRepositoryImpl(get(),get())}
	single<AddressRepository>{AddressRepositoryImpl(get())}
}