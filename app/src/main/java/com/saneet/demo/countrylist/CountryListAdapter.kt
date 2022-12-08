package com.saneet.demo.countrylist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.saneet.demo.R
import com.saneet.demo.models.Country

class CountryListAdapter :
    ListAdapter<Country, CountryViewHolder>(object : DiffUtil.ItemCallback<Country>() {
        override fun areItemsTheSame(oldItem: Country, newItem: Country): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: Country, newItem: Country): Boolean {
            return oldItem == newItem
        }

    }) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryViewHolder {
        return CountryViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.layout_country_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: CountryViewHolder, position: Int) {
        getItem(position)?.let {
            holder.setValues(it)
        }
    }

    override fun getItemViewType(position: Int): Int {
        return super.getItemViewType(position)
    }
}

class CountryViewHolder(private val view: View) : ViewHolder(view) {

    fun setValues(country: Country) {
        view.findViewById<TextView>(R.id.name).text =
            String.format("%s, %s", country.name, country.region)
        view.findViewById<TextView>(R.id.code).text = country.code
        view.findViewById<TextView>(R.id.capital).text = country.capital
    }
}
