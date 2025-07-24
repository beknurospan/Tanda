package com.beknur.auth.di

import com.beknur.auth.AuthViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val AuthModule= module {
	viewModel{
		AuthViewModel(get())
	}
}