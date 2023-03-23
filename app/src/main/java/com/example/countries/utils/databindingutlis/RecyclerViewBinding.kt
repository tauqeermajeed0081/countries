package com.example.countries.utils.databindingutlis

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.countries.core.adapters.CountryListAdapter
import com.example.countries.core.model.CountriesItem
import kotlin.collections.ArrayList

@BindingAdapter("customerList")
fun bindingRecyclerViewCustomerList(
    view: RecyclerView,
    dataList: ArrayList<CountriesItem>?
) {
    if (dataList?.isEmpty() == true)
        return
    val layoutManager = view.layoutManager
    if (layoutManager == null)
        view.layoutManager = LinearLayoutManager(view.context)
    var adapter = view.adapter
    if (adapter == null) {
        adapter = dataList?.let {
           CountryListAdapter(view.context, it)
        }
        view.adapter = adapter
    }
}
