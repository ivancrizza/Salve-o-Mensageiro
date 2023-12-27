package com.example.salveomensageiro.ui.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.salveomensageiro.data.Orixa
import com.example.salveomensageiro.ui.viewmodel.OrixaViewmodelState
import com.example.salveomensageiro.ui.viewmodel.OrixasViewmodel


@Composable
fun DetailCard(
    orixasViewmodel: OrixasViewmodel,
    index: Int,
    navController: NavController
) {
    val orixas = orixasViewmodel.state.collectAsState()
    val orixaName = when (val state = orixas.value) {
        is OrixaViewmodelState.GetOrixas -> state.orixa.getOrNull(index)?.name ?: ""
        else -> ""
    }
    Scaffold(
        topBar = {
            OrixaTopBar(title = orixaName, navController = navController)
        }
    ) { paddingValues ->
        Card(
            modifier = Modifier.padding(top = paddingValues.calculateTopPadding()),
            colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.secondary),
            border = CardDefaults.outlinedCardBorder(false),
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
            ) {
                OrixasDetailCard(orixasViewmodel, index = index)
            }
        }
    }


}

@Composable
fun OrixasDetailCard(
    orixasViewmodel: OrixasViewmodel,
    index: Int
) {

    val orixas = orixasViewmodel.state.collectAsState()
    when (val state = orixas.value) {
        is OrixaViewmodelState.GetOrixas -> SetDetailOrixa(orixa = state.orixa[index])
        else -> {}
    }


}

@Composable
private fun SetDetailOrixa(
    modifier: Modifier = Modifier,
    orixa: Orixa
) {
    val color = Color.White
    Box(
        modifier = modifier

    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(8.dp),
            modifier = modifier
                .fillMaxHeight()
        ) {
            Spacer(modifier = modifier.padding(8.dp))
            OrixaImage(
                imageUrl = orixa.imageUrl,
                contentDescription = null,
                modifier = modifier.size(220.dp)
            )
            Text(
                text = orixa.name,
                style = MaterialTheme.typography.titleLarge,
                color = color,
                modifier = modifier.padding(top = 8.dp),
                textAlign = TextAlign.Center
            )
            Text(
                text = orixa.day,
                modifier.padding(top = 8.dp),
                textAlign = TextAlign.Center,
                color = color,
            )
            Text(
                text = orixa.color,
                modifier.padding(top = 8.dp),
                textAlign = TextAlign.Center,
                color = color,
            )
            Text(
                text = orixa.symbols,
                modifier.padding(top = 8.dp),
                textAlign = TextAlign.Center,
                color = color,
            )
            Text(
                text = orixa.elements,
                modifier.padding(top = 8.dp),
                textAlign = TextAlign.Center,
                color = color,
            )
            Text(
                text = orixa.know,
                modifier.padding(top = 8.dp),
                textAlign = TextAlign.Center,
                color = color,
            )
            Text(
                text = orixa.greetings,
                modifier.padding(top = 8.dp),
                textAlign = TextAlign.Center,
                color = color,
            )

        }
    }

}


@Preview
@Composable
fun DetailPreview() {
    val orixa = Orixa(
        name = "Nanã",
        imageUrl = "https://ocandomble.files.wordpress.com/2008/04/nana.jpg?w=216&h=300",
        day = "Dia: Terça-feira",
        color = "Cores: Anil, Branco e Roxo",
        symbols = "Símbolo: Bastão de hastes de palmeira (Ibiri)",
        elements = "Elemento: Terra, Água, Lodo",
        know = "Domínios: Vida e Morte, Saúde e Maternidade",
        greetings = "Saudação: Salubá!"
    )
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(8.dp),
        modifier = Modifier.padding(8.dp)
    ) {
        Spacer(modifier = Modifier.padding(8.dp))
        OrixaImage(
            imageUrl = orixa.imageUrl,
            contentDescription = null,
            modifier = Modifier.size(220.dp)
        )
        Text(
            text = orixa.name,
            style = MaterialTheme.typography.titleLarge,
            color = MaterialTheme.colorScheme.secondary,
            modifier = Modifier.padding(top = 8.dp),
            textAlign = TextAlign.Center
        )
        Text(
            text = orixa.day,
            Modifier.padding(top = 8.dp),
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.bodyLarge,
            color = MaterialTheme.colorScheme.secondary,
        )
        Text(
            text = orixa.color,
            Modifier.padding(top = 8.dp),
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.bodyLarge,
            color = MaterialTheme.colorScheme.secondary,
        )
        Text(
            text = orixa.symbols,
            Modifier.padding(top = 8.dp),
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.bodyLarge,
            color = MaterialTheme.colorScheme.secondary,
        )
        Text(
            text = orixa.elements,
            Modifier.padding(top = 8.dp),
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.bodyLarge,
            color = MaterialTheme.colorScheme.secondary,
        )
        Text(
            text = orixa.know,
            Modifier.padding(top = 8.dp),
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.bodyLarge,
            color = MaterialTheme.colorScheme.secondary,
        )
        Text(
            text = orixa.greetings,
            Modifier.padding(top = 8.dp),
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.bodyLarge,
            color = MaterialTheme.colorScheme.secondary,
        )

    }
}


