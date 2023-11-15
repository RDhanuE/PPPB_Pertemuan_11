package com.example.tugasretrofir

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.tugasretrofir.databinding.ItemWeaponBinding
import com.example.tugasretrofir.model.WeaponData

class WeaponAdapter (private val listWeapon: List<WeaponData>) : RecyclerView.Adapter<WeaponAdapter.ItemWeaponDataHolder>() {

    inner class ItemWeaponDataHolder (private val binding: ItemWeaponBinding) : RecyclerView.ViewHolder(binding.root){

        fun bind (data: WeaponData){
            with(binding){
                weaponId.text = data.id.toString()
                weaponName.text =  data.name
                weaponType.text = data.type
                Glide.with(itemView.context).load(data.asset.image).into(weaponImg)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemWeaponDataHolder {
        val binding = ItemWeaponBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ItemWeaponDataHolder(binding)
    }

    override fun getItemCount(): Int {
        return listWeapon.size
    }

    override fun onBindViewHolder(holder: ItemWeaponDataHolder, position: Int) {
        holder.bind(listWeapon[position])
    }

}