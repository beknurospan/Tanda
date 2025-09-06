package com.beknur.database

import androidx.room.AutoMigration
import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.beknur.database.converter.Converters
import com.beknur.database.dao.AddressDao
import com.beknur.database.dao.CartDao
import com.beknur.database.dao.FavoriteDao
import com.beknur.database.model.AddressEntity
import com.beknur.database.model.CartEntity
import com.beknur.database.model.FavoriteEntity


@Database(
	entities = [CartEntity::class, AddressEntity::class, FavoriteEntity::class],
	version =1 ,
	exportSchema = true
)
@TypeConverters(Converters::class)
abstract class TndDatabase : RoomDatabase() {
	abstract fun cartDao(): CartDao
	abstract fun addressDao(): AddressDao
	abstract fun favoriteDao(): FavoriteDao
}