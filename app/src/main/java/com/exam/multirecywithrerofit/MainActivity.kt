package com.exam.multirecywithrerofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.exam.multirecywithrerofit.adapter.BuyerAdapter
import com.exam.multirecywithrerofit.api.CategoryService
import com.exam.multirecywithrerofit.api.RetrofitHelper
import com.exam.multirecywithrerofit.databinding.ActivityMainBinding
import com.exam.multirecywithrerofit.repository.BuyerRepository
import com.exam.multirecywithrerofit.viewmodels.MainViewModel
import com.exam.multirecywithrerofit.viewmodels.ViewModelFactory

class MainActivity : AppCompatActivity() {
    lateinit var mainViewModel: MainViewModel
    private lateinit var buyerAdapter: BuyerAdapter
    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //setContentView(R.layout.activity_main)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val categoryService = RetrofitHelper.getInstance().create(CategoryService::class.java)

        val buyerRepository = BuyerRepository(categoryService)

        mainViewModel= ViewModelProvider(this, ViewModelFactory(buyerRepository)).get(MainViewModel::class.java)

        mainViewModel.category.observe(this){
            Log.d("NEYTHUAUNG",it.mainCategory.toString())
            buyerAdapter = BuyerAdapter(it.mainCategory)
            binding.mainRec.also {
                it.setHasFixedSize(true)

                it.layoutManager= LinearLayoutManager(this@MainActivity)
                it.adapter = buyerAdapter
            }
        }



    }
}