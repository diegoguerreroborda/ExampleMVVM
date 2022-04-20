package com.dhgb.examplemvvm.data

import com.dhgb.examplemvvm.data.database.dao.QuoteDao
import com.dhgb.examplemvvm.data.database.entities.QuoteEntity
import com.dhgb.examplemvvm.data.model.QuoteModel
import com.dhgb.examplemvvm.data.network.QuoteService
import com.dhgb.examplemvvm.domain.model.Quote
import com.dhgb.examplemvvm.domain.model.toDomain
import javax.inject.Inject

class QuoteRepository @Inject constructor(
    private val api: QuoteService,
    private val quoteDao: QuoteDao){

    suspend fun getAllQuotesFromApi(): List<Quote> {
        val response: List<QuoteModel> = api.getQuotes()
        return response.map { it.toDomain() }
    }

    suspend fun getAllQuotesFromDatabase(): List<Quote> {
        val response = quoteDao.getAllQuotes()
        return response.map { it.toDomain() }
    }

    suspend fun insertQuotes(quotes: List<QuoteEntity>) {
        quoteDao.insertQuote(quotes)
    }

    suspend fun clearQuotes() {
        quoteDao.deleteAllQuotes()
    }
}