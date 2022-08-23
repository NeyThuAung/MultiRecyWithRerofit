package com.exam.multirecywithrerofit.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.exam.multirecywithrerofit.repository.BuyerRepository

class ViewModelFactory(private val buyerRepository: BuyerRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainViewModel(buyerRepository) as T
    }
}