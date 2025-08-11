package com.beknur.datastore.serializer


import android.util.Log
import androidx.datastore.core.Serializer
import com.beknur.domain.model.UserData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.decodeFromByteArray
import kotlinx.serialization.encodeToByteArray
import kotlinx.serialization.protobuf.ProtoBuf
import java.io.InputStream
import java.io.OutputStream

class UserDataSerializer : Serializer<UserData> {
	override val defaultValue: UserData
		get() = UserData()

	@OptIn(ExperimentalSerializationApi::class)
	override suspend fun readFrom(input: InputStream): UserData {
		val bytes = input.readBytes()
		Log.d("UserDataSerializer", "Read ${bytes.size} bytes from file")
		return if (bytes.isEmpty()) {
			defaultValue
		} else {
			ProtoBuf.decodeFromByteArray(UserData.serializer(), bytes)
		}
	}
	@OptIn(ExperimentalSerializationApi::class)
	override suspend fun writeTo(t: UserData, output: OutputStream) {
		withContext(Dispatchers.IO) {
			output.write(ProtoBuf.encodeToByteArray(t))
		}
	}
}