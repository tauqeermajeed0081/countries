package com.example.countries.utils;
import androidx.viewbinding.BuildConfig

class AppConstants {
    companion object {
        val SHOW_CONSOLE_LOGS = BuildConfig.DEBUG

        /**
         * Base and staging URLS
         */
        const val BASE_URL = "https://gist.githubusercontent.com/"

        /**
         * EndPoints
         */
        const val GET_COUNTRIES = BASE_URL  + "peymano-wmt/32dcb892b06648910ddd40406e37fdab/raw/db25946fd77c5873b0303b858e861ce724e0dcd0/countries.json"

    }
}