package com.beknur.datastore

import androidx.datastore.core.DataStore
import com.beknur.domain.model.Address
import com.beknur.domain.model.UserData
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class UserDataSource(
	private val dataStore: DataStore<UserData>
) {
	val userName: Flow<String> = dataStore.data.map { it.userName }
	val userBirth: Flow<String> = dataStore.data.map { it.userBirth }
	val userPhone: Flow<String> = dataStore.data.map { it.userPhone }
	val chosenAddress: Flow<Address> = dataStore.data.map { it.chosenAddress }
	val additionalAddressInfo: Flow<String> = dataStore.data.map { it.additionalAddressInfo }
	val suitableTimeDelivery: Flow<String> = dataStore.data.map { it.suitableTimeDelivery }

	fun getUserData(): Flow<UserData> {
		return  dataStore.data
	}

	suspend fun updateUserName(userName: String) {
		dataStore.updateData { userData ->
			userData.copy(
				userName = userName,
			)
		}
	}

	suspend fun updateUserBirth(userBirth: String) {
		dataStore.updateData { userData ->
			userData.copy(
				userBirth = userBirth
			)
		}
	}

	suspend fun updateUserPhone(userPhone: String) {
		dataStore.updateData { userData ->
			userData.copy(
				userPhone = userPhone
			)
		}
	}

	suspend fun updateChosenAddress(chosenAddress: Address) {
		dataStore.updateData { userData ->
			userData.copy(
				chosenAddress = chosenAddress
			)
		}
	}
	suspend fun updateAdditionalAddress(additionalAddressInfo: String) {
		dataStore.updateData { userData ->
			userData.copy(
				additionalAddressInfo = additionalAddressInfo
			)
		}
	}
	suspend fun updateSuitableTimeDelivery(suitableTimeDelivery: String)  {
		dataStore.updateData { userData ->
			userData.copy(
				suitableTimeDelivery = suitableTimeDelivery
			)
		}
	}


}