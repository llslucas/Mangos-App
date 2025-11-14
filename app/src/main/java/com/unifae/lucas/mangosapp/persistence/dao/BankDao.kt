package com.unifae.lucas.mangosapp.persistence.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.unifae.lucas.mangosapp.model.core.Bank
import kotlinx.coroutines.flow.Flow

@Dao
interface BankDao {
  @Insert(onConflict = OnConflictStrategy.IGNORE)
  suspend fun insert(bank: Bank)

  @Query("SELECT * FROM bank")
  fun listAll(): Flow<List<Bank>>

  @Query("SELECT * FROM bank WHERE id = :id")
  suspend fun getById(id: Int): Bank?

  @Query("DELETE FROM bank WHERE id = :id")
  suspend fun deleteById(id: Int)

  @Query("DELETE FROM bank")
  suspend fun deleteAll()
}