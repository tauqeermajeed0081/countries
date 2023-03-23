package com.example.countries.core.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.countries.core.model.Countries
import com.example.countries.core.repo.CountriesRepo
import com.example.countries.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CountriesViewModel @Inject constructor(
    countriesRepo: CountriesRepo,
) : ViewModel() {

    //LiveData
    val countries: LiveData<Resource<Countries>> = countriesRepo.getCountries()
}