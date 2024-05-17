package br.com.salveomensageiro.ui.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import br.com.salveomensageiro.ui.viewmodel.OrixaViewmodelState
import br.com.salveomensageiro.ui.viewmodel.OrixasViewmodel
import kotlinx.coroutines.launch


@Composable
fun OrixasHome(
    navController: NavHostController,
    modifier: Modifier = Modifier,
    orixasViewmodel: OrixasViewmodel
) {
    val orixas = orixasViewmodel.state.collectAsState().value
    when (val state = orixas) {
        is OrixaViewmodelState.GetOrixas -> SetScafold(
            modifier = modifier,
            orixasList = state.orixa,
            navController = navController,
            orixasViewmodel = orixasViewmodel
        )

        else -> {}
    }

}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SetScafold(
    modifier: Modifier = Modifier,
    orixasList: List<br.com.salveomensageiro.data.Orixa>,
    navController: NavHostController,
    orixasViewmodel: OrixasViewmodel
) {
    val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior()
    Scaffold(

        modifier = modifier.nestedScroll(
            scrollBehavior.nestedScrollConnection
        ),
        topBar = {
            OrixaSearchTopBar(scrollBehavior = scrollBehavior,
                onFilterClick = { searchText ->
                orixasViewmodel.searchOrixaOnClick(searchText)
            }, onResetClick = { orixasViewmodel.resetSearch() })
        },
        containerColor = MaterialTheme.colorScheme.primary
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
    orixasList: List<br.com.salveomensageiro.data.Orixa>,
    navController: NavHostController
) {
    val coroutineScope = rememberCoroutineScope()
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
            itemsIndexed(orixasList, key = { index, _ ->
                index
            }
            ) { index, item ->
                val orixaInfo = br.com.salveomensageiro.data.Orixa(item.name, item.imageUrl)
                ItemOrixa(
                    orixaInfo = orixaInfo,
                    onItemClick = {
                        coroutineScope.launch {
                            navController.navigate("detailCard/${index}")
                        }
                    }
                )
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun HomePreviewWithScafold() {
    val nav = rememberNavController()
    val ls = List(16, init = {
        br.com.salveomensageiro.data.Orixa(
            name = "Yemanjá",
            imageUrl = "https://ocandomble.files.wordpress.com/2008/04/nana.jpg?w=216&h=300"

        )
    })

    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()

}
