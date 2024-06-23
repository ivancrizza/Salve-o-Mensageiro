package br.com.salveomensageiro.ui.view

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.core.view.WindowCompat
import br.com.salveomensageiro.domain.OrixaRepositoryImpl
import br.com.salveomensageiro.navigation.AppNavigation
import br.com.salveomensageiro.ui.theme.SalveOMensageiroTheme
import br.com.salveomensageiro.ui.viewmodel.OrixasViewmodel
import java.io.BufferedReader
import java.io.InputStreamReader

class MainActivity : ComponentActivity() {

    private lateinit var viewmodel: OrixasViewmodel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)
        installSplashScreen()
        setContent {
            val jsonString = readJsonFromAssets("mock/orixas.json")
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

    private fun readJsonFromAssets(fileName: String): String {
        val inputStream = assets.open(fileName)
        val bufferedReader = BufferedReader(InputStreamReader(inputStream))
        return bufferedReader.use { it.readText() }
    }
}


@Composable
fun SetNavigation(orixasViewmodel: OrixasViewmodel) {
    AppNavigation(orixasViewmodel)
}
