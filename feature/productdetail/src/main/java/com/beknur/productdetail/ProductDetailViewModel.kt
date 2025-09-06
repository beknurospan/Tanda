package com.beknur.productdetail

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.beknur.domain.model.Product
import com.beknur.domain.model.ProductDetail
import com.beknur.domain.repository.CartRepository
import com.beknur.domain.repository.FavoriteRepository
import com.beknur.domain.repository.ProductRepository
import com.beknur.domain.util.Loadable
import com.beknur.domain.util.Resource
import com.beknur.navigation.NavigationManager
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class ProductDetailViewModel(
	private val navigationManager: NavigationManager,
	private val productRepository: ProductRepository,
	private val cartRepository: CartRepository,
	private val favoriteRepository: FavoriteRepository,
	private val id: Int,
	private val skuId: Int
) : ViewModel() {


	private val _viewState =
		MutableStateFlow<ProductDetailViewState>(ProductDetailViewState(Loadable.Idle))
	val viewState = _viewState.asStateFlow()

	init {
		_viewState.update { it.copy(Loadable.Loading) }
		getProductDetail(id, skuId)
	}

	fun getProductDetail(id: Int, skuId: Int) {
		viewModelScope.launch {


			val result = productRepository.getProductDetail(id, skuId)
			Log.d("msfa", "onAddCart: $result")
			when (result) {
				is Resource.Error -> {
					_viewState.update { it.copy(Loadable.Error(result.throwable)) }
				}

				is Resource.Success<*> -> {
					_viewState.update { it.copy(Loadable.Success(result.data as ProductDetail)) }
				}
			}


		}
	}


	fun handleEvent(event: ProductDetailUiEvent) {
		when (event) {
			is ProductDetailUiEvent.OnSizeSelected -> onSizeSelected(event.size)
			is ProductDetailUiEvent.OnAddCartClicked -> onAddCart(event.productId, event.skuId)
			ProductDetailUiEvent.OnHeartClicked -> onHeartClick()
		}
	}

	fun onHeartClick() {
		val current = _viewState.value.productDetail
		if (current is Loadable.Success) {
			val updated = current.data.copy(isFavorite = !current.data.isFavorite)
			_viewState.update { it.copy(productDetail = Loadable.Success(updated)) }
			viewModelScope.launch {
				Log.d("beknurslog", "onHeartClick: ${updated.isFavorite}")
				favoriteRepository.toggleFavorite(updated)
			}

		}

	}


	fun onSizeSelected(size: Int) {
		_viewState.update { it.copy(selectedSize = size) }
	}

	fun onAddCart(productId: Int, skuId: Int) {
		Log.d("Additions", "onAddCart: $productId $skuId")
		viewModelScope.launch {
			val res = productRepository.getProduct(productId, skuId)
			Log.d("Additions", "onAddCart: $res")
			when (res) {
				is Resource.Error -> {}
				is Resource.Success<Product> -> {
					val product = res.data
					cartRepository.insertOrAdd(product)
				}
			}

		}
	}
}