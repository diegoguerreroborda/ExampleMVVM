package com.dhgb.examplemvvm.data.database.dao

import androidx.room.*
import com.dhgb.examplemvvm.data.database.entities.QuoteEntity

@Dao
interface QuoteDao {

    @Query("SELECT * FROM QUOTE_TABLE ORDER BY author DESC")
    suspend fun getAllQuotes(): List<QuoteEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertQuote(quotes: List<QuoteEntity>)

    @Query("DELETE FROM QUOTE_TABLE")
    suspend fun deleteAllQuotes()
}