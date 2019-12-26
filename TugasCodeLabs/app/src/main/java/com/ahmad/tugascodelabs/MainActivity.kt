package com.ahmad.tugascodelabs

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.OrientationHelper
import com.ahmad.tugascodelabs.Model.Data
import com.ahmad.tugascodelabs.Model.Hero
import com.androidnetworking.AndroidNetworking
import com.androidnetworking.error.ANError
import com.androidnetworking.interfaces.ParsedRequestListener
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val dataList:MutableList<Data> = mutableListOf()
    private lateinit var myAdapter: MyAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //setup adapter
        myAdapter = MyAdapter(dataList)

        //recycler_view
        my_recycler_view.layoutManager = LinearLayoutManager(this)
        my_recycler_view.addItemDecoration(DividerItemDecoration(this,OrientationHelper.VERTICAL))
        my_recycler_view.adapter = myAdapter


        //Setup Networking
        AndroidNetworking.initialize(this)

        AndroidNetworking.get("https://raw.githubusercontent.com/radhikayusuf/static-api/master/superheroes.json")
            .build()
            .getAsObject(Hero::class.java, object :ParsedRequestListener<Hero>{
                override fun onResponse(response: Hero?) {
                    dataList.addAll(response!!.data)
                    myAdapter.notifyDataSetChanged()
                }

                override fun onError(anError: ANError?) {

                }

            })
    }
}
