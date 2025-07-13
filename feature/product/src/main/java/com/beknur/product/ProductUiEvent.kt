package com.beknur.product

sealed interface ProductUiEvent {
	data object OnProductSelected:ProductUiEvent
}