package com.ahmad.pabcl

import android.os.Parcel
import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ListItem(val judul: String, val desc:String) : Parcelable
