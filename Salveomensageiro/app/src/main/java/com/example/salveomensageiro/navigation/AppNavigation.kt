package com.example.salveomensageiro.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.salveomensageiro.ui.view.DetailCard
import com.example.salveomensageiro.ui.view.OrixasHome

@Composable
fun AppNavigation(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = "orixasHome"
    ) {
        composable(
            route = "orixasHome"
        ) {
            OrixasHome(navController = navController)
        }
        composable(
            route = "detailCard/{name}",
            arguments = listOf(navArgument("name") { type = NavType.IntType })
        ) { backStackEntry ->
            val name = backStackEntry.arguments?.getInt("nome")
            name?.let { name ->
                DetailCard(orixaId = name)
            }
        }
    }
}