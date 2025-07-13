package com.beknur.productdetail.di

import com.beknur.productdetail.ProductDetailViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val ProductDetailModule= module {
	viewModel { ProductDetailViewModel(get()) }
}