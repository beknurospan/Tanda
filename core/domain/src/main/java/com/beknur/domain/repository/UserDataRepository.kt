package com.beknur.domain.repository

import com.beknur.domain.model.Address
import com.beknur.domain.model.MySearchResult
import com.beknur.domain.model.UserData
import kotlinx.coroutines.flow.Flow

interface UserDataRepository {
	suspend fun getSearchResult(query: String):List<MySearchResult>
	suspend fun getUserData():Flow<UserData>
	suspend fun updateUserName(userName: String)
	suspend fun updateSuitableTimeDelivery(suitableTimeDelivery: String)
	suspend fun updateChosenAddress(chosenAddress: Address)
	suspend fun updateAdditionalAddressInfo(additionalAddressInfo: String)
}