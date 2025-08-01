package com.beknur.payment.di

import com.beknur.payment.PaymentViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val PaymentModule= module {
	viewModel { PaymentViewModel(get()) }
}