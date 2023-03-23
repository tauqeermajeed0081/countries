package com.example.countries.core.model


import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize
import android.os.Parcelable

@Parcelize
data class CountriesItem(
    @SerializedName("capital")
    val capital: String,
    @SerializedName("code")
    val code: String,
    @SerializedName("currency")
    val currency: Currency,
    @SerializedName("demonym")
    val demonym: String?,
    @SerializedName("flag")
    val flag: String,
    @SerializedName("language")
    val language: Language,
    @SerializedName("name")
    val name: String,
    @SerializedName("region")
    val region: String
) : Parcelable