package com.jgodort.koindemo

import android.arch.lifecycle.Observer
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import com.jgodort.koindemo.presentation.CurrenciesAdapter
import com.jgodort.koindemo.presentation.CurrenciesViewModel
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.android.ext.android.inject
import org.koin.android.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    val currenciesAdapter: CurrenciesAdapter by inject()
    val currenciesViewModel: CurrenciesViewModel by viewModel()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupCurrenciesRecycler()

        currenciesViewModel.currenciesLiveData.observe(this, Observer {
            currenciesAdapter.currencies=it!!
        })
        val currenciesJson = resources.openRawResource(R.raw.currencies)
            .bufferedReader().use { it.readText() }
        currenciesViewModel.retrieveCurrencies(currenciesJson)
    }

    private fun setupCurrenciesRecycler() {
        recycler_currencies.layoutManager = LinearLayoutManager(this)
        recycler_currencies.adapter = currenciesAdapter
    }
}
