package com.ahmad.pabcl

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

       val item = intent.getParcelableExtra<ListItem>("data")
        if (item != null)
        {
            judul.text = item.judul
            desc.text = item.desc

            supportActionBar!!.title = item.judul
            supportActionBar!!.setDisplayShowHomeEnabled(true)
            supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        }else
        {
            finish()
        }


    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }
}
