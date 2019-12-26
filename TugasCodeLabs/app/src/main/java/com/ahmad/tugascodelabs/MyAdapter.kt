package com.ahmad.tugascodelabs

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.ahmad.tugascodelabs.Model.Data
import com.bumptech.glide.Glide
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_view.view.*

class MyAdapter (private val dataList:MutableList<Data>):RecyclerView.Adapter<MyHolder>() {
    private lateinit var context: Context


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        context = parent.context
        return MyHolder(LayoutInflater.from(context).inflate(R.layout.item_view,parent,false))
    }

    override fun getItemCount(): Int = dataList.size

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        val data  = dataList[position]

        val name = holder.itemView.txt_hero
        val img = holder.itemView.hero_image

        val fullname = "${data.name}"
        name.text = fullname

        Picasso.get()
            .load(data.imageurl)
            .into(img)

        holder.itemView.setOnClickListener {
            Toast.makeText(context,fullname,Toast.LENGTH_SHORT).show()
        }

    }
}