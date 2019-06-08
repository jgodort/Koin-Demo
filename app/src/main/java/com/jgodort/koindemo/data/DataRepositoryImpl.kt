package com.jgodort.koindemo.data

import com.google.gson.Gson
import com.jgodort.koindemo.model.Currency

class DataRepositoryImpl(private val gson: Gson) {

  fun getCurrencies(jsonString: String): List<Currency> {
    return gson.fromJson(
        jsonString,
        Array<Currency>::class.java)
        .toList()
  }
}