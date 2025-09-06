package com.beknur.favorites.di


import com.beknur.favorites.FavoriteViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module


val FavoriteModule= module {
	viewModel { FavoriteViewModel(get())}
}
