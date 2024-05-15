package com.example.salveomensageiro.ui.view

import android.os.Bundle
import android.view.WindowInsets
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.core.view.WindowCompat
import com.example.salveomensageiro.domain.OrixaRepositoryImpl
import com.example.salveomensageiro.navigation.AppNavigation
import com.example.salveomensageiro.ui.theme.SalveOMensageiroTheme
import com.example.salveomensageiro.ui.viewmodel.OrixasViewmodel

class MainActivity : ComponentActivity() {

    private lateinit var viewmodel: OrixasViewmodel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)
        setContent {
            val jsonString = assets.open("mock/orixas.json").bufferedReader().use { it.readText() }
            val orixaRepository = OrixaRepositoryImpl(jsonString)
            viewmodel = OrixasViewmodel(orixaRepository = orixaRepository)
            SalveOMensageiroTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    SetNavigation(viewmodel)
                }
            }
        }
    }
}

@Composable
fun SetNavigation(orixasViewmodel: OrixasViewmodel) {
    AppNavigation(orixasViewmodel)
}
