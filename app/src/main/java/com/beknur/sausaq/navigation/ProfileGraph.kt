package com.beknur.sausaq.navigation

import AuthScreen
import android.provider.ContactsContract.Profile
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation3.runtime.NavBackStack

import com.beknur.profile.ProfileScreen

@Composable
fun ProfileGraph(backStack: NavBackStack){
	AuthScreen()
}