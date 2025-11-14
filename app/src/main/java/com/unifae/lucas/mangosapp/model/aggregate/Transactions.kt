package com.unifae.lucas.mangosapp.model.aggregate

import com.unifae.lucas.mangosapp.model.core.TransactionWithDetails

data class Transactions(
  val itens: List<TransactionWithDetails>
) {
  fun getBalance(): Float? {
    val values = itens.map { it.transaction.value }

    return values.fold(0f) { acc, value ->
      acc + value
    }
  }

  fun getIncome(): Float {
    val values = itens.map { it.transaction.value }

    return values.fold(0f) { acc, value ->
      if(value < 0f){
        acc
      }else{
        acc + value
      }
    }
  }

  fun getExpenses(): Float {
    val values = itens.map { it.transaction.value }

    return values.fold(0f) { acc, value ->
      if(value > 0f){
        acc
      }else{
        acc + value
      }
    }
  }
}