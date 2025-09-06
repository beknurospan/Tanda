package com.beknur.product

import com.beknur.domain.model.FilterParams
import com.beknur.domain.model.PriceRange
import com.beknur.domain.model.Product
import com.beknur.domain.model.ProductCategory
import com.beknur.domain.util.Loadable
import kotlinx.collections.immutable.PersistentMap
import kotlinx.collections.immutable.PersistentSet
import kotlinx.collections.immutable.persistentMapOf

data class ProductViewState(
	val products: List<ProductCategory> = emptyList(),
	val filterParams: Loadable<FilterParams> = Loadable.Idle,
	val selectedFilters: SelectedFilters = SelectedFilters(),
	val showBottomSheet: Boolean,
	val showSortDialog: Boolean
)

data class SelectedFilters(
	val selectedParams: PersistentMap<Int, PersistentSet<Int>> = persistentMapOf(),
	val priceRange: PriceRange? = null,
)


