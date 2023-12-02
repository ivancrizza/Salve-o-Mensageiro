package com.example.salveomensageiro.ui

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.compose.AsyncImagePainter
import coil.request.ImageRequest
import com.example.salveomensageiro.OrixaImage
import com.example.salveomensageiro.R
import com.example.salveomensageiro.data.Orixas


@Composable
fun DetailCard(
    name: String?,
    orixaInfo: Orixas,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = Modifier
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


@Preview
@Composable
fun DetailPreview() {
}


