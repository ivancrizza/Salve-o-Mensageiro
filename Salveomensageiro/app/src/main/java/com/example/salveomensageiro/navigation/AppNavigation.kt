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
import com.example.salveomensageiro.ui.view.Screen
import com.example.salveomensageiro.ui.view.SplashScreen
import com.example.salveomensageiro.ui.viewmodel.OrixasViewmodel

@Composable
fun AppNavigation(orixasViewmodel: OrixasViewmodel) {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = Screen.Splash.route
    ) {
        composable(
            route = "splashScreen"
        ) {
            SplashScreen(navController = navController)
        }
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