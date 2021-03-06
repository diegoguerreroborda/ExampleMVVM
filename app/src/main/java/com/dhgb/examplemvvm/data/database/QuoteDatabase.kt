package com.dhgb.examplemvvm.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.dhgb.examplemvvm.data.database.dao.QuoteDao
import com.dhgb.examplemvvm.data.database.entities.QuoteEntity
import dagger.Binds

@Database(entities = [QuoteEntity::class], version = 1)
abstract class QuoteDatabase: RoomDatabase() {

    abstract fun getQuoteDao(): QuoteDao
}