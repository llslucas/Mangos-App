package com.unifae.lucas.mangosapp.persistence.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction
import com.unifae.lucas.mangosapp.model.core.TransactionWithDetails
import kotlinx.coroutines.flow.Flow

@Dao
interface TransactionDao {
  @Transaction
  @Query("SELECT * FROM `transaction`")
  fun getTransactionsWithDetails(): Flow<List<TransactionWithDetails>>

  @Transaction
  @Query("SELECT * FROM `transaction` WHERE id = :id")
  suspend fun getTransactionWithDetailsById(id: Int): TransactionWithDetails?

  @Insert
  suspend fun insert(transaction: com.unifae.lucas.mangosapp.model.core.Transaction)

  @Query("DELETE FROM `transaction` WHERE id = :id")
  suspend fun deleteById(id: Int)
}