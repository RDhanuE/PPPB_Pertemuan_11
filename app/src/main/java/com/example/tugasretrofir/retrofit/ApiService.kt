package com.example.tugasretrofir.retrofit

import com.example.tugasretrofir.model.WeaponData
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import java.util.Objects

interface ApiService {
    @GET("weapons")
    fun getAllData():Call<List<WeaponData>>

}