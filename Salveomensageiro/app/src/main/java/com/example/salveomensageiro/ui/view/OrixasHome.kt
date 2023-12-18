package com.example.salveomensageiro.ui.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.salveomensageiro.data.Orixas
import com.example.salveomensageiro.data.orixas
import com.example.salveomensageiro.ui.viewmodel.OrixasViewmodel


@Composable
fun OrixasHome(
    navController: NavHostController, modifier: Modifier = Modifier,
    orixasViewmodel: OrixasViewmodel
) {
    Column(
        modifier = modifier
            .fillMaxHeight()
    ) {
        LazyVerticalGrid(
            columns = GridCells.Fixed(3),
            contentPadding = PaddingValues(horizontal = 16.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            modifier = Modifier.padding(top = 16.dp)
        ) {
            items(orixas) { item ->
                val orixaInfo = Orixas(item.text, item.drawable)
                ItemOrixa(
                    orixaInfo = orixaInfo,
                    onItemClick = {
                        orixasViewmodel.setOrixas(orixaInfo)
                        navController.navigate("detailCard/${item.text}")
                    }
                )
            }
        }
    }
}

@Preview
@Composable
fun PreviewHome() {
    Column(
        modifier = Modifier.fillMaxHeight()
    ) {
        LazyVerticalGrid(
            columns = GridCells.Fixed(3),
            contentPadding = PaddingValues(horizontal = 16.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            items(orixas) { item ->
                ItemOrixa(
                    orixaInfo = Orixas(item.text, item.drawable),
                    onItemClick = {
                    }
                )
            }
        }
    }
}