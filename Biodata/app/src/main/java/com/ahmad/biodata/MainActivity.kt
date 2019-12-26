package com.ahmad.biodata

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView.layoutManager = LinearLayoutManager(this)

        val person : ArrayList<ListPerson> = ArrayList()
        person.add(ListPerson("Ahmad Shofi","Teluk Sentosa,03 November 1999","Jl.Dipati Ukur No 98 P","Futsal"))
        person.add(ListPerson("Dilaumami","Sei Sentosa,02 Januari 2005","Jl.bahagia","Bermain"))

        recyclerView.adapter = MainAdapter(person,this)
    }
}
