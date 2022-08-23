package com.exam.multirecywithrerofit.api

import com.exam.multirecywithrerofit.models.Category
import com.exam.multirecywithrerofit.models.MainCategory
import com.exam.multirecywithrerofit.models.ProductBuyers
import retrofit2.Response
import retrofit2.http.GET

interface CategoryService {

    @GET("multirec")
    suspend fun getBuyers() : Response<Category>


}