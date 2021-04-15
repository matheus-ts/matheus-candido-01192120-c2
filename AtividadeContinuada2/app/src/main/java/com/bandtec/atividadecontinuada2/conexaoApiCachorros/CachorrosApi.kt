package com.bandtec.atividadecontinuada2.conexaoApiCachorros

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface CachorrosApi {

    @GET("cachorros")
    fun get(): Call<List<Cachorro>>

    @GET("cachorros/{id}")
    fun get(@Path("id")id: Int): Call<Cachorro>
}