package com.beknur.database

import androidx.room.DeleteColumn
import androidx.room.DeleteTable
import androidx.room.migration.AutoMigrationSpec

object TndMigrations {
	@DeleteColumn(
		tableName = "cart",
		columnName = "sum",
	)
	class Schema1to2 : AutoMigrationSpec

}