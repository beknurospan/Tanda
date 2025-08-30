package com.beknur.tanda

import android.util.Log
import android.widget.Toast
import androidx.lifecycle.ViewModel
import com.beknur.tanda.firebase.remote_config.RemoteConfig
import com.google.firebase.Firebase
import com.google.firebase.messaging.FirebaseMessaging
import com.google.firebase.messaging.messaging
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class MainViewModel : ViewModel() {
	private val _isBottomBarVisible = MutableStateFlow(true)
	val isBottomBarVisible: StateFlow<Boolean> = _isBottomBarVisible

	private val _updateUrl = MutableStateFlow<String>("")
	val updateUrl: StateFlow<String> = _updateUrl

	init {
		FirebaseMessaging.getInstance().token.addOnCompleteListener { task ->
			if (task.isSuccessful) {
				val token = task.result
			} else {
				Log.d("FCM", "Failed to fetch token", task.exception)
			}
		}
		Firebase.messaging.subscribeToTopic("allDevices")
			.addOnCompleteListener { task ->
				var msg = "Subscribed"
				if (!task.isSuccessful) {
					msg = "Subscribe failed"
				}
				Log.d("FCM", msg)
			}


		val remote= RemoteConfig()
		remote.checkForUpdateGetStoreUrl { storeUrl ->
			if (storeUrl.isNotEmpty()){
				_updateUrl.value=storeUrl
			}
		}
	}


	fun setBottomBarVisibility(visible: Boolean) {
		_isBottomBarVisible.value = visible
	}
}
