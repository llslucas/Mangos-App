package com.unifae.lucas.mangosapp.persistence.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.unifae.lucas.mangosapp.model.core.Bank
import com.unifae.lucas.mangosapp.model.core.Category
import com.unifae.lucas.mangosapp.model.core.Transaction
import com.unifae.lucas.mangosapp.persistence.dao.BankDao
import com.unifae.lucas.mangosapp.persistence.dao.CategoryDao
import com.unifae.lucas.mangosapp.persistence.dao.TransactionDao
import com.unifae.lucas.mangosapp.utils.Converters
import kotlin.jvm.java

@Database(
  entities = [Bank::class, Category::class, Transaction::class],
  version = 1,
  exportSchema = false
)
@TypeConverters(
  Converters::class
)
abstract class MangosDatabase : RoomDatabase() {
  abstract fun bankDao(): BankDao
  abstract fun categoryDao(): CategoryDao
  abstract fun transactionDao(): TransactionDao

  companion object {
    @Volatile
    private var INSTANCE: MangosDatabase? = null

    fun getDatabase(context: Context): MangosDatabase {
      return INSTANCE ?: synchronized(this) {
        val instance = Room.databaseBuilder(
          context.applicationContext,
          MangosDatabase::class.java,
          "mangos_database"
        )
          .fallbackToDestructiveMigration(true)
          .build()

        INSTANCE = instance
        instance
      }
    }
  }
}