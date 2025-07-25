package com.beknur.profile.di

import com.beknur.profile.ProfileViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val ProfileModule= module {
	viewModel { ProfileViewModel(get(),get()) }
}