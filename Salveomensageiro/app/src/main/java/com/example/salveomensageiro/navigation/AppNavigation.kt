package com.example.salveomensageiro.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.salveomensageiro.ui.view.DetailCard
import com.example.salveomensageiro.ui.view.OrixasHome
import com.example.salveomensageiro.ui.viewmodel.OrixasViewmodel

@Composable
fun AppNavigation(orixasViewmodel: OrixasViewmodel) {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = "orixasHome"
    ) {
        composable(
            route = "orixasHome"
        ) {
            OrixasHome(navController = navController, orixasViewmodel = orixasViewmodel)
        }
        composable(
            route = "detailCard/{index}",
            arguments = listOf(navArgument("index") {
                type = NavType.IntType
            })
        ) { backStackEntry ->
            val index = backStackEntry.arguments?.getInt("index") ?: 0
            DetailCard(orixasViewmodel, index = index)
        }
        composable(
            route = "detailCardSearch/{name}",
            arguments = listOf(navArgument("name") {
                type = NavType.StringType
            })
        ) { backStackEntry ->
            val index = backStackEntry.arguments?.getInt("index") ?: 0
            DetailCard(orixasViewmodel, index = index)
        }
    }
}