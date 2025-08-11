package com.beknur.navigation

import androidx.navigation3.runtime.NavKey

sealed interface NavigationCommand  {
	data class Navigate(val screen: NavKey) : NavigationCommand
	data object NavigateBack: NavigationCommand
	data class NavigateHideBottom(val screen: NavKey) : NavigationCommand
	data class BackShowBottom(val screen:NavKey) : NavigationCommand
	data class PopUntilNavigate(val currentScreen:NavKey,val screenNavigate:NavKey) : NavigationCommand
}