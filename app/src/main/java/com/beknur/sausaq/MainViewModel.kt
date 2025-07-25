package com.beknur.sausaq

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class MainViewModel : ViewModel() {
	private val _isBottomBarVisible = MutableStateFlow(true)
	val isBottomBarVisible: StateFlow<Boolean> = _isBottomBarVisible

	fun setBottomBarVisibility(visible: Boolean) {
		_isBottomBarVisible.value = visible
	}
}
