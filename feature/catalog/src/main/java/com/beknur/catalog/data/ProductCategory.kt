package com.beknur.catalog.data

import androidx.compose.ui.res.stringResource
import com.beknur.catalog.R




data class ProductCategory(
	val name:String,
	val gender:String,
	val img:String
)



object OptionsInfo{
	val options=listOf(
		0 to R.string.feature_catalog_option_men,
		1 to R.string.feature_catalog_option_woman,
		2 to R.string.feature_catalog_option_kids
	)

}

object ProductCategoryInfo{


	val categoriesMen= listOf(
		ProductCategory("товар 1","men",""),
		ProductCategory("товар 2","men",""),
		ProductCategory("товар 3","men",""),
		ProductCategory("товар 4","men",""),
		ProductCategory("товар 5","men",""),
		ProductCategory("товар 6","men",""),
		ProductCategory("товар 7","men",""),



	)

}