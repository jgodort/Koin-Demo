package com.jgodort.koindemo.presentation

import android.content.Context
import android.net.Uri
import android.util.AttributeSet
import android.view.View
import android.widget.LinearLayout
import com.jgodort.koindemo.R
import com.jgodort.koindemo.UrlHelper
import com.jgodort.koindemo.model.Currency
import kotlinx.android.synthetic.main.view_currency.view.*
import org.koin.core.KoinComponent
import org.koin.core.inject

class CurrencyView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : LinearLayout(context, attrs, defStyleAttr), KoinComponent {

    val urlHelper: UrlHelper by inject()

    init {
        View.inflate(context, R.layout.view_currency, this)
    }

    fun setCurrency(currency: Currency) {
        text_name.text = currency.name
        text_symbol.text = currency.symbol

        setOnClickListener {
            urlHelper.launchUrl(context, Uri.parse("https://coinmarketcap.com/currencies/${currency.slug}"))
        }

    }
}