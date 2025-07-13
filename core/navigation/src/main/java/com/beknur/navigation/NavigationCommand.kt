package com.beknur.navigation

import androidx.navigation3.runtime.NavKey

sealed interface NavigationCommand  {
	data class Navigate(val screen: NavKey) : NavigationCommand
	data object Back : NavigationCommand
}