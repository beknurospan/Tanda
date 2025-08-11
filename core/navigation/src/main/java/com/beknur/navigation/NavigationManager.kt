package com.beknur.navigation

import androidx.navigation3.runtime.NavKey
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow

class NavigationManager {
	private val _commands = MutableSharedFlow<NavigationCommand>()
	val commands = _commands.asSharedFlow()

	suspend fun navigate(screen: NavKey) {
		_commands.emit(NavigationCommand.Navigate(screen))
	}
	suspend fun navigateBack(){
		_commands.emit(NavigationCommand.NavigateBack)
	}
	suspend fun backShowBottom(screen: NavKey) {
		_commands.emit(NavigationCommand.BackShowBottom(screen))
	}
	suspend fun navigateHideBottom(screen: NavKey){
		_commands.emit(NavigationCommand.NavigateHideBottom(screen))
	}
	suspend fun popUntilNavigate(currentScreen: NavKey,screenNavigate:NavKey){
		_commands.emit(NavigationCommand.PopUntilNavigate(currentScreen,screenNavigate))
	}
}