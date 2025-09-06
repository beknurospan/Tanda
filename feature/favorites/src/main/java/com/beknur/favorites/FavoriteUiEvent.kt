package com.beknur.favorites

sealed interface FavoriteUiEvent {
	data class OnFavoriteClick(val id: Int) : FavoriteUiEvent
	object OnHeartClick : FavoriteUiEvent
}