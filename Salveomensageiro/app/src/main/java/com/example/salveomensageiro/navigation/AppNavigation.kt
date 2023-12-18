package com.example.salveomensageiro.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
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
    val modifier = Modifier
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
            route = "detailCard/{name}"
        ) {
            DetailCard(modifier, orixasViewmodel)
        }
    }
}
