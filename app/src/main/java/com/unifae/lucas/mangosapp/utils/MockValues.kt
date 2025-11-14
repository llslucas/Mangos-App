package com.unifae.lucas.mangosapp.utils

import com.unifae.lucas.mangosapp.model.core.Bank
import com.unifae.lucas.mangosapp.model.core.Category
import com.unifae.lucas.mangosapp.model.core.Transaction
import com.unifae.lucas.mangosapp.model.core.TransactionWithDetails
import java.util.Date

val mockBankInter = Bank(id = 1, name = "Banco Inter", account = "1234", agencia = "1", titular = "Lucas Souza")
val mockBankNubank = Bank(id = 2, name = "NuBank", account = "1234", agencia = "1", titular = "Lucas Souza")
val mockBankItau = Bank(id = 3, name = "Itaú", account = "1234", agencia = "1", titular = "Lucas Souza")

val mockCategoryAlimentacao = Category(id = 1, name = "Alimentação", goal = 1000f)
val mockCategoryTransporte = Category(id = 2, name = "Transporte", goal = 500f)
val mockCategoryLazer = Category(id = 3, name = "Lazer", goal = 250f)

val mockTransaction1 = Transaction(
  id = 1,
  data = Date(),
  value = 2000f,
  bankId = 1,
  categoryId = null
)

val mockTransaction2 = Transaction(
  id = 2,
  data = Date(),
  value = 2000f,
  bankId = 2,
  categoryId = null
)

val mockTransaction3 = Transaction(
  id = 3,
  data = Date(),
  value = 2000f,
  bankId = 3,
  categoryId = null
)

val mockTransaction4 = Transaction(
  id = 1,
  data = Date(),
  value = -200f,
  bankId = 1,
  categoryId = 1
)

val mockTransactionsWithDetails = listOf(
  TransactionWithDetails(
    transaction = mockTransaction1,
    bank = mockBankInter,
    category = null
  ),
  TransactionWithDetails(
    transaction = mockTransaction2,
    bank = mockBankItau,
    category = null
  ),
  TransactionWithDetails(
    transaction = mockTransaction3,
    bank = mockBankNubank,
    category = null
  ),
  TransactionWithDetails(
    transaction = mockTransaction4,
    bank = mockBankInter,
    category = mockCategoryAlimentacao
  )
)