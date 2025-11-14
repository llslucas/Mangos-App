package com.unifae.lucas.mangosapp.persistence.repository

import com.unifae.lucas.mangosapp.model.core.Transaction
import com.unifae.lucas.mangosapp.model.core.TransactionWithDetails
import com.unifae.lucas.mangosapp.persistence.dao.TransactionDao
import kotlinx.coroutines.flow.Flow

class TransactionRepository(private val transactionDao: TransactionDao) {
  val list: Flow<List<TransactionWithDetails>> =
    transactionDao.getTransactionsWithDetails()

  suspend fun getById(id: Int): TransactionWithDetails?{
    return transactionDao.getTransactionWithDetailsById(id);
  }

  suspend fun insert(transaction: Transaction) {
    transactionDao.insert(transaction)
  }

  suspend fun deleteById(id: Int) {
    transactionDao.deleteById(id)
  }
}