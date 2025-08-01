package com.beknur.common.dispatchers

import kotlinx.coroutines.Dispatchers


object DispatcherProvider{
	val io = Dispatchers.IO
	val main = Dispatchers.Main
	val default = Dispatchers.Default
}