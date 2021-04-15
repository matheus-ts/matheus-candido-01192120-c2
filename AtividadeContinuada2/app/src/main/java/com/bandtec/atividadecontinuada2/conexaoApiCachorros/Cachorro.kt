package com.bandtec.atividadecontinuada2.conexaoApiCachorros

data class Cachorro (
    val id: String,
    val raca: String,
    val precoMedio: Int,
    val indicadoCriancas: Boolean
)