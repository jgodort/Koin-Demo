package com.jgodort.koindemo.presentation

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.jgodort.koindemo.R
import com.jgodort.koindemo.model.Currency
import com.jgodort.koindemo.presentation.CurrenciesAdapter.ViewHolder

class CurrenciesAdapter : RecyclerView.Adapter<ViewHolder>() {

    var currencies: List<Currency> = arrayListOf()

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_currency, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = currencies.size

    override fun onBindViewHolder(
        holder: ViewHolder,
        position: Int
    ) {
        holder.currencyView.setCurrency(currencies[position])
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val currencyView: CurrencyView = view.findViewById(R.id.view_currency)
    }
}