package com.beknur.database.di

import androidx.room.Room
import com.beknur.database.TndDatabase
import com.beknur.database.dao.AddressDao
import com.beknur.database.dao.CartDao
import com.beknur.database.dao.FavoriteDao
import org.koin.dsl.module

val DatabaseModule = module {

	single<TndDatabase> {
		Room.databaseBuilder(
				get(),
				TndDatabase::class.java,
				"tnd-database"
			).build()
	}

	single<CartDao> { get<TndDatabase>().cartDao() }
	single<AddressDao> { get<TndDatabase>().addressDao() }
	single<FavoriteDao> { get<TndDatabase>().favoriteDao() }
}
