package com.beknur.cart

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.beknur.domain.model.CartProduct
import com.beknur.domain.model.Product
import com.beknur.domain.repository.CartRepository
import com.beknur.domain.repository.ProductRepository
import com.beknur.domain.util.Resource
import com.beknur.navigation.NavigationManager
import com.beknur.navigation.Screen
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.first

import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class CartViewModel(
	private val navigationManager: NavigationManager,
	private val cartRepository: CartRepository,
	private val productRepository: ProductRepository
) : ViewModel(
) {

	private val _viewState = MutableStateFlow(
		CartViewState(
			emptyList(),
			true,
			0,
			0,
			0,
			showBottomSheet = false
		)
	)
	val viewState = _viewState.asStateFlow()

	init {
		observeProducts()

	}

	private fun observeProducts() {

		viewModelScope.launch {
			cartRepository.getCartItems().collect { newProducts ->
				_viewState.update {
					val products = newProducts
					it.copy(
						products = newProducts,
						isAllSelected = products.all { it.isSelected },
						selectedCount = products.count { it.isSelected },
						amount = products.filter { it.isSelected }
							.sumOf { it.pricePerOne * it.count })
				}
			}
		}
	}

	fun handleEvent(event: CartUiEvent) {
		when (event) {
			CartUiEvent.OnPayButtonClick -> onPayButtonClick()
			CartUiEvent.OnSelectAllClick -> onSelectAllClick()
			CartUiEvent.OnTrashClick -> onTrashClick()
			is CartUiEvent.OnAddProduct -> onProductAdd(event.id)
			is CartUiEvent.OnDelProduct -> onProductDel(event.id,event.skuId)
			is CartUiEvent.OnSelectProductClick -> onSelectProductClick(event.id,event.skuId)
			CartUiEvent.OnDismissBottomSheet -> onDissmissBottomSheet()
			is CartUiEvent.OnSizeSelected -> onSizeSelect(event.id,event.skuId)
		}
	}

	private fun onDissmissBottomSheet() {
		_viewState.update {
			it.copy(showBottomSheet = false)
		}
	}

	private fun onPayButtonClick() {
		viewModelScope.launch {
			navigationManager.navigate(Screen.Payment)
		}
	}

	private fun onSelectAllClick() {
		viewModelScope.launch {
			cartRepository.selectAll()
		}

	}

	private fun onTrashClick() {
		viewModelScope.launch {
			cartRepository.deleteSelected()
		}
	}

	private fun onProductAdd(id: Int) {
		viewModelScope.launch {
			_viewState.update {
				it.copy(openedProductId = id, showBottomSheet = true,productVariants = Loadable.Loading)
			}
			delay(700)
			try {
				val result = cartRepository.getProductType(id)
				_viewState.update {
					it.copy(productVariants = Loadable.Success(result.variants))
				}
			} catch (e: Exception) {
				_viewState.update {
					it.copy(productVariants = Loadable.Error(e.message.toString()))
				}
			}
		}
	}

	private fun onProductDel(id: Int,skuId: Int) {
		viewModelScope.launch {
			cartRepository.decrementItem(id, skuId = skuId)
		}
	}

	private fun onSelectProductClick(id: Int,skuId: Int) {
		viewModelScope.launch {
			cartRepository.toggleSelect(id,skuId)
		}
	}
	private fun onSizeSelect(id: Int, skuId: Int){
		viewModelScope.launch {
			_viewState.update {
				it.copy(showBottomSheet = false, productVariants = Loadable.Idle)
			}
			val resource = productRepository.getProduct(id, skuId)
			when(resource) {
				is Resource.Error -> {}
				is Resource.Success<Product> -> {
					val cartProduct = resource.data
					cartRepository.insertOrAdd(cartProduct)
				}
			}


		}
	}


}