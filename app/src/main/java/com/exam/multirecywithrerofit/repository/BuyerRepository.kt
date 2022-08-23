package com.exam.multirecywithrerofit.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.exam.multirecywithrerofit.api.CategoryService
import com.exam.multirecywithrerofit.models.Category
import com.exam.multirecywithrerofit.models.CategoryV2
import com.exam.multirecywithrerofit.models.MainCategory
import com.exam.multirecywithrerofit.models.ProductBuyers

class BuyerRepository(private val categoryService: CategoryService) {
    private val buyersLiveData = MutableLiveData<Category>()
    val buyers: LiveData<Category>
        get() = buyersLiveData


    suspend fun getBuyers(){
        val result = categoryService.getBuyers()
        if (result.body() != null){
            buyersLiveData.postValue(result.body())
            Log.d("DATA", "getBuyers: ${result.body()}")
        }
    }

}