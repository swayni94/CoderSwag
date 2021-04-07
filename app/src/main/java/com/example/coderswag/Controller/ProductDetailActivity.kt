package com.example.coderswag.Controller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.example.coderswag.R
import com.example.coderswag.Services.DataService
import com.example.coderswag.Utilities.EXTRA_CATAGORY
import com.example.coderswag.Utilities.EXTRA_PRODUCT_DETAIL

class ProductDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_detail)

        val id = intent.getIntExtra(EXTRA_PRODUCT_DETAIL,0)
        val categoryType = intent.getStringExtra(EXTRA_CATAGORY)

        val product = DataService.getProductDetail(id, categoryType.toString())

        val image:ImageView = findViewById(R.id.detail_imageview)
        val resourceId = resources.getIdentifier(product.image, "mipmap", packageName)
        image.setImageResource(resourceId)

        val title:TextView = findViewById(R.id.detail_title)
        title.text = product.title

        val price:TextView = findViewById(R.id.detail_price)
        price.text = product.price

        val description:TextView = findViewById(R.id.detail_description)
        description.text = product.descreption
    }
}