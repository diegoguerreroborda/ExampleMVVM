package com.dhgb.examplemvvm.domain

import android.util.Log
import com.dhgb.examplemvvm.data.QuoteRepository
import com.dhgb.examplemvvm.domain.model.Quote
import javax.inject.Inject

class GetRandomQuoteUseCase @Inject constructor(private val repository: QuoteRepository){

    suspend operator fun invoke():Quote?{
        val quotes = repository.getAllQuotesFromDatabase()
        if(!quotes.isNullOrEmpty()){
            val randomNumber = (quotes.indices).random()
            return quotes[randomNumber]
        }
        return null
    }
}