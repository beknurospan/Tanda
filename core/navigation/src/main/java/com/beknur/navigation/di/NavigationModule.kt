package com.beknur.navigation.di

import com.beknur.navigation.NavigationManager
import org.koin.dsl.module

val NavigationModule = module {
	single { NavigationManager() }
}