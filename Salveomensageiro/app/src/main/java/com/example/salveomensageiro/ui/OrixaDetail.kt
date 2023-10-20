package com.example.salveomensageiro.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.salveomensageiro.data.orixas


@Composable
fun DetailCard(imageUrl: String, id: Long, name: String) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(imageUrl)
                    .crossfade(true)
                    .build(),
                contentDescription = null
            )


            Spacer(modifier = Modifier.height(16.dp))

//            Text(
//                text = "ID: $id",
//                style = MaterialTheme.typography.titleLarge
//            )

            Text(
                text = "Nome: $name",
                style = MaterialTheme.typography.titleLarge
            )

            Spacer(modifier = Modifier.height(8.dp))


        }
    }
}

@Composable
fun DetailScreen() {
    val imageUrl = orixas.first().imageUrl
    val id = orixas.first().id
    val name = orixas.first().name

    DetailCard(imageUrl, id, name)
}

@Preview
@Composable
fun DetailPreview() {
    DetailScreen()
}


