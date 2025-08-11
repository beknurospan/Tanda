package com.beknur.sausaq

import android.app.Application
import com.beknur.address.di.AddressModule
import com.beknur.auth.di.AuthModule
import com.beknur.cart.di.CartModule
import com.beknur.catalog.di.СatalogModule
import com.beknur.common.dispatchers.di.DispatchersModule
import com.beknur.database.di.DatabaseModule
import com.beknur.domain.di.UseCasesModule
import com.beknur.navigation.di.NavigationModule
import com.beknur.payment.di.PaymentModule
import com.beknur.product.di.ProductModule
import com.beknur.productdetail.di.ProductDetailModule
import com.beknur.profile.di.ProfileModule
import com.beknur.sausaq.di.AppModule
import com.beknur.data.di.DataModule
import com.beknur.datastore.di.DataStoreModule
import com.beknur.network.NetworkModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.GlobalContext.startKoin

class TandaApplication:Application() {
	override fun onCreate() {
		super.onCreate()

		startKoin {
			androidContext(this@TandaApplication)

			modules(
				listOf(
					AppModule,
					СatalogModule,
					NavigationModule,
					ProductModule,
					ProductDetailModule,
					ProfileModule,
					AuthModule,
					UseCasesModule,
					CartModule,
					PaymentModule,
					AddressModule,
					DatabaseModule,
					DispatchersModule,
					DataModule,
					NetworkModule,
					DataStoreModule
				)
			)
		}
	}
}