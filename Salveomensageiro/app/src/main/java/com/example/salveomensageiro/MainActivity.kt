package com.example.salveomensageiro

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.example.salveomensageiro.data.Orixas
import com.example.salveomensageiro.data.OrixasDetail
import com.example.salveomensageiro.data.orixas
import com.example.salveomensageiro.navigation.AppNavigation
import com.example.salveomensageiro.ui.OrixasDetailCard
import com.example.salveomensageiro.ui.theme.SalveOMensageiroTheme

class MainActivity : ComponentActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            SalveOMensageiroTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    OrixasDetailCard(
                        orixasDetail = OrixasDetail(
                            1,
                            R.drawable.ewa,
                            R.string.ewa,
                            "Sábado",
                            "Vermelho Vivo, Coral e Rosa, amarelo",
                            "Lira, arpão, Ofá",
                            "Florestas, Céu Rosado, Astros e Estrelas, mata virgem",
                            "Beleza, Vidência (sensibilidade, sexto sentido), Criatividade, possibilidades",
                            "Ri Ro Ewá!"
                        )
                    )

                }
            }
        }
    }
}

@Composable
fun SetNavigation() {
    val navController = rememberNavController()
    AppNavigation(navController = navController)
}
