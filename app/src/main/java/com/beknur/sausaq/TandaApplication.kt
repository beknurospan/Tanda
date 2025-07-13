package com.beknur.sausaq

import android.app.Application
import com.beknur.catalog.di.СatalogModule
import com.beknur.navigation.di.NavigationModule
import com.beknur.product.di.ProductModule
import com.beknur.productdetail.di.ProductDetailModule
import com.beknur.profile.di.ProfileModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.GlobalContext.startKoin

class TandaApplication:Application() {
	override fun onCreate() {
		super.onCreate()

		startKoin {
			androidContext(this@TandaApplication)

			modules(
				listOf(
					СatalogModule,
					NavigationModule,
					ProductModule,
					ProductDetailModule,
					ProfileModule
				)
			)
		}
	}
}