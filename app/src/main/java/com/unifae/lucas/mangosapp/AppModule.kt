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

/**
 * Módulo Hilt para fornecer dependências singleton da aplicação, incluindo banco de dados e repositórios.
 */
@Module
@InstallIn(SingletonComponent::class)
object AppModule{
  /**
   * Fornece instância singleton do banco de dados MangosDatabase.
   *
   * @param context Contexto da aplicação.
   * @return Instância do banco de dados.
   */
  @Provides
  @Singleton
  fun provideAppDatabase(@ApplicationContext context: Context): MangosDatabase{
    return MangosDatabase.getDatabase(context)
  }

  /**
   * Fornece instância singleton do DAO de transações.
   *
   * @param database Instância do banco de dados.
   * @return DAO de transações.
   */
  @Provides
  @Singleton
  fun provideTransactionDao(database: MangosDatabase): TransactionDao{
    return database.transactionDao()
  }

  /**
   * Fornece instância singleton do repositório de transações.
   *
   * @param dao DAO de transações.
   * @return Repositório de transações.
   */
  @Provides
  @Singleton
  fun provideTransactionRepository(dao: TransactionDao): TransactionRepository{
    return TransactionRepository(dao)
  }

  /**
   * Fornece instância singleton do DAO de bancos.
   *
   * @param database Instância do banco de dados.
   * @return DAO de bancos.
   */
  @Provides
  @Singleton
  fun provideBankDao(database: MangosDatabase): BankDao {
    return database.bankDao()
  }

  /**
   * Fornece instância singleton do repositório de bancos.
   *
   * @param dao DAO de bancos.
   * @return Repositório de bancos.
   */
  @Provides
  @Singleton
  fun provideBankRepository(dao: BankDao): BankRepository {
    return BankRepository(dao)
  }

  /**
   * Fornece instância singleton do DAO de categorias.
   *
   * @param database Instância do banco de dados.
   * @return DAO de categorias.
   */
  @Provides
  @Singleton
  fun provideCategoryDao(database: MangosDatabase): CategoryDao {
    return database.categoryDao()
  }

  /**
   * Fornece instância singleton do repositório de categorias.
   *
   * @param dao DAO de categorias.
   * @return Repositório de categorias.
   */
  @Provides
  @Singleton
  fun provideCategoryRepository(dao: CategoryDao): CategoryRepository {
    return CategoryRepository(dao)
  }
}