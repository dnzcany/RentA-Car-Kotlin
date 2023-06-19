package com.denobaba.dencar

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.denobaba.dencar.cars.*
import com.denobaba.dencar.databinding.RecycleRowBinding

class recycleadapter(val carslist: ArrayList<carsmodel>) : RecyclerView.Adapter<recycleadapter.carsholder>() {

    class carsholder(val binding: RecycleRowBinding) : RecyclerView.ViewHolder(binding.root){


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): carsholder {
        val binding = RecycleRowBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return carsholder(binding)
    }

    override fun getItemCount(): Int {
        return carslist.size

    }

    override fun onBindViewHolder(holder: carsholder, position: Int) {
        holder.binding.carname.text = carslist.get(position).carname
        holder.binding.caryear.text = carslist.get(position).caryear.toString()
        holder.binding.carprice.text = carslist.get(position).carprice
        holder.binding.carimage.setImageResource(carslist[position].carimage)

        holder.itemView.setOnClickListener {
            val context = holder.itemView.context
            val intent: Intent

            when(carslist[position].carname) {
                "Ferrari 458 ITALIA" -> intent = Intent(context, ferrari458::class.java)
                "Ford Mustang" -> intent = Intent(context, fordmustang::class.java)
                "Rolls-Royce Ghost" -> intent = Intent(context, rrghost::class.java)
                "Porsche 911 Gt3 Rs" -> intent = Intent(context, porsche911::class.java)
                "GMC Sierra Denali" -> intent = Intent(context, gmcsierra::class.java)
                "Lamborghini Urus" -> intent = Intent(context, lambo::class.java)
                else -> intent = Intent(context, MainActivity::class.java)
            }

            intent.apply {
                putExtra("carName", carslist[position].carname)
                putExtra("carYear", carslist[position].caryear)
                putExtra("carPrice", carslist[position].carprice)

            }

            context.startActivity(intent)
        }

    }


    }


