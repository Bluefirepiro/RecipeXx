package com.example.recipexx

import android.os.Parcel
import android.os.Parcelable

data class Recipe(val name: String, val ingredients: List<String>, val instructions: String) :
    Parcelable {
    override fun describeContents(): Int {
        TODO("Not yet implemented")
    }

    override fun writeToParcel(dest: Parcel, flags: Int) {
        TODO("Not yet implemented")
    }
}

