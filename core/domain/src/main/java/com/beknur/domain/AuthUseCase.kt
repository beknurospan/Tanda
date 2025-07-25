package com.beknur.domain

class AuthUseCase {
	class Auth{
		companion object {
			var isAuth=false
		}
	}

	fun isAuth():Boolean{
		return Auth.isAuth
	}
	fun changeAuth(){
		Auth.isAuth=true
	}
}

