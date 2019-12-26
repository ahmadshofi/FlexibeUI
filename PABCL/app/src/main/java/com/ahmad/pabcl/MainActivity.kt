package com.ahmad.pabcl

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView.layoutManager = LinearLayoutManager(this)

        val items : ArrayList<ListItem> = ArrayList()
        items.add(ListItem("Perempuan Tanah Jahanam", "Ini sebuah deskripsi film horor yang disutradari oleh joko anwar"))
        items.add(ListItem("Joker", "Ini sebuah deskripsi film tentang orang baik yang tersakiti"))
        items.add(ListItem("Upin Ipin", "Ini sebuah deskripsi film malaysia tentang anak kecil kembar"))
        items.add(ListItem("Upin Ipin", "Ini sebuah deskripsi film malaysia tentang anak kecil kembar"))
        items.add(ListItem("Upin Ipin", "Ini sebuah deskripsi film malaysia tentang anak kecil kembar"))
        items.add(ListItem("Upin Ipin", "Ini sebuah deskripsi film malaysia tentang anak kecil kembar"))
        items.add(ListItem("Upin Ipin", "Ini sebuah deskripsi film malaysia tentang anak kecil kembar"))
        items.add(ListItem("Upin Ipin", "Ini sebuah deskripsi film malaysia tentang anak kecil kembar"))
        items.add(ListItem("Upin Ipin", "Ini sebuah deskripsi film malaysia tentang anak kecil kembar"))
        items.add(ListItem("Upin Ipin", "Ini sebuah deskripsi film malaysia tentang anak kecil kembar"))
        items.add(ListItem("Upin Ipin", "Ini sebuah deskripsi film malaysia tentang anak kecil kembar"))
        items.add(ListItem("Upin Ipin", "Ini sebuah deskripsi film malaysia tentang anak kecil kembar"))
        items.add(ListItem("Upin Ipin", "Ini sebuah deskripsi film malaysia tentang anak kecil kembar"))
        items.add(ListItem("Upin Ipin", "Ini sebuah deskripsi film malaysia tentang anak kecil kembar"))
        items.add(ListItem("Upin Ipin", "Ini sebuah deskripsi film malaysia tentang anak kecil kembar"))
        items.add(ListItem("Upin Ipin", "Ini sebuah deskripsi film malaysia tentang anak kecil kembar"))
        items.add(ListItem("Upin Ipin", "Ini sebuah deskripsi film malaysia tentang anak kecil kembar"))
        items.add(ListItem("Upin Ipin", "Ini sebuah deskripsi film malaysia tentang anak kecil kembar"))
        items.add(ListItem("Upin Ipin", "Ini sebuah deskripsi film malaysia tentang anak kecil kembar"))
        items.add(ListItem("Upin Ipin", "Ini sebuah deskripsi film malaysia tentang anak kecil kembar"))
        items.add(ListItem("Upin Ipin", "Ini sebuah deskripsi film malaysia tentang anak kecil kembar"))
        items.add(ListItem("Upin Ipin", "Ini sebuah deskripsi film malaysia tentang anak kecil kembar"))
        items.add(ListItem("Upin Ipin", "Ini sebuah deskripsi film malaysia tentang anak kecil kembar"))
        items.add(ListItem("Upin Ipin", "Ini sebuah deskripsi film malaysia tentang anak kecil kembar"))
        items.add(ListItem("Upin Ipin", "Ini sebuah deskripsi film malaysia tentang anak kecil kembar"))

        recyclerView.adapter = MainAdapater(items,this)
    }
}
