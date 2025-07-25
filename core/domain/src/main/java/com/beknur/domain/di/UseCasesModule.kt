package com.beknur.domain.di

import com.beknur.domain.AuthUseCase
import org.koin.dsl.module

val UseCasesModule= module {
	single { AuthUseCase() }
}