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

	suspend fun back() {
		_commands.emit(NavigationCommand.Back)
	}
}