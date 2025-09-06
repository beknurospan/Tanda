package com.beknur.data.repository

import android.util.Log
import com.beknur.data.mappers.toFavorite
import com.beknur.data.mappers.toFavoriteEntity
import com.beknur.database.dao.FavoriteDao
import com.beknur.domain.model.Favorite
import com.beknur.domain.model.ProductDetail
import com.beknur.domain.repository.FavoriteRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map


class FavoriteRepositoryImpl(
	private val favoriteDao: FavoriteDao
) : FavoriteRepository {
	override fun getFavorites(): Flow<List<Favorite>> {
		return favoriteDao.getFavoriteEntities()
			.map { entities -> entities.map { favoriteEntity -> favoriteEntity.toFavorite() } }
	}

	override suspend  fun addFavorite(favorite: Favorite) {
		favoriteDao.insertFavoriteEntity(favorite.toFavoriteEntity())
	}

	override suspend  fun removeFavorite(favorite: Favorite) {
		favoriteDao.deleteFavoriteEntity(favorite.productId)
	}

	override suspend  fun updateFavorite(favorite: Favorite) {
		favoriteDao.updateFavoriteEntity(favorite.toFavoriteEntity())
	}

	override suspend  fun toggleFavorite(productDetail: ProductDetail) {
		if (productDetail.isFavorite) {
			addFavorite(productDetail.toFavorite())
			Log.d("beknurslog", "toggleFavorite: ${productDetail.isFavorite}")
		} else {
			removeFavorite(productDetail.toFavorite())
			Log.d("beknurslog", "toggleFavorite: ${productDetail.isFavorite}")
		}

	}

}