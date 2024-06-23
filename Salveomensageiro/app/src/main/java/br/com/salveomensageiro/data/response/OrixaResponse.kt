package br.com.salveomensageiro.data.response

import androidx.compose.runtime.Immutable
import com.google.gson.annotations.SerializedName

@Immutable
data class OrixaResponse(
    @SerializedName("título") val title: String = "",
    @SerializedName("imagem") val image: String = "",
    @SerializedName("dia") val day: String = "",
    @SerializedName("cor") val color: String = "",
    @SerializedName("símbolos") val symbols: String = "",
    @SerializedName("elemento") val element: String = "",
    @SerializedName("domínio") val dominance: String = "",
    @SerializedName("saudações") val salute: String = ""
)