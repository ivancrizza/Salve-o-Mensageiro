package com.example.salveomensageiro.ui.view

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import com.example.salveomensageiro.R
import com.example.salveomensageiro.data.Orixas


@Composable
fun ItemOrixa(
    orixaInfo: Orixas,
    onItemClick: (Int) -> Unit,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = Modifier
            .clickable { onItemClick(orixaInfo.name) }
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .padding(8.dp)
        ) {
            OrixaImage(
                imageUrl = orixaInfo.imageUrl,
                contentDescription = null,
                modifier = modifier.size(120.dp)
            )
            Text(
                text = stringResource(orixaInfo.name),
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
    val painter = rememberAsyncImagePainter(
        model = ImageRequest.Builder(LocalContext.current)
            .data(imageUrl)
            .crossfade(true)
            .build()

    )
    Image(
        painter = painter, contentDescription = contentDescription,
        contentScale = ContentScale.Crop,
        modifier = modifier
            .fillMaxSize()
            .size(220.dp)
            .clip(RoundedCornerShape(16.dp))
    )
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