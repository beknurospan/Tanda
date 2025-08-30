package com.beknur.tanda.firebase.remote_config


import android.text.TextUtils.replace
import com.beknur.tanda.AppVersionProvider
import com.google.firebase.Firebase
import com.google.firebase.remoteconfig.FirebaseRemoteConfig
import com.google.firebase.remoteconfig.remoteConfig
import com.google.firebase.remoteconfig.remoteConfigSettings

class RemoteConfig {
	val remoteConfig: FirebaseRemoteConfig = Firebase.remoteConfig
	val configSettings = remoteConfigSettings {
		minimumFetchIntervalInSeconds = MINIMUM_FETCH_INTERVAL
	}

	init {
		remoteConfig.setConfigSettingsAsync(configSettings)
	}

	fun checkForUpdateGetStoreUrl(onComplete: (String) -> Unit) {
		remoteConfig.fetchAndActivate()
			.addOnCompleteListener { task ->
				if (task.isSuccessful) {
					if (checkUpdateRequired()) {
						val currentVersion = AppVersionProvider.versionName
							.replace(".", "")
							.toIntOrNull() ?: 0
						val requiredVersion = getRequiredVersion()
							.replace(".", "")
							.toIntOrNull() ?: 0

						if (currentVersion < requiredVersion) {
							onComplete(getUpdateUrl())
							return@addOnCompleteListener
						}
					}
					onComplete("")
				} else {
					onComplete("")
				}
			}
	}


	fun checkUpdateRequired(): Boolean {
		return remoteConfig.getBoolean(KEY_UPDATE_REQUIRED)
	}

	fun getUpdateUrl(): String {
		return remoteConfig.getString(KEY_UPDATE_URL)
	}

	fun getRequiredVersion(): String {
		return remoteConfig.getString(KEY_REQUIRED_VERSION)
	}

	companion object {
		const val KEY_UPDATE_REQUIRED = "android_force_update_required"
		const val KEY_REQUIRED_VERSION = "android_force_update_required_version"
		const val KEY_UPDATE_URL = "android_force_update_store_url"
		const val MINIMUM_FETCH_INTERVAL = 60L
	}


}