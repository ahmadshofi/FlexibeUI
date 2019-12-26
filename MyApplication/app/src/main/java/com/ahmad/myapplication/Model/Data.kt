package com.ahmad.myapplication.Model


import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize


data class Data(
    @SerializedName("data")
    val `data`: List<DataX>,
    @SerializedName("message")
    val message: String,
    @SerializedName("status")
    val status: Int
)