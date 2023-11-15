package com.example.tugasretrofir

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tugasretrofir.databinding.ActivityMainBinding
import com.example.tugasretrofir.model.WeaponData
import com.example.tugasretrofir.retrofit.ApiClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        val client = ApiClient.getInstance("https://mhw-db.com")
        val response = client.getAllData()
        response.enqueue(object : Callback<List<WeaponData>>{
            override fun onResponse(
                call: Call<List<WeaponData>>,
                response: Response<List<WeaponData>>
            ) {
                val listWeaponId = arrayListOf<Int>()
                val listWeaponName = arrayListOf<String>()
                val listWeaponType = arrayListOf<String>()
                val listWeapon : List<WeaponData> = response.body()!!
                for (weapon in listWeapon){
                    listWeaponName.add(weapon.name)
                    listWeaponId.add(weapon.id)
                    listWeaponType.add(weapon.type)
                }

                binding.mainRv.apply {
                    adapter = WeaponAdapter(listWeapon)
                    layoutManager = LinearLayoutManager(this@MainActivity)
                }
            }


            override fun onFailure(call: Call<List<WeaponData>>, t: Throwable) {
                Toast.makeText(this@MainActivity, "Failed to connect to API", Toast.LENGTH_SHORT).show()
                Log.d("throwable", t.toString())
            }

        })

    }
}