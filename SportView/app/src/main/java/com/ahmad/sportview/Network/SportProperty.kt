package com.ahmad.sportview.Network

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize

@Parcelize
data class SportProperty(
        val idSport: String,
        @Json(name = "strSportThumb") val imgSrcUrl : String,
        val strSport: String,
        val strFormat: String,
        val strSportDescription: String
):Parcelable{
        val isRental
        get() = strFormat == "TeamvsTeam"
}