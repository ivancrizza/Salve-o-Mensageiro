package br.com.salveomensageiro.ui.view

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.googlefonts.Font
import androidx.compose.ui.text.googlefonts.GoogleFont
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.salveomensageiro.R


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OrixaSearchTopBar(
    modifier: Modifier = Modifier,
    scrollBehavior: TopAppBarScrollBehavior,
    onFilterClick: (String) -> Unit,
) {
    val searchText = remember { mutableStateOf("") }
    var showTextField by remember { mutableStateOf(false) }
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
        title = {
            if (showTextField) {
                TextField(
                    singleLine = true,
                    value = searchText.value,
                    onValueChange = { searchText.value = it },
                    placeholder = {
                        Text(
                            "Buscar", color = MaterialTheme.colorScheme.tertiary
                        )
                    },
                    trailingIcon = {
                        IconButton(onClick = { onFilterClick(searchText.value) }) {
                            Icon(
                                Icons.Default.Search, contentDescription = "Buscar",
                                tint = MaterialTheme.colorScheme.tertiary
                            )
                        }
                    },
                    colors = TextFieldDefaults.colors(
                        focusedTextColor = MaterialTheme.colorScheme.tertiary,
                        focusedContainerColor = MaterialTheme.colorScheme.primary,
                        unfocusedContainerColor = MaterialTheme.colorScheme.primary
                    ),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 12.dp)
                )
            } else {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Salve o Mensageiro",
                        fontFamily = fontFamily,
                        fontSize = 30.sp,
                        color = MaterialTheme.colorScheme.tertiary
                    )
                }
            }
        },
        modifier = modifier,
        actions = {
            if (!showTextField) {
                IconButton(onClick = { showTextField = true }) {
                    Icon(
                        Icons.Default.Search, contentDescription = "Buscar",
                        tint = MaterialTheme.colorScheme.tertiary
                    )
                }
            }
        },
        scrollBehavior = scrollBehavior,
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = MaterialTheme.colorScheme.primary,
            titleContentColor = Color.White
        )
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun TopBarPreview() {
    OrixaSearchTopBar(
        modifier = Modifier,
        scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior(),
        onFilterClick = {})

}