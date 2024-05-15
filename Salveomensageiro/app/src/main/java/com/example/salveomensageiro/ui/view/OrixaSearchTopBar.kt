package com.example.salveomensageiro.ui.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import com.example.salveomensageiro.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OrixaSearchTopBar(
    modifier: Modifier = Modifier,
    scrollBehavior: TopAppBarScrollBehavior,
    onFilterClick: (String) -> Unit,
) {
    val searchText = remember { mutableStateOf("") }
    var showTextField by remember { mutableStateOf(false) }

    TopAppBar(
        title = {
            if (showTextField) {
                TextField(
                    singleLine = true,
                    value = searchText.value,
                    onValueChange = { searchText.value = it },
                    placeholder = { Text("Buscar", color = Color.White) },
                    trailingIcon = {
                        IconButton(onClick = { onFilterClick(searchText.value) }) {
                            Icon(
                                Icons.Default.Search, contentDescription = "Buscar",
                                tint = Color.White
                            )
                        }
                    },
                    colors = TextFieldDefaults.colors(),
                    modifier = Modifier.fillMaxWidth()
                )
            } else {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(text = "Salve o Mensageiro",
                        fontFamily = FontFamily.Default
                    )
//                    Image(
//                        contentScale = ContentScale.Inside,
//                        painter = painterResource(id = R.drawable.salvesalve),
//                        contentDescription = "",
//                        modifier = Modifier.weight(1f)
//                    )
                }
            }
        },
        modifier = modifier,
        actions = {
            if (!showTextField) {
                IconButton(onClick = { showTextField = true }) {
                    Icon(
                        Icons.Default.Search, contentDescription = "Buscar",
                        tint = Color.White
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