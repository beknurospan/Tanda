package com.beknur.auth

data class AuthViewState(
	val phoneNumber:String,
	val isOtpMode:Boolean,
	val otpCode:String,
	val code:String
)
