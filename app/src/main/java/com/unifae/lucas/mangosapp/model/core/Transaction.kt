package com.unifae.lucas.mangosapp.model.core

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import java.util.Date

@Entity(
  tableName = "transaction",
  foreignKeys = [
    ForeignKey(
      entity = Bank::class,
      parentColumns = ["id"],
      childColumns = ["bankId"],
      onDelete = ForeignKey.SET_NULL
    ),
    ForeignKey(
      entity = Category::class,
      parentColumns = ["id"],
      childColumns = ["categoryId"],
      onDelete = ForeignKey.SET_NULL
    )
  ]
)
data class Transaction(
  @PrimaryKey(autoGenerate = true)
  val id: Int = 0,

  val data: Date,
  val value: Float,
  val bankId: Int,
  val categoryId: Int?
)
