package com.beknur.data.repository

import com.beknur.domain.model.Address
import com.beknur.data.mappers.toMySearchResult
import com.beknur.datastore.UserDataSource
import com.beknur.domain.model.MySearchResult
import com.beknur.domain.model.UserData
import com.beknur.domain.repository.UserDataRepository
import com.beknur.network.api.DgisApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.flow.flow

class UserDataRepositoryImpl(
	private val twoGisApi: DgisApi,
	private val userData:UserDataSource
): UserDataRepository {
	override suspend fun getSearchResult(query: String): List<MySearchResult> {
		val list= twoGisApi.fetchSuggestions(query)
		flow{
			emit(list)
		}.debounce {
			1000L
		}
		return list.filter { it.addressName!=null }.map { it.toMySearchResult()}

	}
	override suspend fun getUserData(): Flow<UserData> {
		return userData.getUserData()
	}

	override suspend fun updateUserName(userName: String) {
		userData.updateUserName(userName)
	}
	override suspend fun updateSuitableTimeDelivery(suitableTimeDelivery: String) {
		userData.updateSuitableTimeDelivery(suitableTimeDelivery)
	}

	override suspend fun updateChosenAddress(chosenAddress:Address) {
		userData.updateChosenAddress(chosenAddress)
	}

	override suspend fun updateAdditionalAddressInfo(additionalAddressInfo: String) {
		userData.updateAdditionalAddress(additionalAddressInfo)
	}
}


