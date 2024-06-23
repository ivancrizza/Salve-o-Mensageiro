package br.com.salveomensageiro.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import br.com.salveomensageiro.ui.view.DetailCard
import br.com.salveomensageiro.ui.view.OrixasHome
import br.com.salveomensageiro.ui.view.Screen
import br.com.salveomensageiro.ui.viewmodel.OrixasViewmodel

@Composable
fun AppNavigation(orixasViewmodel: OrixasViewmodel) {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = Screen.Home.route
    ) {
        composable(
            route = Screen.Home.route
        ) {
            OrixasHome(navController = navController, orixasViewmodel = orixasViewmodel)
        }
        composable(
            route = Screen.Detail.route,
            arguments = listOf(navArgument("index") {
                type = NavType.IntType
            })
        ) { backStackEntry ->
            val index = backStackEntry.arguments?.getInt("index") ?: 0
            DetailCard(orixasViewmodel, index = index, navController = navController)
        }
    }
}