package com.ahmad.timber

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.LifecycleObserver

class MainActivity : AppCompatActivity(), LifecycleObserver {

    private var revenue = 0
    private var dessertsSold = 0

    //Contains all the views
    private lateinit var binding: ActivityMainBinding

    data class Dessert(val imageId:Int, val price: Int)

    //Create a list of all desserts, in order of when they start
    private val allDesserts = listOf()
    private var currentDessert = allDesserts[0]

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.i("MainActivity","onCreate Called")
        //setContentView(R.layout.activity_main)
        binding = DataBinding
    }
}
