package com.beknur.favorites

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.beknur.domain.repository.FavoriteRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class FavoriteViewModel(
	private val favoriteRepository: FavoriteRepository
) : ViewModel() {

	private val _viewState=MutableStateFlow<FavoriteViewState>(FavoriteViewState())
	val viewState=_viewState.asStateFlow()
	init {
		getFavorites()
	}

	fun getFavorites(){
		viewModelScope.launch {
			Log.d("beknurslog", "getFavorites: Вызван ")
			favoriteRepository.getFavorites().collect{ favorites ->
				Log.d("beknurslog", "getFavorites: коллект  $favorites ")
				_viewState.update { it.copy(favorites = favorites) }
			}
		}

	}
	fun handleEvent(event:FavoriteUiEvent){
		when(event){
			is FavoriteUiEvent.OnFavoriteClick -> onFavoriteClick(event.id)
			is FavoriteUiEvent.OnHeartClick -> onHeartClick()
		}
	}
	fun onFavoriteClick(id:Int){

	}
	fun onHeartClick(){

	}
}