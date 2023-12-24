package com.example.salveomensageiro.ui.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.salveomensageiro.data.Orixa
import com.example.salveomensageiro.ui.viewmodel.OrixaViewmodelState
import com.example.salveomensageiro.ui.viewmodel.OrixasViewmodel


@Composable
fun OrixasHome(
    navController: NavHostController,
    modifier: Modifier = Modifier,
    orixasViewmodel: OrixasViewmodel
) {
    val orixas = orixasViewmodel.state.collectAsState().value
    when (val state = orixas) {
        is OrixaViewmodelState.GetOrixas -> SetScafold(modifier, state.orixa, navController)

        else -> {}
    }

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SetScafold(
    modifier: Modifier = Modifier,
    orixasList: List<Orixa>,
    navController: NavHostController
) {
    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()
    Scaffold(
        modifier = modifier.nestedScroll(
            scrollBehavior.nestedScrollConnection
        ),
        topBar = {
            OrixaSearchTopBar(scrollBehavior = scrollBehavior, onFilterClick = {})
        }
    ) { contentPadding ->
        SetHomeCard(
            modifier = modifier.padding(top = contentPadding.calculateTopPadding()),
            orixasList = orixasList,
            navController = navController
        )
    }
}

@Composable
private fun SetHomeCard(
    modifier: Modifier,
    orixasList: List<Orixa>,
    navController: NavHostController
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
            itemsIndexed(orixasList) { index, item ->
                val orixaInfo = Orixa(item.name, item.imageUrl)
                ItemOrixa(
                    orixaInfo = orixaInfo,
                    onItemClick = {
                        navController.navigate("detailCard/${index}")
                    }
                )
            }
        }
    }
}
