package com.unifae.lucas.mangosapp.persistence.repository

import com.unifae.lucas.mangosapp.model.core.Category
import com.unifae.lucas.mangosapp.persistence.dao.CategoryDao
import kotlinx.coroutines.flow.Flow

class CategoryRepository(private val categoryDao: CategoryDao) {
  val list: Flow<List<Category>> =
    categoryDao.listAll()

  suspend fun getById(id: Int): Category?{
    return categoryDao.getById(id);
  }

  suspend fun insert(category: Category) {
    categoryDao.insert(category)
  }

  suspend fun deleteById(id: Int) {
    categoryDao.deleteById(id)
  }
}