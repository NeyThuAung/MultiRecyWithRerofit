package com.exam.multirecywithrerofit.adapter

import android.content.Context
import android.net.Uri
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import coil.load
import coil.transform.CircleCropTransformation
import com.exam.multirecywithrerofit.databinding.ChildItemBinding
import com.exam.multirecywithrerofit.databinding.ListItemBinding
import com.exam.multirecywithrerofit.models.MainCategory


class BuyerAdapter(
    val buyerList: List<MainCategory>) : RecyclerView.Adapter<BuyerAdapter.buyerHolder>() {
        private lateinit var productAdapter: ProductAdapter
        inner class buyerHolder(private val binding: ListItemBinding) : RecyclerView.ViewHolder(binding.root){
            fun bind(buyerList : MainCategory){
                binding.ivBuyer.load(
                    Uri.parse(buyerList.url)
                ){
                    crossfade(1000)
                    crossfade(true)
                    transformations(CircleCropTransformation())
                }
                binding.tvBuyerName.text=buyerList.name

                productAdapter = ProductAdapter(buyerList.productListBuyers)
                binding.recChild.setHasFixedSize(true)
                binding.recChild.layoutManager=LinearLayoutManager(itemView.context,LinearLayoutManager.HORIZONTAL,false)
                binding.recChild.adapter=productAdapter
            }
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): buyerHolder {
        return buyerHolder(
            ListItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        )
    }

    override fun onBindViewHolder(holder: buyerHolder, position: Int) {
            holder.bind(buyerList[position])
    }

    override fun getItemCount(): Int {
        return buyerList.size
    }



}