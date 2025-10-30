package com.unifae.lucas.mangosapp.model.core

import java.sql.Date

data class Transaction(
  val type: String,
  val data: Date,
  val value: Float,
  val bank: Bank,
  val category: Category
)
