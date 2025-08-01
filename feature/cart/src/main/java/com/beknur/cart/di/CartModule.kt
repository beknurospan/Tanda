package com.beknur.cart.di

import com.beknur.cart.CartViewModel
import com.beknur.domain.repository.CartRepository
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val CartModule= module {
	viewModel { CartViewModel(get(),get()) }
}