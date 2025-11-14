package com.unifae.lucas.mangosapp

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.unifae.lucas.mangosapp.view.screen.CreateBankScreen
import com.unifae.lucas.mangosapp.view.screen.CreateCategoryScreen
import com.unifae.lucas.mangosapp.view.screen.CreateTransactionScreen
import com.unifae.lucas.mangosapp.view.screen.DashboardScreen
import com.unifae.lucas.mangosapp.view.screen.ExtratoScreen
import com.unifae.lucas.mangosapp.view.screen.MetaScreen

/**
 * Função composable que configura a navegação do app usando NavHost, definindo rotas para telas principais e de criação.
 * A tela inicial é o dashboard, com navegação entre telas via callbacks.
 */
@Composable
fun AppNavigation() {
  val navController = rememberNavController()

  NavHost(
    navController = navController,
    startDestination = AppRoutes.DASHBOARD_SCREEN
  ) {
    // Rota para tela de dashboard, com navegações para extrato, metas, novo banco e nova transação
    composable(route = AppRoutes.DASHBOARD_SCREEN) {
      DashboardScreen(
        onChangeToExtrato = {
          navController.navigate(AppRoutes.EXTRATO_SCREEN)
        },
        onChangeToMetas = {
          navController.navigate(AppRoutes.META_SCREEN)
        },
        onChangeToNewBank = {
          navController.navigate(AppRoutes.CREATE_BANK_SCREEN)
        },
        onChangeToNewTransaction = {
          navController.navigate(AppRoutes.CREATE_TRANSACTION_SCREEN)
        }
      )
    }

    // Rota para tela de extrato, com navegações para home e metas
    composable(route = AppRoutes.EXTRATO_SCREEN) {
      ExtratoScreen(
        onChangeToHome = {
          navController.navigate(AppRoutes.DASHBOARD_SCREEN)
        },
        onChangeToMetas = {
          navController.navigate(AppRoutes.META_SCREEN)
        }
      )
    }

    // Rota para tela de metas, com navegações para home, extrato e nova categoria
    composable(route = AppRoutes.META_SCREEN) {
      MetaScreen(
        onChangeToHome = {
          navController.navigate(AppRoutes.DASHBOARD_SCREEN)
        },
        onChangeToExtrato = {
          navController.navigate(AppRoutes.EXTRATO_SCREEN)
        },
        onChangeToNewCategory = {
          navController.navigate(AppRoutes.CREATE_CATEGORY_SCREEN)
        }
      )
    }

    // Rota para tela de criação de banco, com navegações para extrato, home e metas
    composable(route = AppRoutes.CREATE_BANK_SCREEN) {
      CreateBankScreen(
        onChangeToExtrato = {
          navController.navigate(AppRoutes.EXTRATO_SCREEN)
        },
        onChangeToHome = {
          navController.navigate(AppRoutes.DASHBOARD_SCREEN)
        },
        onChangeToMetas = {
          navController.navigate(AppRoutes.META_SCREEN)
        },
      )
    }

    // Rota para tela de criação de categoria, com navegações para extrato, home e metas
    composable(route = AppRoutes.CREATE_CATEGORY_SCREEN) {
      CreateCategoryScreen(
        onChangeToExtrato = {
          navController.navigate(AppRoutes.EXTRATO_SCREEN)
        },
        onChangeToHome = {
          navController.navigate(AppRoutes.DASHBOARD_SCREEN)
        },
        onChangeToMetas = {
          navController.navigate(AppRoutes.META_SCREEN)
        },
      )
    }

    // Rota para tela de criação de transação, com navegações para extrato, home e metas
    composable(route = AppRoutes.CREATE_TRANSACTION_SCREEN) {
      CreateTransactionScreen(
        onChangeToExtrato = {
          navController.navigate(AppRoutes.EXTRATO_SCREEN)
        },
        onChangeToHome = {
          navController.navigate(AppRoutes.DASHBOARD_SCREEN)
        },
        onChangeToMetas = {
          navController.navigate(AppRoutes.META_SCREEN)
        },
      )
    }
  }
}
