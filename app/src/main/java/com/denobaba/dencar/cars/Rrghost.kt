package com.denobaba.dencar.cars

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.denobaba.dencar.R
import com.denobaba.dencar.databinding.ActivityFordmustangBinding
import com.denobaba.dencar.databinding.ActivityRrghostBinding
import com.denobaba.dencar.purchase

class rrghost : AppCompatActivity() {
    private lateinit var binding: ActivityRrghostBinding
    var newPrice: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_rrghost)
        binding = ActivityRrghostBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
    }

    fun button(view: View){
        val intent = Intent(this, purchase::class.java)
        intent.putExtra("price",newPrice.toString())
        startActivity(intent)
    }

    fun button2(view: View){
        val currentPrice = 260
        newPrice = binding.price.text.toString().toInt() + currentPrice
        binding.price.text = newPrice.toString()



        val firstday = 1
        val newday = binding.dayy.text.toString().toInt() + firstday
        binding.dayy.text = newday.toString()

        if (newday>7){
            val lastday = 7
            binding.dayy.text = lastday.toString()

            val lastprice = 1820
            binding.price.text = lastprice.toString()



        }



    }

    fun button3(view: View){
        val currentPrice = 260
        newPrice = binding.price.text.toString().toInt() - currentPrice
        binding.price.text = newPrice.toString()

        val firstday = 1
        val newday = binding.dayy.text.toString().toInt() - firstday
        binding.dayy.text = newday.toString()

        if (newday<1){
            binding.dayy.text = firstday.toString()

        }

        if (newPrice<185){
            binding.price.text = currentPrice.toString()

        }

    }
}
