package com.beknur.address.di

import com.beknur.address.AddressViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val AddressModule= module {
	viewModel { AddressViewModel() }
}