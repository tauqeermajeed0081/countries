package com.example.countries.core.ui

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.library.baseAdapters.BR
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.countries.R
import com.example.countries.core.interfaces.CountriesActivityInterface
import com.example.countries.core.model.CountriesItem
import com.example.countries.core.viewmodel.CountriesViewModel
import com.example.countries.databinding.ActivitySearchListBinding
import com.example.countries.utils.Status
import com.kaopiz.kprogresshud.KProgressHUD
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CountriesListActivity : AppCompatActivity(), CountriesActivityInterface {

    private lateinit var binding: ActivitySearchListBinding
    open lateinit var loaderDialog: KProgressHUD

    private lateinit var countriesList: ArrayList<CountriesItem>
    private val countriesViewModel: CountriesViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_search_list)
        initView()
        setUpObserver()
        //setUpRecyclerViewForCustomer()
    }

    private fun initView() {
        loaderDialog = KProgressHUD(this)
    }

    private fun setUpRecyclerViewForCustomer() {
        val layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        binding.customerRev.layoutManager = layoutManager
        binding.setVariable(BR.data, countriesList)
    }
    private fun setUpObserver(){
        countriesViewModel.countries.observe(this, Observer {
            when (it.status) {
                Status.SUCCESS -> {
                    loaderDialog.dismiss()
                    binding.noSearchLayout.title.visibility = View.GONE
                    Log.i("Data", "setUpObserver: ${it.data}")
                    countriesList = it.data!!
                    binding.customerRev.visibility = View.VISIBLE
                    setUpRecyclerViewForCustomer()
                }
                Status.LOADING -> {
                    loaderDialog.show()
                    binding.customerRev.visibility = View.GONE
                }
                Status.ERROR -> {
                    //Handle Error
                    loaderDialog.dismiss()
                    binding.noSearchLayout.title.visibility = View.VISIBLE
                    Log.i("Error", "setUpObserver: ${it.message}")
                }
            }
        })
    }
    override fun onCountriesCLick(customerName: String) {
    }


    override fun onBackClick() {
        finish()
    }

    override fun onStart() {
        super.onStart()
    }

    override fun onResume() {
        super.onResume()
    }

    override fun onDestroy() {
        super.onDestroy()
    }
}