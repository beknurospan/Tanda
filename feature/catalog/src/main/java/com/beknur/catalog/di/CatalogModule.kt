package com.beknur.catalog.di

import com.beknur.catalog.CatalogViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val СatalogModule= module {
	viewModel { CatalogViewModel(get())}
}