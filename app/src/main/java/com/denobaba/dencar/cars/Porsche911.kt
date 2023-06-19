package com.denobaba.dencar.cars

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.denobaba.dencar.R
import com.denobaba.dencar.databinding.ActivityFordmustangBinding
import com.denobaba.dencar.databinding.ActivityPorsche911Binding
import com.denobaba.dencar.purchase

class porsche911 : AppCompatActivity() {
    private lateinit var binding: ActivityPorsche911Binding
    var newPrice: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_porsche911)
        binding = ActivityPorsche911Binding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
    }
    fun button(view: View){
        val intent = Intent(this, purchase::class.java)
        intent.putExtra("price",newPrice.toString())
        startActivity(intent)
    }

    fun button2(view: View){
        val currentPrice = 200
        newPrice = binding.price.text.toString().toInt() + currentPrice
        binding.price.text = newPrice.toString()



        val firstday = 1
        val newday = binding.dayy.text.toString().toInt() + firstday
        binding.dayy.text = newday.toString()

        if (newday>7){
            val lastday = 7
            binding.dayy.text = lastday.toString()

            val lastprice = 1400
            binding.price.text = lastprice.toString()



        }



    }

    fun button3(view: View){
        val currentPrice = 200
        newPrice = binding.price.text.toString().toInt() - currentPrice
        binding.price.text = newPrice.toString()

        val firstday = 1
        val newday = binding.dayy.text.toString().toInt() - firstday
        binding.dayy.text = newday.toString()

        if (newday<1){
            binding.dayy.text = firstday.toString()

        }

        if (newPrice<200){
            binding.price.text = currentPrice.toString()

        }

    }
}
