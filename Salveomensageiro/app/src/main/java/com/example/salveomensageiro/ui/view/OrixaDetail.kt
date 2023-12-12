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
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel


@Composable
fun DetailCard(
    orixaId: Int,
    modifier: Modifier = Modifier
) {
    val orixasViewModel: OrixViewModel = viewModel()
    Card(
        modifier = Modifier
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .padding(8.dp)
        ) {
            OrixasDetailCard(modifier, orixaId, orixasViewModel)
        }
    }
}

@Composable
fun OrixasDetailCard(
    modifier: Modifier = Modifier,
    orixaId: Int = 0,
    orixasViewModel: OrixViewModel
) {


    val orixa = orixasViewModel.orixáSelecionado.value
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(8.dp),
        modifier = modifier.padding(8.dp)
    ) {
        orixa?.let { orixa ->
            Spacer(modifier = modifier.padding(8.dp))
            OrixaImage(
                imageUrl = orixa.imageUrl,
                contentDescription = null,
                modifier = modifier.size(220.dp)
            )
            Text(
                text = stringResource(id = orixaId),
                style = MaterialTheme.typography.titleLarge,
                color = MaterialTheme.colorScheme.secondary,
                modifier = modifier.padding(top = 8.dp),
                textAlign = TextAlign.Center
            )
            Text(
                text = orixa.day,
                modifier.padding(top = 8.dp),
                textAlign = TextAlign.Center,
                color = MaterialTheme.colorScheme.secondary,
            )
            Text(
                text = orixa.color,
                modifier.padding(top = 8.dp),
                textAlign = TextAlign.Center,
                color = MaterialTheme.colorScheme.secondary,
            )
            Text(
                text = orixa.symbols,
                modifier.padding(top = 8.dp),
                textAlign = TextAlign.Center,
                color = MaterialTheme.colorScheme.secondary,
            )
            Text(
                text = orixa.elements,
                modifier.padding(top = 8.dp),
                textAlign = TextAlign.Center,
                color = MaterialTheme.colorScheme.secondary,
            )
            Text(
                text = orixa.know,
                modifier.padding(top = 8.dp),
                textAlign = TextAlign.Center,
                color = MaterialTheme.colorScheme.secondary,
            )
            Text(
                text = orixa.greetings,
                modifier.padding(top = 8.dp),
                textAlign = TextAlign.Center,
                color = MaterialTheme.colorScheme.secondary,
            )
        }
    }
}


//@Preview
//@Composable
//fun DetailPreview() {
//    OrixasDetailCard(
//        orixasDetail = Orixas(
//            R.string.ewa,
//            R.drawable.ewa,
//            "Sábado",
//            "Vermelho Vivo, Coral e Rosa, amarelo",
//            "Lira, arpão, Ofá",
//            "Florestas, Céu Rosado, Astros e Estrelas, mata virgem",
//            "Beleza, Vidência (sensibilidade, sexto sentido), Criatividade, possibilidades",
//            "Ri Ro Ewá!"
//        )
//    )
//}


