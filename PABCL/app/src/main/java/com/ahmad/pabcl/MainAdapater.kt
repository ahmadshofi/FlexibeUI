package com.ahmad.pabcl

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView

class MainAdapater (val items : ArrayList<ListItem>, val context: Context):RecyclerView.Adapter<ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder
            = ViewHolder(LayoutInflater.from(context).inflate(R.layout.list_item,parent,false))

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items.get(position)
        holder.tvJudul.text = item.judul
        holder.tvDesc.text = item.desc
        holder.rootView.setOnClickListener {
            val intent = Intent(this.context,DetailActivity::class.java)
            intent.putExtra("data",item)
            context.startActivity(intent)


        }

    }


}


class ViewHolder (view: View):RecyclerView.ViewHolder(view){
    val tvJudul :TextView = view.findViewById(R.id.judul)
    val tvDesc : TextView = view.findViewById(R.id.des)
    val rootView : ConstraintLayout = view.findViewById(R.id.parent)

}