package com.beknur.catalog

import com.beknur.catalog.data.ProductCategory

data class CatalogViewState(
	val categories:List<ProductCategory>,
	val selectedIndex:Int
)
