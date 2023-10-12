package com.example.salveomensageiro

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.salveomensageiro.data.Orixas


@Composable
private fun OrixaCollectionList(
    orixasList: List<Orixas>,
    onOrixasClick: (Long) -> Unit,
    modifier: Modifier = Modifier
) {
    Box(modifier) {
        OrixasLazyList(orixasList, onOrixasClick)
    }

}

@Composable
fun ItemOrixa(
    orixa: Orixas,
    onSnackClick: (Long) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .clickable(onClick = { onSnackClick(orixa.id) })
            .padding(8.dp)
    ) {
        OrixaImage(
            imageUrl = orixa.imageUrl,
            contentDescription = null,
            modifier = modifier.size(120.dp)
        )
        Text(
            text = orixa.name,
            style = MaterialTheme.typography.labelLarge,
            color = MaterialTheme.colorScheme.secondary,
            modifier = modifier.padding(top = 8.dp)
        )
    }
}


@Composable
fun OrixaImage(
    imageUrl: String,
    contentDescription: String?,
    modifier: Modifier = Modifier
) {

    AsyncImage(
        model = ImageRequest.Builder(LocalContext.current)
            .data(imageUrl)
            .crossfade(true)
            .build(),
        contentDescription = contentDescription,
        modifier = modifier.fillMaxSize(),
        contentScale = ContentScale.Crop
    )
}


@Composable
private fun OrixasLazyList(
    orixas: List<Orixas>,
    onOrixasClick: (Long) -> Unit
) {
    LazyColumn {
        items(orixas) { orixas ->
            ItemOrixa(orixa = orixas, onSnackClick = onOrixasClick)
        }
    }

}