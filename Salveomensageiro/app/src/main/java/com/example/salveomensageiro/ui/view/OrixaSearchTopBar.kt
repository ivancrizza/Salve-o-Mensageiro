package com.example.salveomensageiro.ui.view

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@OptIn(ExperimentalFoundationApi::class, ExperimentalMaterial3Api::class)
@Composable
fun OrixaSearchTopBar(
    modifier: Modifier = Modifier,
    scrollBehavior: TopAppBarScrollBehavior,
    onFilterClick: (String) -> Unit,
) {
    val searchText = remember { mutableStateOf("") }

    CenterAlignedTopAppBar(
        title = { "Salve o Mensageiro" },
        modifier = modifier,
        actions = {
            TextField(
                value = searchText.value,
                onValueChange = { searchText.value = it },
                modifier = Modifier.weight(1f),
                placeholder = { Text("Buscar") },
                trailingIcon = {
                    IconButton(onClick = { onFilterClick(searchText.value) }) {
                        Icon(Icons.Default.Search, contentDescription = "Buscar")
                    }
                }
            )

        },
        scrollBehavior = scrollBehavior
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