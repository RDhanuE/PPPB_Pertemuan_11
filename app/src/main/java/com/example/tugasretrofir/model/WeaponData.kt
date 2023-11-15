package com.example.tugasretrofir.model

import com.google.gson.annotations.SerializedName

data class WeaponData(
    @SerializedName("id")
    var  id: Int,

    @SerializedName("name")
    var name: String,

    @SerializedName("type")
    var type: String,

    @SerializedName("assets")
    var asset: WeaponDataAsset
)

data class WeaponDataAsset(
    @SerializedName("image")
    var image: String
)
