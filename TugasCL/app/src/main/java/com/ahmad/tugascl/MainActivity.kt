package com.ahmad.tugascl

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView
import com.ahmad.tugascl.Model.Hero
import com.bumptech.glide.Glide
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    private lateinit var heroAdapter : HeroAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        heroAdapter = HeroAdapter()
        hero_list.addItemDecoration(DividerItemDecoration(this,DividerItemDecoration.VERTICAL))
        hero_list.adapter = heroAdapter

        val retrofit : Retrofit = Retrofit.Builder()
            .baseUrl("https://raw.githubusercontent.com")
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()

        val apiHero = retrofit.create(ApiHero::class.java)
        apiHero.getHeros()
            .subscribeOn(Schedulers.io())
            .unsubscribeOn(Schedulers.computation())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({heroAdapter.setHero(it.data)},
                {
                    Toast.makeText(applicationContext,it.message,Toast.LENGTH_SHORT).show()
                })
    }

    inner class HeroAdapter : RecyclerView.Adapter<HeroAdapter.MyViewHolder>() {

        private val hero: MutableList<Hero> = mutableListOf()

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
            return MyViewHolder(layoutInflater.inflate(R.layout.item_hero_layout, parent, false))
        }

        override fun getItemCount(): Int {
            return hero.size
        }

        override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

            val item = hero.get(position)

            Glide.with(baseContext).load(hero[position].imageurl).into(holder.img_hero)
            holder.txt_hero.text = hero[position].name

            holder.rootview.setOnClickListener {
                val intent = Intent(this@MainActivity,DetailActivity::class.java)
//                intent.putExtra("data",item)
                startActivity(intent)
            }

//            holder.setItemClickListener(object :IItemClickListener{
//                override fun onClick(view: View, position: Int) {
//                    Toast.makeText(baseContext,"Clicked at Hero : "+hero[position].name,Toast.LENGTH_SHORT).show()
//
//                }
//
//            })
        }

        fun setHero(data: List<Hero>) {
            hero.addAll(data)
            notifyDataSetChanged()
        }

        inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

            internal var img_hero:ImageView
            internal var txt_hero:TextView
            internal var rootview:ConstraintLayout
            internal var itemClickListener:IItemClickListener?=null

            fun setItemClickListener(iItemClickListener : IItemClickListener){
                this.itemClickListener = iItemClickListener
            }

            init {
                 img_hero = itemView.findViewById(R.id.hero_image) as ImageView
                txt_hero = itemView.findViewById(R.id.hero_name) as TextView
                rootview = itemView.findViewById(R.id.parent) as ConstraintLayout

                itemView.setOnClickListener { view -> itemClickListener!!.onClick(view,adapterPosition) }
            }
        }
    }
}
