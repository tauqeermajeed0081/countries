package com.example.countries.core.model


import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize
import android.os.Parcelable

@Parcelize
data class Language(
    @SerializedName("code")
    val code: String?,
    @SerializedName("iso639_2")
    val iso6392: String?,
    @SerializedName("name")
    val name: String,
    @SerializedName("nativeName")
    val nativeName: String?
) : Parcelable