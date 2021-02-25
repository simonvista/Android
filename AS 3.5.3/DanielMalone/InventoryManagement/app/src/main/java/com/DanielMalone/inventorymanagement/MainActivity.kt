package com.DanielMalone.inventorymanagement

import android.content.Intent
import android.os.Bundle
import android.util.Log.d
import androidx.appcompat.app.AppCompatActivity

import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*
import kotlin.math.round

class MainActivity : AppCompatActivity() {
    /*companion object{
        private const val minCost=40
        private const val maxCost=800
        private const val filterByName="Daniel"
    }*/
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        /*goToAddProduct.setOnClickListener {
            startActivity(Intent(this,AddProductActivity::class.java))
        }*/
        fab.setOnClickListener {
            startActivity(Intent(this,AddProductActivity::class.java))
        }
        btnUnder200.setOnClickListener {
            showInexpensive()
            /*val products=ProductData().allProducts()
            showProducts(products)*/
        }
        btnFilterByName.setOnClickListener {
            showDaniel()
        }

//        val products= listOf(1,2,10,400,23,42)
//        val products= listOf("Building","Car","Truck","Laptop")
        /*val products= listOf(
            Product("iPod","Daniel",2006,345.1),
            Product("Pixel","John Ddaniell",2009,23.54),
            Product("Mac","Nathan",2020,2000.41),
            Product("Monitor","Hannah",1999,232.12),
            Product("Kotlin","Mel",2005,00.00)
        )*/
        /*val products=ProductData().allProducts()
        showProducts(products)*/

        /*val preferences=getSharedPreferences("database", Context.MODE_PRIVATE)
        val savedName=preferences.getString("savedProductName","This value doesn't exist")
        d("hello","savedName is $savedName")
        tvPrevProduct.text=savedName*/

//        Background thread is running
        /*lifecycleScope.launch(Dispatchers.Default) {
            val specialMsg=URL("https://finepointmobile.com/api/inventory/v1/message").readText()
            d("Msg",specialMsg)
            runOnUiThread(java.lang.Runnable {
                tvPrevProduct.text=specialMsg
            })
        }*/
    }
    private fun showInexpensive(): Unit {
        val products=ProductData().allProducts().filter { 
            it.cost<200
        }
        showProducts(products)
    }
    private fun showDaniel(): Unit {
        val products=ProductData().allProducts().filter {
            it.owner.contains("Daniel",true)
        }
        showProducts(products)
    }

    private fun showProducts(products: List<Product>) {
        tvProduct.text=""
        var totalCost = 0.0
        products.forEach {
            d("list", "Product: $it")
            tvProduct.append("${it.name}, ${it.owner}, ${it.yearPurchased}, $${it.cost}\n\n")
            totalCost += it.cost
            totalCost= round(totalCost*100)/100
           /* if (it.owner.contains(AppConfig.filterByName, true)) {
    //            if(it.owner.contains(filterByName,true)){
    //            if(it.cost<maxCost && it.cost> minCost){
                tvProduct.append("${it.name}, ${it.owner}, ${it.yearPurchased}, $${it.cost}\n\n")
                totalCost += it.cost
                totalCost= round(totalCost*100)/100
            }*/
        }
        d("totalCost", "Total cost: $totalCost")
        tvTotalCost.text = "Total Cost: $$totalCost"
    }

}