package com.unifae.lucas.mangosapp.model.core

import androidx.room.Embedded
import androidx.room.Relation

data class TransactionWithDetails(
  @Embedded
  val transaction: Transaction,

  @Relation(
    parentColumn = "bankId",
    entityColumn = "id"
  )
  val bank: Bank,

  @Relation(
    parentColumn = "categoryId",
    entityColumn = "id"
  )
  val category: Category?
)