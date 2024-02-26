package com.example.lessonsapp

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.lessonsapp.databinding.ItListBinding

class MyRecyclerAdapter(private val context: Context, private val list: List<Contact>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var itemClickListener: ((Contact) -> Unit)? = null

    fun setItemClickListener(listener: (Contact) -> Unit) {
        itemClickListener = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val binding = ItListBinding.inflate(LayoutInflater.from(context), parent, false)
        return ItemViewHolder(binding)
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as ItemViewHolder).bind(position)
    }

    inner class ItemViewHolder(private val binding: ItListBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(position: Int) {
            val item = list[position]

            binding.apply {
                tvName.text = item.name
                tvEmail.text = item.email
                tvPhone.text = item.phoneNumber
            }

            itemView.setOnClickListener {
                itemClickListener?.invoke(item)
            }
        }
    }
}