package com.beknur.cart

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.beknur.cart.data.ProductItem
import com.beknur.domain.model.CartProduct
import com.beknur.domain.repository.CartRepository
import com.beknur.navigation.NavigationManager
import com.beknur.navigation.Screen
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class CartViewModel(
	private val navigationManager: NavigationManager,
	private val cartRepository: CartRepository
) : ViewModel(
) {

	private val _viewState = MutableStateFlow(
		CartViewState(emptyList(), true, 0, 0)
	)
	val viewState = _viewState.asStateFlow()

	init {
		observeProducts()
	}

	private fun observeProducts() {
		viewModelScope.launch {
			cartRepository.getCartItems().collect { newProducts->
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
			is CartUiEvent.OnDelProduct -> onProductDel(event.id)
			is CartUiEvent.OnSelectProductClick -> onSelectProductClick(event.id)
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
			cartRepository.incrementItem(id)
		}
	}

	private fun onProductDel(id: Int) {
		viewModelScope.launch {
			cartRepository.decrementItem(id)
		}
	}

	private fun onSelectProductClick(id: Int) {
		viewModelScope.launch {
			cartRepository.toggleSelect(id)
		}
	}


}