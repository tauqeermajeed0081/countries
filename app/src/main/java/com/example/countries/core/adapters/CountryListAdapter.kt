package com.example.countries.core.adapters

import android.content.Context
import android.os.Build
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.databinding.ViewDataBinding
import androidx.databinding.library.baseAdapters.BR
import androidx.recyclerview.widget.RecyclerView
import com.example.countries.core.model.CountriesItem
import com.example.countries.databinding.CountriesListItemBinding
import kotlin.collections.ArrayList

class CountryListAdapter(
    private val context: Context,
    private var dataList: ArrayList<CountriesItem>
) :
    RecyclerView.Adapter<CountryListAdapter.BindViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BindViewHolder {

        val rootView: ViewDataBinding =
            CountriesListItemBinding.inflate(LayoutInflater.from(context), parent, false)

        return BindViewHolder(rootView)

    }

    override fun getItemCount(): Int {
        return dataList.size
    }


    @RequiresApi(Build.VERSION_CODES.M)
    override fun onBindViewHolder(viewHolder: BindViewHolder, position: Int) {
        val item = dataList[position]
        Log.i("TAG", "onBindViewHolder: item: $item")
        viewHolder.itemBinding.setVariable(BR.dataList, item)
        //viewHolder.itemBinding.setVariable(BR.onClick, context)
        viewHolder.itemBinding.executePendingBindings()
    }


    class BindViewHolder(val itemBinding: ViewDataBinding) :
        RecyclerView.ViewHolder(itemBinding.root) {
    }

}