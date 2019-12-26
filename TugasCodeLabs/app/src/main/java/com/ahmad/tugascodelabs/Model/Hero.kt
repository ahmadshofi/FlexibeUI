package com.ahmad.tugascodelabs.Model


import com.google.gson.annotations.SerializedName

data class Hero(
    @SerializedName("data")
    val `data`: List<Data>,
    @SerializedName("message")
    val message: String,
    @SerializedName("status")
    val status: Int
)