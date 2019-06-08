package com.jgodort.koindemo

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.jgodort.koindemo.CurrenciesAdapter.ViewHolder
import com.jgodort.koindemo.model.Currency

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
    val currency = currencies[position]
    holder.nameText.text = currency.name
    holder.symbolText.text = currency.symbol
  }

  inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    val nameText: TextView = view.findViewById(R.id.text_name)
    val symbolText: TextView = view.findViewById(R.id.text_symbol)
  }
}