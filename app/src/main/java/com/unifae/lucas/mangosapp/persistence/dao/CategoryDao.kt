package com.unifae.lucas.mangosapp.persistence.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.unifae.lucas.mangosapp.model.core.Category
import kotlinx.coroutines.flow.Flow

@Dao
interface CategoryDao {
  @Insert(onConflict = OnConflictStrategy.IGNORE)
  suspend fun insert(category: Category)

  @Query("SELECT * FROM category")
  fun listAll(): Flow<List<Category>>

  @Query("SELECT * FROM category WHERE id = :id")
  suspend fun getById(id: Int): Category?

  @Query("DELETE FROM category WHERE id = :id")
  suspend fun deleteById(id: Int)

  @Query("DELETE FROM category")
  suspend fun deleteAll()
}