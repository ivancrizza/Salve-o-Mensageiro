package com.example.salveomensageiro.navigation

sealed class Screen(val route: String) {
    object Home : Screen("home")
    object OrixasDetail : Screen("orixa_detail/{orixaId}") {
        fun createRoute(orixaId: Int) = "orixa_detail/$orixaId"
    }
}
