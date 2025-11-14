package com.unifae.lucas.mangosapp.persistence.repository

import com.unifae.lucas.mangosapp.model.core.Bank
import com.unifae.lucas.mangosapp.persistence.dao.BankDao
import kotlinx.coroutines.flow.Flow

class BankRepository(private val bankDao: BankDao) {
  val list: Flow<List<Bank>> =
    bankDao.listAll()

  suspend fun getById(id: Int): Bank?{
    return bankDao.getById(id);
  }

  suspend fun insert(bank: Bank) {
    bankDao.insert(bank)
  }

  suspend fun deleteById(id: Int) {
    bankDao.deleteById(id)
  }
}