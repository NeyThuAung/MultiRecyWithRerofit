package com.exam.multirecywithrerofit.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.exam.multirecywithrerofit.models.Category
import com.exam.multirecywithrerofit.models.MainCategory
import com.exam.multirecywithrerofit.repository.BuyerRepository
import kotlinx.coroutines.launch

class MainViewModel(private val buyerRepository: BuyerRepository) : ViewModel() {
    init {
        viewModelScope.launch {
            buyerRepository.getBuyers()
        }

    }
    val category : LiveData<Category>
        get() = buyerRepository.buyers
}