package com.example.salveomensageiro.ui.view

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.gestures.FlingBehavior
import androidx.compose.foundation.gestures.snapping.rememberSnapFlingBehavior
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
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
        is OrixaViewmodelState.GetOrixas -> SetHomeCard(modifier, state.orixa, navController)

        else -> {}
    }

}

@OptIn(ExperimentalFoundationApi::class)
@Composable
private fun SetHomeCard(
    modifier: Modifier,
    orixasList: List<Orixa>,
    navController: NavHostController
) {
    val lazyListState = rememberLazyListState()
    val snapBehavior = rememberSnapFlingBehavior(lazyListState = lazyListState)
    Column(
        modifier = modifier
            .fillMaxHeight()
            .fillMaxHeight()
    ) {
        LazyRow(
            contentPadding = PaddingValues(horizontal = 16.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(top = 100.dp),
            flingBehavior = snapBehavior
        ) {
            itemsIndexed(orixasList) { index, item ->
                val orixaInfo = Orixa(item.name, item.imageUrl)
                ItemOrixa(
                    orixaInfo = orixaInfo,
                    onItemClick = {
                        navController.navigate("detailCard/${index}")
                    },
                    modifier = Modifier.size(width = 300.dp, height = 200.dp)
                )
            }
        }
    }
}
