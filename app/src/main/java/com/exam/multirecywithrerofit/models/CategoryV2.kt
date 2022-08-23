package com.exam.multirecywithrerofit.models

data class CategoryV2(
    val mainCategory : ArrayList<MainCategoryV2>,
){
    data class MainCategoryV2(
        val productListBuyers : ArrayList<ProductList>
    ){
        data class ProductList(
            val productId: Int,
            val productTypeId: Int,
            val url: String,
            val name: String,
            val originalPrice: Int
        )
    }
}
