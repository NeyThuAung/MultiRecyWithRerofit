package com.exam.multirecywithrerofit.adapter

import android.content.Context
import android.net.Uri
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import coil.transform.CircleCropTransformation
import com.exam.multirecywithrerofit.databinding.ChildItemBinding
import com.exam.multirecywithrerofit.models.MainCategory
import com.exam.multirecywithrerofit.models.ProductBuyers

class ProductAdapter( val productList: List<ProductBuyers>) : RecyclerView.Adapter<ProductAdapter.productHolder>() {
    inner class productHolder(private val binding: ChildItemBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(productList : ProductBuyers){
            binding.ivProduct.load(
                Uri.parse(productList.url)
            ){
                crossfade(1000)
                crossfade(true)
                transformations(CircleCropTransformation())
            }
            binding.tvItemName.text= productList.name
            binding.tvPrice.text=productList.originalPrice.toString()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): productHolder {
        return productHolder(
            ChildItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        )
    }

    override fun onBindViewHolder(holder: productHolder, position: Int) {
        holder.bind(productList[position])
    }

    override fun getItemCount(): Int {
        return productList.size
    }


}