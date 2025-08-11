package com.beknur.tanda.di

import com.beknur.tanda.MainViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val AppModule = module {
	viewModel { MainViewModel() }
}