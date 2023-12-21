package com.example.salveomensageiro.ui.view

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.rememberNavController
import com.example.salveomensageiro.domain.OrixaRepositoryImpl
import com.example.salveomensageiro.navigation.AppNavigation
import com.example.salveomensageiro.ui.theme.SalveOMensageiroTheme
import com.example.salveomensageiro.ui.viewmodel.OrixasViewmodel

class MainActivity : ComponentActivity() {

    private lateinit var viewmodel: OrixasViewmodel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val jsonString = assets.open("mock/orixas.json").bufferedReader().use { it.readText() }
            val orixaRepository = OrixaRepositoryImpl(jsonString)

            viewmodel = OrixasViewmodel(orixaRepository = orixaRepository)
            SalveOMensageiroTheme {
                // A surface container using the 'background' color from the theme
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
