package com.beknur.tanda.firebase.firebase_messaging_service

import android.app.NotificationChannel
import android.app.NotificationManager
import android.os.Build
import android.util.Log
import androidx.core.app.NotificationCompat
import com.beknur.tanda.R
import com.google.firebase.messaging.FirebaseMessagingService

import com.google.firebase.messaging.RemoteMessage

class FirebaseMessagingService : FirebaseMessagingService() {


	private val userId:String= "userId"

	override fun onNewToken(token: String) {
		super.onNewToken(token)
		Log.d("FCM", "Token: $token")

	}

	override fun onMessageReceived(remoteMessage: RemoteMessage) {
		super.onMessageReceived(remoteMessage)
		remoteMessage.data.let {
			Log.d("FCM", "Message data payload: $it")
			showNotification(it["title"], it["body"])
		}
	}

	private fun showNotification(title: String?, body: String?) {
		val channelId = "default_channel"
		val channelName = "Default Channel"

		val notificationManager = getSystemService(NOTIFICATION_SERVICE) as NotificationManager
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
			val channel = NotificationChannel(channelId, channelName, NotificationManager.IMPORTANCE_HIGH)
			notificationManager.createNotificationChannel(channel)
		}

		val notification = NotificationCompat.Builder(this, channelId)
			.setContentTitle(title)
			.setContentText(body)
			.setSmallIcon(R.drawable.bell)
			.setPriority(NotificationCompat.PRIORITY_HIGH)
			.build()

		notificationManager.notify(0, notification)
	}
}