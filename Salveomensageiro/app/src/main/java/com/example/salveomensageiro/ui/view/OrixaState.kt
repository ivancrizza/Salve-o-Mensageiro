package com.example.salveomensageiro.ui.view

sealed class Screen(val route: String) {
    object Home : Screen("orixasHome")
    object Detail : Screen("detailCard/{index}") {
        fun createRoute(rota: String) = "detailCard/{$rota}"
    }

    object Splash : Screen("splashScreen")

}