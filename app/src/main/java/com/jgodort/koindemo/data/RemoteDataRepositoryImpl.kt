package com.jgodort.koindemo.data

import com.google.gson.Gson
import com.jgodort.koindemo.model.Currency

class RemoteDataRepositoryImpl(private val gson: Gson) : DataRepository {

    override fun getCurrencies(jsonString: String): List<Currency> {
        TODO("Not Implemented")
    }

}