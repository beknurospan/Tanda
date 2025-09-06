package com.beknur.favorites

import com.beknur.domain.model.Favorite

data class FavoriteViewState(
	val favorites:List<Favorite> = emptyList()
)
