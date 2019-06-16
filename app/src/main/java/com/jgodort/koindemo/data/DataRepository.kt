package com.jgodort.koindemo.data

import com.jgodort.koindemo.model.Currency

interface DataRepository {
    fun getCurrencies(jsonString: String): List<Currency>
}