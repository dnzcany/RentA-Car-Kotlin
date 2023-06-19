package com.denobaba.dencar

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.denobaba.dencar.R
import com.denobaba.dencar.databinding.ActivityMainBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var carslist :ArrayList<carsmodel>
    private lateinit var firestore: FirebaseFirestore
    private lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        firestore = Firebase.firestore
        auth = Firebase.auth
        carslist = ArrayList<carsmodel>()
        val car1 = carsmodel("Lamborghini Urus",2022,"$200 DAILY",R.drawable.aaaa)
        val car2 = carsmodel("Rolls-Royce Ghost",2020,"$250 DAILY",R.drawable.rrghstt)
        val car3 = carsmodel("Ferrari 458 ITALIA",2020,"$200 DAILY",R.drawable.frarri)
        val car4 = carsmodel("Porsche 911 Gt3 Rs",2022,"$200 DAILY",R.drawable.porsche911)
        val car5 = carsmodel("GMC Sierra Denali",2021,"$200 DAILY",R.drawable.gmcsierra)
        val car6 = carsmodel("Ford Mustang",2023,"$185 DAILY",R.drawable.fordmustang)

        carslist.add(car1)
        carslist.add(car2)
        carslist.add(car3)
        carslist.add(car4)
        carslist.add(car5)
        carslist.add(car6)


        binding.recycleviewhere.layoutManager= LinearLayoutManager(this)
        val recycleadapterr = recycleadapter(carslist)
        recycleadapterr.notifyDataSetChanged()


        binding.recycleviewhere.adapter= recycleadapterr

        getData()

        binding.logout.setOnClickListener {
            auth.signOut()
            val intent = Intent(this,Login::class.java)
            startActivity(intent)
            finish()

        }
    }

    fun getData(){
        firestore.collection("name").addSnapshotListener { value, error ->
            if(error !=null){
                Toast.makeText(this,error.localizedMessage, Toast.LENGTH_LONG).show()

            }else{
                if(value !=null){
                    if(!value.isEmpty){
                        val documents = value.documents
                        for (i in documents){
                            val name = i.get("name") as String
                            val email = i.get("email") as String
                            if(email== auth.currentUser?.email){
                                binding.yournamee.setText("Welcome $name")
                            }
                        }
                    }
                }
            }

        }





    }
}