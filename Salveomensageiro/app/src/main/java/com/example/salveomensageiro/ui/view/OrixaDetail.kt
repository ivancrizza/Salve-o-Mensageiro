package com.example.salveomensageiro.ui.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.salveomensageiro.R
import com.example.salveomensageiro.data.OrixasDetail


@Composable
fun DetailCard(
    modifier: Modifier = Modifier,
    orixasDetail: OrixasDetail
) {
    Card(
        modifier = Modifier
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .padding(8.dp)
        ) {
            OrixasDetailCard(modifier, orixasDetail)


        }
    }
}

@Composable
fun OrixasDetailCard(
    modifier: Modifier = Modifier,
    orixasDetail: OrixasDetail
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(8.dp),
        modifier = modifier.padding(8.dp)
    ) {
        Spacer(modifier = modifier.padding(8.dp))
        OrixaImage(
            imageUrl = orixasDetail.imageUrl,
            contentDescription = null,
            modifier = modifier.size(220.dp)
        )
        Text(
            text = stringResource(id = orixasDetail.name),
            style = MaterialTheme.typography.titleLarge,
            color = MaterialTheme.colorScheme.secondary,
            modifier = modifier.padding(top = 8.dp),
            textAlign = TextAlign.Center
        )
        Text(
            text = orixasDetail.day,
            modifier.padding(top = 8.dp),
            textAlign = TextAlign.Center,
            color = MaterialTheme.colorScheme.secondary,
        )
        Text(
            text = orixasDetail.color,
            modifier.padding(top = 8.dp),
            textAlign = TextAlign.Center,
            color = MaterialTheme.colorScheme.secondary,
        )
        Text(
            text = orixasDetail.symbols,
            modifier.padding(top = 8.dp),
            textAlign = TextAlign.Center,
            color = MaterialTheme.colorScheme.secondary,
        )
        Text(
            text = orixasDetail.elements,
            modifier.padding(top = 8.dp),
            textAlign = TextAlign.Center,
            color = MaterialTheme.colorScheme.secondary,
        )
        Text(
            text = orixasDetail.know,
            modifier.padding(top = 8.dp),
            textAlign = TextAlign.Center,
            color = MaterialTheme.colorScheme.secondary,
        )
        Text(
            text = orixasDetail.greetings,
            modifier.padding(top = 8.dp),
            textAlign = TextAlign.Center,
            color = MaterialTheme.colorScheme.secondary,
        )
    }

}


@Preview
@Composable
fun DetailPreview() {
    OrixasDetailCard(
        orixasDetail = OrixasDetail(
            1,
            R.drawable.ewa,
            R.string.ewa,
            "Sábado",
            "Vermelho Vivo, Coral e Rosa, amarelo",
            "Lira, arpão, Ofá",
            "Florestas, Céu Rosado, Astros e Estrelas, mata virgem",
            "Beleza, Vidência (sensibilidade, sexto sentido), Criatividade, possibilidades",
            "Ri Ro Ewá!"
        )
    )
}


