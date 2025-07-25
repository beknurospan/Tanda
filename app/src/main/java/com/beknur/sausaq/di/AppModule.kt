package com.beknur.sausaq.di

import com.beknur.sausaq.MainViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val AppModule = module {
	viewModel { MainViewModel() }
}