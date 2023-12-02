package com.example.salveomensageiro

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.salveomensageiro.data.orixas
import com.example.salveomensageiro.navigation.Screen


@Composable
fun ItemOrixa(
    @StringRes name: Int,
    @DrawableRes imageUrl: Int,
    onItemClick: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = Modifier
            .clickable { onItemClick(name.toString()) }
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .padding(8.dp)
        ) {
            OrixaImage(
                imageUrl = imageUrl,
                contentDescription = null,
                modifier = modifier.size(120.dp)
            )
            Text(
                text = stringResource(name),
                style = MaterialTheme.typography.labelLarge,
                color = MaterialTheme.colorScheme.secondary,
                modifier = modifier.padding(top = 8.dp)
            )
        }
    }
}


@Composable
fun OrixaImage(
    @DrawableRes imageUrl: Int,
    contentDescription: String?,
    modifier: Modifier = Modifier
) {

    AsyncImage(
        model = ImageRequest.Builder(LocalContext.current)
            .data(imageUrl)
            .crossfade(true)
            .build(),
        contentDescription = contentDescription,
        modifier = modifier.fillMaxSize()
    )
}

@Composable
fun OrixasHome(
    navController: NavController, modifier: Modifier = Modifier
) {
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
                    name = item.text,
                    imageUrl = item.drawable,
                    onItemClick = { nameId ->
                        navController.navigate(Screen.OrixasDetail.createRoute(nameId))
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
        modifier = Modifier.fillMaxHeight(),
    ) {
        LazyVerticalGrid(
            columns = GridCells.Fixed(3),
            contentPadding = PaddingValues(horizontal = 16.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            items(orixas) { item ->
                ItemOrixa(
                    name = R.string.nana,
                    imageUrl = R.drawable.nana,
                    onItemClick = {
                    }
                )
            }
        }
    }
}

@Preview
@Composable
fun ItemOrixasPreview() {
    Card(
        modifier = Modifier
    ) {
        Column(
            modifier = Modifier
                .padding(8.dp)
        ) {
            OrixaImage(
                imageUrl = R.drawable.nana,
                contentDescription = null,
                modifier = Modifier.size(120.dp)
            )
            Text(
                text = stringResource(R.string.nana),
                style = MaterialTheme.typography.labelLarge,
                color = MaterialTheme.colorScheme.secondary,
                modifier = Modifier.padding(top = 8.dp)
            )
        }
    }
}