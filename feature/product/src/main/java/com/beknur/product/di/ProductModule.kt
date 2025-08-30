package com.beknur.product.di


import com.beknur.product.ProductViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val ProductModule = module{
	viewModel { ProductViewModel(
		navigationManager = get(),
		productRepository = get()
	) }
}