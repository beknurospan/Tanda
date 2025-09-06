package com.beknur.database.converter

import androidx.room.TypeConverter
import com.google.gson.Gson

class Converters {
	private val gson = Gson()

	@TypeConverter
	fun fromList(value: List<Int>): String = gson.toJson(value)

	@TypeConverter
	fun toList(value: String): List<Int> =
		gson.fromJson(value, Array<Int>::class.java).toList()
}