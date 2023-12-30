package com.example.salveomensageiro.ui.view

import androidx.compose.foundation.layout.Row
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
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OrixaSearchTopBar(
    modifier: Modifier = Modifier,
    scrollBehavior: TopAppBarScrollBehavior,
    onFilterClick: (String) -> Unit,
) {
    val searchText = remember { mutableStateOf("") }
    var showTextField by remember { mutableStateOf(false) }

    Row {

        TopAppBar(
            title = {
                Row(modifier = Modifier.weight(1f)) {
                    Text(
                        text = "Salve o Mensageiro",
                        color = Color.White,
                        maxLines = 1
                    )
                }
            },
            modifier = modifier,
            actions = {
                if (showTextField) {
                    TextField(
                        singleLine = true,
                        value = searchText.value,
                        onValueChange = { searchText.value = it },
                        modifier = Modifier.weight(1f),
                        placeholder = { Text("Buscar", color = Color.White) },
                        trailingIcon = {
                            IconButton(onClick = { onFilterClick(searchText.value) }) {
                                Icon(
                                    Icons.Default.Search, contentDescription = "Buscar",
                                    tint = Color.White
                                )
                            }
                        },
                        colors = TextFieldDefaults.colors(
                            unfocusedTextColor = Color.White,
                            focusedTextColor = Color.White,
                            disabledContainerColor = MaterialTheme.colorScheme.secondary,
                            unfocusedContainerColor = MaterialTheme.colorScheme.secondary,
                            focusedContainerColor = MaterialTheme.colorScheme.secondary
                        )
                    )
                } else {
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
                containerColor = MaterialTheme.colorScheme.secondary,
                titleContentColor = MaterialTheme.colorScheme.secondary
            )
        )
    }
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