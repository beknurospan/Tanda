package com.beknur.database

import androidx.room.AutoMigration
import androidx.room.Database
import androidx.room.RoomDatabase
import com.beknur.database.dao.CartDao
import com.beknur.database.model.CartEntity


@Database(entities = [CartEntity::class],  version = 2, exportSchema = true)
abstract class TndDatabase: RoomDatabase() {
	abstract fun cartDao(): CartDao
}