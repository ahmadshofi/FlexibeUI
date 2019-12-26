package com.ahmad.callculatorapps

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import net.objecthunter.exp4j.ExpressionBuilder
import java.lang.Exception

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Nomor
        tvSatu.setOnClickListener { appendOnExpression("1",true) }
        tvDua.setOnClickListener { appendOnExpression("2",true) }
        tvTiga.setOnClickListener { appendOnExpression("3",true) }
        tvEmpat.setOnClickListener { appendOnExpression("4",true) }
        tvLima.setOnClickListener { appendOnExpression("5",true) }
        tvEnam.setOnClickListener { appendOnExpression("6",true) }
        tvTujuh.setOnClickListener { appendOnExpression("7",true) }
        tvDelapan.setOnClickListener { appendOnExpression("8",true) }
        tvSembilan.setOnClickListener { appendOnExpression("9",true) }
        tvNol.setOnClickListener { appendOnExpression("0",true) }
        tvKoma.setOnClickListener { appendOnExpression(".",true) }

        //Operator
        tvTambah.setOnClickListener { appendOnExpression("+",false) }
        tvKurang.setOnClickListener { appendOnExpression("-",false) }
        tvkali.setOnClickListener { appendOnExpression("*",false) }
        tvBagi.setOnClickListener { appendOnExpression("/",false) }
        tvBukaKurung.setOnClickListener { appendOnExpression("(",false) }
        tvTutupKurung.setOnClickListener { appendOnExpression(")",false) }

        tvHapus.setOnClickListener {
            edt_input.text = ""
            edt_hasil.text = ""
        }

        tvKembali.setOnClickListener {
            val string = edt_input.text.toString()
            if (string.isNotEmpty())
            {
                edt_input.text = string.substring(0,string.length-1)
            }
            edt_hasil.text = ""
        }

        tvSamaDengan.setOnClickListener {
            try {
                val input = ExpressionBuilder(edt_input.text.toString()).build()
                val hasil = input.evaluate()
                val longHasil = hasil.toLong()
                if (hasil == longHasil.toDouble())
                    edt_hasil.text = longHasil.toString()
                else
                    edt_hasil.text = hasil.toString()
            }catch (e:Exception){
                Log.d("Exception"," message : "+e.message)
            }
        }

    }

    private fun appendOnExpression(s: String, b: Boolean) {

        if (edt_hasil.text.isNotEmpty())
        {
            edt_input.text = ""
        }

        if (b)
        {
            edt_hasil.text = ""
            edt_input.append(s)
        }
        else
        {
            edt_input.append(edt_hasil.text)
            edt_input.append(s)
            edt_hasil.text = ""
        }

    }
}
