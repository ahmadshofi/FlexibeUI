package com.ahmad.biodata

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView

class MainAdapter (val persons : ArrayList<ListPerson>, val context:Context):
    RecyclerView.Adapter<ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder
        = ViewHolder(LayoutInflater.from(context).inflate(R.layout.list_person,parent,false))

    override fun getItemCount(): Int = persons.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val person = persons.get(position)
        holder.tvNama.text = person.nama
        holder.tvAlamat.text = person.alamat
        holder.rootView.setOnClickListener {
            val intent = Intent(this.context,DetailActivity::class.java)
            intent.putExtra("data",person)
            context.startActivity(intent)
        }
    }
}

class ViewHolder(view: View):RecyclerView.ViewHolder(view){
    val tvNama : TextView = view.findViewById(R.id.tvNama)
    val tvAlamat : TextView = view.findViewById(R.id.tvAlamat)
    val rootView : ConstraintLayout = view.findViewById(R.id.parent)
}