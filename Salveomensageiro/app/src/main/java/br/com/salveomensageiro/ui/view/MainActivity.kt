package br.com.salveomensageiro.ui.view

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.core.view.WindowCompat
import br.com.salveomensageiro.data.Orixa
import br.com.salveomensageiro.domain.OrixaRepositoryImpl
import br.com.salveomensageiro.navigation.AppNavigation
import br.com.salveomensageiro.ui.theme.SalveOMensageiroTheme
import br.com.salveomensageiro.ui.viewmodel.OrixasViewmodel
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

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
