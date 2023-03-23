package com.example.countries.data.remote

import javax.inject.Inject

class RemoteDataSource @Inject constructor(
    private val apiService: ApiService,
) : BaseDataSource() {

    suspend fun getCountries() =
        getResult {
            apiService.getCountries()
        }
}