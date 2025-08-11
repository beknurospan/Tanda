package com.beknur.datastore.di

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.core.DataStoreFactory
import androidx.datastore.dataStoreFile
import com.beknur.datastore.UserDataSource
import com.beknur.datastore.serializer.UserDataSerializer
import com.beknur.domain.model.UserData
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import org.koin.dsl.module

val DataStoreModule = module {


	single<UserDataSerializer> { UserDataSerializer() }


	single<DataStore<UserData>> {
		val context: Context = get()
		val serializer: UserDataSerializer = get()

		DataStoreFactory.create(
			serializer = serializer,
			scope = CoroutineScope(Dispatchers.IO + SupervisorJob()),
			migrations = listOf()
		) {
			context.dataStoreFile("user_data.pb")
		}
	}
	single <UserDataSource> { UserDataSource(get()) }
}