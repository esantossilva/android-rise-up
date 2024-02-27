package com.example.lessonsapp

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Toast
import com.example.lessonsapp.databinding.ItListBinding

class MyListAdapter(context: Context, private val list: List<Contact>) :
    ArrayAdapter<Contact>(context, R.layout.it_list, list) {

    @SuppressLint("ViewHolder")
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val binding = ItListBinding.inflate(LayoutInflater.from(context), parent, false)

        val item = list[position]
        binding.apply {
            tvName.text = item.name
            tvEmail.text = item.email
            tvPhone.text = item.phoneNumber

            // Adiciona um click aos itens da lista
            clItemList.setOnClickListener {
                showMessage("email = ${item.email}\nphone = ${item.phoneNumber}")
            }
        }

        return binding.root
    }

    private fun showMessage(message: String) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }
}