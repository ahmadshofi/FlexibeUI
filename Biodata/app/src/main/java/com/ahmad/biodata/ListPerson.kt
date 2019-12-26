package com.ahmad.biodata

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ListPerson (val nama:String,val ttl:String,val alamat:String,val hobby:String):Parcelable