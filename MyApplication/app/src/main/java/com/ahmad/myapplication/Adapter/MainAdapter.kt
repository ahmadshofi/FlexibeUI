package com.ahmad.myapplication.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ahmad.myapplication.Model.DataX
import com.ahmad.myapplication.R
import com.bumptech.glide.Glide

class MainAdapter(internal var items : ArrayList<DataX>,internal var context: Context): RecyclerView.Adapter<ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder
    = ViewHolder(LayoutInflater.from(context).inflate(R.layout.list_hero,parent,false))

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items.get(position)
        Glide.with(context).load(items[position].imageurl).into(holder.img)

    }
}

class ViewHolder(view:View):RecyclerView.ViewHolder(view){
    val img : ImageView = view.findViewById(R.id.image_hero)
    val tvName : TextView = view.findViewById(R.id.hero_name)
}