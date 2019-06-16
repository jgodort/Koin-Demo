package com.jgodort.koindemo.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.jgodort.koindemo.data.DataRepositoryFactory
import com.jgodort.koindemo.model.Currency

class CurrenciesViewModel constructor(
    private val dataRepositoryFactory: DataRepositoryFactory,
    private val jsonString: String
) : ViewModel() {

    val currenciesLiveData = MutableLiveData<List<Currency>>()

    fun retrieveCurrencies() {
        val data = dataRepositoryFactory.retrieveLocalSource().getCurrencies(jsonString)
        currenciesLiveData.postValue(data)
    }
}