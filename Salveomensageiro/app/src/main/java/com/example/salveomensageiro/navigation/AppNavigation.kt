package com.example.salveomensageiro.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.salveomensageiro.OrixasHome
import com.example.salveomensageiro.ui.DetailCard

@Composable
fun AppNavigation(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Screen.Home.route
    ) {
        composable(
            route = Screen.Home.route
        ) {
            OrixasHome(navController = navController)
        }
        composable(
            route = Screen.OrixasDetail.route,
            arguments = listOf(navArgument("name") { type = NavType.StringType })
        ) { backStackEntry ->
            DetailCard(backStackEntry.arguments?.getString("name"))
        }
    }
}