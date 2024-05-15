package br.com.salveomensageiro.ui.view

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.googlefonts.Font
import androidx.compose.ui.text.googlefonts.GoogleFont
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.salveomensageiro.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OrixaTopBar(
    title: String,
    navController: NavController
) {
    val font = GoogleFont("Bebas Neue")
    val provider = GoogleFont.Provider(
        providerAuthority = "com.google.android.gms.fonts",
        providerPackage = "com.google.android.gms",
        certificates = R.array.com_google_android_gms_fonts_certs
    )
    val fontFamily = FontFamily(
        Font(googleFont = font, fontProvider = provider)
    )
    TopAppBar(
        navigationIcon = {
            IconButton(onClick = {
                navController.popBackStack()
            }) {
                Icon(
                    Icons.Default.ArrowBack, contentDescription = "Voltar",
                    tint = MaterialTheme.colorScheme.tertiary
                )
            }
        },
        title = {
            Text(
                title,
                fontFamily = fontFamily,
                fontSize = 30.sp,
                color = MaterialTheme.colorScheme.tertiary
            )

        },
        colors = TopAppBarDefaults.topAppBarColors(containerColor = MaterialTheme.colorScheme.primary),
    )
}