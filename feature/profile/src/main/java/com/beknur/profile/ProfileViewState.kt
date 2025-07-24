package com.beknur.profile

data class ProfileViewState(
	val userName:String,
	val userPhone:String,
	val isAuth:Boolean,
	val currentLang:LangParamsUI
)
