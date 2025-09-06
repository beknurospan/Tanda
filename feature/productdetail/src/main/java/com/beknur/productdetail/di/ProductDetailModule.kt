package com.beknur.productdetail.di

import com.beknur.productdetail.ProductDetailViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val ProductDetailModule = module {
	viewModel { (id: Int, skuId: Int) ->
		ProductDetailViewModel(
			get(),
			get(),
			get(),
			get(),
			id = id,
			skuId = skuId,

		)
	}
}
