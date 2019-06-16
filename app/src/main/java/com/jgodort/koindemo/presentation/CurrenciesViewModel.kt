package com.jgodort.koindemo.presentation

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.jgodort.koindemo.data.DataRepositoryFactory
import com.jgodort.koindemo.model.Currency

class CurrenciesViewModel constructor(
    private val dataRepositoryFactory: DataRepositoryFactory
) : ViewModel() {

    val currenciesLiveData = MutableLiveData<List<Currency>>()

    fun retrieveCurrencies(jsonString: String) {
        val data = dataRepositoryFactory.retrieveLocalSource().getCurrencies(jsonString)
        currenciesLiveData.postValue(data)
    }
}