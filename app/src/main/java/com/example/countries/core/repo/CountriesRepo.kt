package com.example.countries.core.repo

import com.example.countries.data.remote.RemoteDataSource
import com.example.countries.data.remote.performGetOperation
import javax.inject.Inject

class CountriesRepo @Inject constructor(
    private val remoteDataSource: RemoteDataSource,
) {
    fun getCountries() =
        performGetOperation(
            networkCall = { remoteDataSource.getCountries() }
        )
}