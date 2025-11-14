package com.unifae.lucas.mangosapp

import android.content.Context
import com.unifae.lucas.mangosapp.persistence.dao.BankDao
import com.unifae.lucas.mangosapp.persistence.dao.CategoryDao
import com.unifae.lucas.mangosapp.persistence.dao.TransactionDao
import com.unifae.lucas.mangosapp.persistence.db.MangosDatabase
import com.unifae.lucas.mangosapp.persistence.repository.BankRepository
import com.unifae.lucas.mangosapp.persistence.repository.CategoryRepository
import com.unifae.lucas.mangosapp.persistence.repository.TransactionRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule{
  @Provides
  @Singleton
  fun provideAppDatabase(@ApplicationContext context: Context): MangosDatabase{
    return MangosDatabase.getDatabase(context)
  }

  @Provides
  @Singleton
  fun provideTransactionDao(database: MangosDatabase): TransactionDao{
    return database.transactionDao()
  }

  @Provides
  @Singleton
  fun provideTransactionRepository(dao: TransactionDao): TransactionRepository{
    return TransactionRepository(dao)
  }

  @Provides
  @Singleton
  fun provideBankDao(database: MangosDatabase): BankDao {
    return database.bankDao()
  }

  @Provides
  @Singleton
  fun provideBankRepository(dao: BankDao): BankRepository {
    return BankRepository(dao)
  }

  @Provides
  @Singleton
  fun provideCategoryDao(database: MangosDatabase): CategoryDao {
    return database.categoryDao()
  }

  @Provides
  @Singleton
  fun provideCategoryRepository(dao: CategoryDao): CategoryRepository {
    return CategoryRepository(dao)
  }
}