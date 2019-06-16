package com.jgodort.koindemo

import com.jgodort.koindemo.model.Currency

object CurrencyFactory {

    fun makeCurrency(): Currency =
        Currency(
            DataFactory.randomInt(),
            DataFactory.randomUuid(),
            DataFactory.randomUuid(),
            DataFactory.randomUuid()
        )

    fun makeCurrencyList(count: Int): List<Currency> = (0..count).map { makeCurrency() }
}