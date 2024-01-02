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
import androidx.compose.ui.text.TextStyle
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
            modifier = Modifier
                .padding(top = paddingValues.calculateTopPadding())
                .fillMaxWidth(),
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
    val padding8Dp = Modifier.padding(top = 8.dp)
    val styleLarge = MaterialTheme.typography.titleLarge
    val styleBodyLarge = MaterialTheme.typography.bodyLarge
    val textAlignCenter = TextAlign.Center
    Box(
        modifier = modifier,
        contentAlignment = Alignment.TopCenter

    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(8.dp),
            modifier = modifier
                .fillMaxHeight()
                .padding(horizontal = 12.dp)
                .padding(16.dp)
        ) {
            Spacer(modifier = modifier.padding(8.dp))
            OrixaImage(
                imageUrl = orixa.imageUrl,
                contentDescription = null,
                modifier = modifier.size(220.dp)
            )
            OrixaText(
                orixa.name,
                modifier = padding8Dp,
                color = color,
                style = styleLarge,
                textAlign = textAlignCenter
            )
            OrixaText(
                orixa.day,
                modifier = padding8Dp,
                color = color,
                style = styleBodyLarge,
                textAlign = textAlignCenter
            )
            OrixaText(
                orixa.color,
                modifier = padding8Dp,
                color = color,
                style = styleBodyLarge,
                textAlign = textAlignCenter
            )
            OrixaText(
                orixa.symbols,
                modifier = padding8Dp,
                color = color,
                style = styleBodyLarge,
                textAlign = textAlignCenter
            )
            OrixaText(
                orixa.elements,
                modifier = padding8Dp,
                color = color,
                style = styleBodyLarge,
                textAlign = textAlignCenter
            )
            OrixaText(
                orixa.know,
                modifier = padding8Dp,
                color = color,
                style = styleBodyLarge,
                textAlign = textAlignCenter
            )
            OrixaText(
                orixa.greetings,
                modifier = padding8Dp,
                color = color,
                style = styleBodyLarge,
                textAlign = textAlignCenter
            )
        }
    }
}

@Composable
fun OrixaText(
    name: String,
    modifier: Modifier = Modifier,
    color: Color,
    style: TextStyle,
    textAlign: TextAlign
) {
    Text(
        text = name,
        modifier = modifier,
        color = color,
        style = style,
        textAlign = textAlign
    )
}


@Preview(name = "Detalhe do Orixa")
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
    val modifier : Modifier = Modifier
    val color = Color.White
    val padding8Dp = Modifier.padding(top = 8.dp)
    val styleLarge = MaterialTheme.typography.titleLarge
    val styleBodyLarge = MaterialTheme.typography.bodyLarge
    val textAlignCenter = TextAlign.Center
    Box(
        modifier = modifier,
        contentAlignment = Alignment.TopCenter

    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(8.dp),
            modifier = modifier
                .fillMaxHeight()
                .padding(horizontal = 12.dp)
                .padding(16.dp)
        ) {
            Spacer(modifier = modifier.padding(8.dp))
            OrixaImage(
                imageUrl = orixa.imageUrl,
                contentDescription = null,
                modifier = modifier.size(220.dp)
            )
            OrixaText(
                orixa.name,
                modifier = padding8Dp,
                color = color,
                style = styleLarge,
                textAlign = textAlignCenter
            )
            OrixaText(
                orixa.day,
                modifier = padding8Dp,
                color = color,
                style = styleBodyLarge,
                textAlign = textAlignCenter
            )
            OrixaText(
                orixa.color,
                modifier = padding8Dp,
                color = color,
                style = styleBodyLarge,
                textAlign = textAlignCenter
            )
            OrixaText(
                orixa.symbols,
                modifier = padding8Dp,
                color = color,
                style = styleBodyLarge,
                textAlign = textAlignCenter
            )
            OrixaText(
                orixa.elements,
                modifier = padding8Dp,
                color = color,
                style = styleBodyLarge,
                textAlign = textAlignCenter
            )
            OrixaText(
                orixa.know,
                modifier = padding8Dp,
                color = color,
                style = styleBodyLarge,
                textAlign = textAlignCenter
            )
            OrixaText(
                orixa.greetings,
                modifier = padding8Dp,
                color = color,
                style = styleBodyLarge,
                textAlign = textAlignCenter
            )
        }
    }
}


