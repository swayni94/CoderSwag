package com.example.coderswag.Adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.coderswag.Model.Product
import com.example.coderswag.R

class ProductRecyclerAdapter( val context: Context, val products: List<Product>, val itemClick: (Product) -> Unit) : RecyclerView.Adapter<ProductRecyclerAdapter.ProductHolder>() {

    inner class ProductHolder(itemView: View, itemClick: (Product) -> Unit) : RecyclerView.ViewHolder(itemView) {
        val productImage = itemView.findViewById<ImageView>(R.id.product_image)
        val productTitle = itemView.findViewById<TextView>(R.id.product_name)
        val productPrice = itemView.findViewById<TextView>(R.id.product_price)

        fun bindProduct(product: Product, context: Context){
            val resourceId = context.resources.getIdentifier(product.image, "mipmap", context.packageName)
            productImage.setImageResource(resourceId)
            productTitle.text = product.title
            productPrice.text = product.price
            itemView.setOnClickListener { itemClick(product) }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductHolder {
        return ProductHolder(LayoutInflater.from(context).inflate(R.layout.product_list_item, parent, false),itemClick)
    }

    override fun onBindViewHolder(holder: ProductHolder, position: Int) {
        holder.bindProduct(products[position], context)
    }

    override fun getItemCount(): Int {
        return products.size
    }
}