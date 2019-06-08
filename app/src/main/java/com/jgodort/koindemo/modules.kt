package com.jgodort.koindemo

import com.google.gson.Gson
import org.koin.dsl.module

val applicationModule = module {
  single { Gson() }
  factory { CurrenciesAdapter() }
}