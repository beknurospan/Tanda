package com.beknur.product

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.beknur.domain.model.FilterAttribute
import com.beknur.domain.model.FilterParams
import com.beknur.domain.model.PriceRange
import com.beknur.domain.repository.ProductRepository
import com.beknur.domain.util.Loadable
import com.beknur.domain.util.Loadable.*
import com.beknur.domain.util.Resource
import com.beknur.navigation.NavigationManager
import com.beknur.navigation.Screen
import kotlinx.collections.immutable.PersistentMap
import kotlinx.collections.immutable.PersistentSet
import kotlinx.collections.immutable.intersect
import kotlinx.collections.immutable.persistentSetOf
import kotlinx.collections.immutable.toPersistentMap
import kotlinx.collections.immutable.toPersistentSet
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class ProductViewModel(
	private val navigationManager: NavigationManager,
	private val productRepository: ProductRepository
) : ViewModel() {


	private val _viewState = MutableStateFlow<ProductViewState>(
		ProductViewState(
			products = emptyList(),
			showBottomSheet = false,
			filterParams = Loadable.Idle,
			selectedFilters = SelectedFilters(),
			showSortDialog = false
		)
	)
	val viewState = _viewState.asStateFlow()

	init {
		viewModelScope.launch {
			val products = productRepository.getProductsByCategory("Кроссовки")
			_viewState.update { it.copy(products = products) }
		}
	}

	fun handleEvent(event: ProductUiEvent) {
		when (event) {
			is ProductUiEvent.OnProductSelected -> onProductSelected(
				product = event.productId,
				skuId = event.skuId
			)

			ProductUiEvent.OnFilterClicked -> onFilterClicked()
			ProductUiEvent.OnSortClicked -> onSortClicked()
			is ProductUiEvent.OnParameterClicked -> onParameterClicked(
				event.attributeId,
				event.paramId
			)

			ProductUiEvent.OnDissmiss -> onDissmiss()
		}
	}


	fun onSortClicked() {
		viewModelScope.launch {
			_viewState.update { it.copy(showSortDialog = true) }
		}
	}

	fun onParameterClicked(attributeId: Int, paramId: Int) {
		_viewState.update { state ->
			val currentSet = state.selectedFilters.selectedParams[attributeId] ?: persistentSetOf()
			val newSet = if (paramId in currentSet) {
				currentSet.remove(paramId)
			} else {
				currentSet.add(paramId)
			}

			state.copy(
				selectedFilters = state.selectedFilters.copy(
					selectedParams = state.selectedFilters.selectedParams.put(attributeId, newSet)
				)
			)

		}
		syncDataWithBack(_viewState.value.selectedFilters)

	}

	fun syncDataWithBack(selectedFilters: SelectedFilters) {
		viewModelScope.launch {
			val result = productRepository.getFiltersForCategory("Кроссовкима")

			when (result) {
				is Resource.Error -> {
					Log.d("msfa", "ERROR ${result.throwable.message}")
				}

				is Resource.Success<FilterParams> -> {

					val newFilterParams = result.data

					val allAvailableParams: Map<Int, Set<Int>> = buildMap {
						put(
							result.data.sizeAttribute.id,
							result.data.sizeAttribute.params.map { it.id }.toSet()
						)
						put(
							result.data.brandAttribute.id,
							result.data.brandAttribute.params.map { it.id }.toSet()
						)
						result.data.filterAttributes.forEach { attr ->
							put(attr.id, attr.params.map { it.id }.toSet())
						}
					}

					_viewState.update { state ->
						val cleanedSelectedParams = state.selectedFilters.selectedParams
							.mapNotNull { (attributeId, selectedSet) ->
								val allowedSet = allAvailableParams[attributeId].orEmpty()
								val intersected = selectedSet.intersect(allowedSet)
								if (intersected.isEmpty()) null
								else attributeId to intersected.toPersistentSet()
							}
							.toMap()
							.toPersistentMap()

						state.copy(
							filterParams = Success(newFilterParams),
							selectedFilters = state.selectedFilters.copy(
								selectedParams = cleanedSelectedParams
							)
						)
					}
				}
			}
		}
	}


	fun onProductSelected(product: Int, skuId: Int) {
		viewModelScope.launch {
			navigationManager.navigate(Screen.ProductDetail(product, skuId))
		}
	}

	fun onFilterClicked() {
		viewModelScope.launch {
			_viewState.update {
				it.copy(
					filterParams = Loadable.Loading,
					showBottomSheet = true
				)
			}
			val result = productRepository.getFiltersForCategory("Кроссовки")

			when (result) {
				is Resource.Success -> _viewState.update {

					val params = result.data

					it.copy(
						filterParams = Success(params),
						showBottomSheet = true
					)
				}

				is Resource.Error -> _viewState.update {
					it.copy(
						filterParams = Error(result.throwable),
						showBottomSheet = true
					)
				}


			}
		}
	}


	fun onDissmiss() {
		_viewState.update { it.copy(showBottomSheet = false) }
	}
}

