package com.unifae.lucas.mangosapp.model.core

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "bank")
data class Bank(
  @PrimaryKey(autoGenerate = true)
  val id: Int = 0,

  val name: String,
  val account: String,
  val agencia: String,
  val titular: String
)
