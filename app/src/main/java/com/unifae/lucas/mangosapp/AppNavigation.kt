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

@Composable
fun AppNavigation() {
  val navController = rememberNavController()

  NavHost(
    navController = navController,
    startDestination = AppRoutes.DASHBOARD_SCREEN
  ) {
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
