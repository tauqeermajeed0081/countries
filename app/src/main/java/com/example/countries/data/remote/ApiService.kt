package com.example.countries.data.remote

import com.example.countries.core.model.Countries
import com.example.countries.utils.AppConstants
import retrofit2.Response
import retrofit2.http.*

interface ApiService {
    @GET(AppConstants.GET_COUNTRIES)
    suspend fun getCountries(): Response<Countries>

}