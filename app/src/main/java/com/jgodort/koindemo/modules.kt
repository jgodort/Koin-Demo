package com.jgodort.koindemo

import com.google.gson.Gson
import com.jgodort.koindemo.data.DataRepository
import com.jgodort.koindemo.data.DataRepositoryFactory
import com.jgodort.koindemo.data.LocalDataRepositoryImpl
import com.jgodort.koindemo.data.RemoteDataRepositoryImpl
import com.jgodort.koindemo.presentation.CurrenciesAdapter
import com.jgodort.koindemo.presentation.CurrenciesViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.core.qualifier.named
import org.koin.dsl.module

val applicationModule = module {
    single { Gson() }
    single { UrlHelper() }

    factory { CurrenciesAdapter() }
    factory<DataRepository>(named("Local")) { LocalDataRepositoryImpl(get()) }
    factory<DataRepository>(named("Remote")) { RemoteDataRepositoryImpl(get()) }
    factory { DataRepositoryFactory(get(named("Local")), get(named("Remote"))) }

    viewModel { CurrenciesViewModel(get()) }
}