package com.exam.multirecywithrerofit.models

data class MainCategory(
    val id: Int,
    val mainCategoryId: Int,
    val name: String,
    val productListBuyers: List<ProductBuyers>,
    val url: String
)