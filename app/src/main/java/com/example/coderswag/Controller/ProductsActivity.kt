package com.example.coderswag.Controller

import android.content.Intent
import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.GridLayout
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.coderswag.Adapters.ProductRecyclerAdapter
import com.example.coderswag.R
import com.example.coderswag.Services.DataService
import com.example.coderswag.Utilities.EXTRA_CATAGORY
import com.example.coderswag.Utilities.EXTRA_PRODUCT_DETAIL

class ProductsActivity : AppCompatActivity() {

    lateinit var adapter : ProductRecyclerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_products)

        val productRecycle = findViewById<RecyclerView>(R.id.product_recyclerview)

        val categoryType = intent.getStringExtra(EXTRA_CATAGORY)

        adapter = ProductRecyclerAdapter(this, DataService.getProducts(categoryType.toString())) { product ->
            val detailIntent = Intent(this, ProductDetailActivity::class.java)
            detailIntent.putExtra(EXTRA_PRODUCT_DETAIL, product.id)
            detailIntent.putExtra(EXTRA_CATAGORY, categoryType)
            startActivity(detailIntent)
        }

        var spanCount = 2
        val orientation = resources.configuration.orientation
        val screenSize = resources.configuration.screenWidthDp
        if (orientation == Configuration.ORIENTATION_LANDSCAPE || screenSize > 720){
            spanCount = 3
        }

        val layoutManager = GridLayoutManager(this, spanCount)
        productRecycle.adapter = adapter
        productRecycle.layoutManager=layoutManager
    }
}