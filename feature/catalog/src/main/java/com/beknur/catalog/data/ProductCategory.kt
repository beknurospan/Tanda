package com.beknur.catalog.data

enum class Gender(val code:String) {
	MEN("men"),
	WOMEN("woman"),
	KIDS("kids"),
}

data class ProductCategory(
	val name:String,
	val gender:Gender,
	val img:String
)


object ProductCategoryInfo{
	val categoriesMen= listOf(
		ProductCategory("товар 1",Gender.MEN,""),
		ProductCategory("товар 2",Gender.MEN,""),
		ProductCategory("товар 3",Gender.MEN,""),
		ProductCategory("товар 4",Gender.MEN,""),
		ProductCategory("товар 5",Gender.MEN,""),
		ProductCategory("товар 6",Gender.MEN,""),
		ProductCategory("товар 7",Gender.MEN,""),



	)

}