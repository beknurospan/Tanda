package com.beknur.database

import androidx.room.AutoMigration
import androidx.room.Database
import androidx.room.RoomDatabase
import com.beknur.database.dao.AddressDao
import com.beknur.database.dao.CartDao
import com.beknur.database.model.AddressEntity
import com.beknur.database.model.CartEntity


@Database(entities = [CartEntity::class, AddressEntity::class],  version = 3, exportSchema = true)
abstract class TndDatabase: RoomDatabase() {
	abstract fun cartDao(): CartDao
	abstract fun addressDao(): AddressDao
}