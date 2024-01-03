package com.example.salveomensageiro.ui.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.salveomensageiro.R
import com.example.salveomensageiro.data.Orixa
import com.example.salveomensageiro.ui.viewmodel.OrixaViewmodelState
import com.example.salveomensageiro.ui.viewmodel.OrixasViewmodel

enum class OrixaDetailType(val type: String) {
    DIA("Dia: "),
    COR("Cor: "),
    SIMBOLO("Símbolos: "),
    ELEMENTO("Elemento: "),
    DOMINIO("Domínio: "),
    SAUDACAO("Saudação: ")
}

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
        Box(
            modifier = Modifier
                .padding(top = paddingValues.calculateTopPadding())
                .fillMaxWidth()
                .background(MaterialTheme.colorScheme.secondary),
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
    val color = MaterialTheme.colorScheme.tertiary
    val padding8Dp = Modifier.padding(top = 8.dp)
    val styleLarge = MaterialTheme.typography.titleLarge
    val styleBodyLarge = MaterialTheme.typography.bodyLarge
    val textAlignCenter = TextAlign.Center
    Box(
        modifier = modifier
            .fillMaxSize()
            .padding(top = 8.dp),
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
            Text(
                text = orixa.name,
                modifier = padding8Dp,
                color = color,
                style = styleLarge,
                textAlign = textAlignCenter
            )
            OrixaText(
                title = OrixaDetailType.DIA.type,
                name = orixa.day,
                modifier = padding8Dp,
                color = color,
                style = styleBodyLarge,
                textAlign = textAlignCenter
            )
            OrixaText(
                title = OrixaDetailType.COR.type,
                name = orixa.color,
                modifier = padding8Dp,
                color = color,
                style = styleBodyLarge,
                textAlign = textAlignCenter
            )
            OrixaText(
                title = OrixaDetailType.SIMBOLO.type,
                name = orixa.symbols,
                modifier = padding8Dp,
                color = color,
                style = styleBodyLarge,
                textAlign = textAlignCenter
            )
            OrixaText(
                title = OrixaDetailType.ELEMENTO.type,
                name = orixa.elements,
                modifier = padding8Dp,
                color = color,
                style = styleBodyLarge,
                textAlign = textAlignCenter
            )
            OrixaText(
                title = OrixaDetailType.DOMINIO.type,
                name = orixa.know,
                modifier = padding8Dp,
                color = color,
                style = styleBodyLarge,
                textAlign = textAlignCenter
            )
            OrixaText(
                title = OrixaDetailType.SAUDACAO.type,
                name = orixa.greetings,
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
    title: String = "",
    name: String,
    modifier: Modifier = Modifier,
    color: Color,
    style: TextStyle,
    textAlign: TextAlign
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(end = 8.dp, start = 8.dp),
        horizontalArrangement = Arrangement.Absolute.Center,
        verticalAlignment = Alignment.Top
    ) {
        Text(
            modifier = Modifier.weight(0.4f),
            textAlign = TextAlign.Justify,
            text = title,
            fontWeight = FontWeight.Bold,
            fontSize = 16.sp
        )
        Text(
            text = name,
            modifier = Modifier.weight(1f),
            color = color,
            style = style,
            textAlign = TextAlign.Justify
        )
    }

}


@Preview(name = "Detalhe do Orixa")
@Composable
fun DetailPreview() {
    val orixa = Orixa(
        name = "Nanã",
        imageUrl = "https://ocandomble.files.wordpress.com/2008/04/nana.jpg?w=216&h=300",
        day = "Terça-feira",
        color = "Anil, Branco e Roxo",
        symbols = "Bastão de hastes de palmeira (Ibiri)",
        elements = "Terra, Água, Lodo",
        know = "Vida e Morte, Saúde e Maternidade",
        greetings = "Salubá!"
    )
    val modifier: Modifier = Modifier
    val color = Color.White
    val padding8Dp = Modifier.padding(top = 8.dp)
    val styleLarge = MaterialTheme.typography.titleLarge
    val styleBodyLarge = MaterialTheme.typography.bodyLarge
    val textAlignCenter = TextAlign.Start
    Box(
        modifier = modifier
            .fillMaxSize()

    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(8.dp),
        ) {
            Spacer(modifier = modifier.padding(8.dp))
            OrixaImage(
                imageUrl = orixa.imageUrl,
                contentDescription = null,
                modifier = modifier.size(220.dp)
            )
            Text(
                text = orixa.name,
                modifier = padding8Dp,
                color = color,
                style = styleLarge,
                textAlign = textAlignCenter
            )
            Spacer(modifier = modifier.padding(8.dp))
            OrixaText(
                title = OrixaDetailType.DIA.type,
                name = orixa.day,
                modifier = padding8Dp,
                color = color,
                style = styleBodyLarge,
                textAlign = textAlignCenter
            )
            OrixaText(
                title = OrixaDetailType.COR.type,
                name = orixa.color,
                modifier = padding8Dp,
                color = color,
                style = styleBodyLarge,
                textAlign = textAlignCenter
            )
            OrixaText(
                title = OrixaDetailType.SIMBOLO.type,
                name = orixa.symbols,
                modifier = padding8Dp,
                color = color,
                style = styleBodyLarge,
                textAlign = textAlignCenter
            )
            OrixaText(
                title = OrixaDetailType.ELEMENTO.type,
                name = orixa.elements,
                modifier = padding8Dp,
                color = color,
                style = styleBodyLarge,
                textAlign = textAlignCenter
            )
            OrixaText(
                title = OrixaDetailType.DOMINIO.type,
                name = orixa.know,
                modifier = padding8Dp,
                color = color,
                style = styleBodyLarge,
                textAlign = textAlignCenter
            )
            OrixaText(
                title = OrixaDetailType.SAUDACAO.type,
                name = orixa.greetings,
                modifier = padding8Dp,
                color = color,
                style = styleBodyLarge,
                textAlign = textAlignCenter
            )
        }
    }
}


