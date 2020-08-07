package com.trinitydigital.viewpager.data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class OnBoardModel(
    val image: Int,
    val title: String,
    val desc: String
) : Parcelable