package com.example.ed09_ate_11.network

import com.example.ed09_ate_11.models.Criador
import com.example.ed09_ate_11.models.Filmes
import com.example.ed09_ate_11.models.Response
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query


/**
 * Interface que mapeia todos os endpoints da API
 */
interface ApiService {

    @GET("items")
    fun listarFilmes(@Query("page") pagina: Int): Call<Response<Filmes>>

   /* @GET("items")
    fun listarCriador(@Query("page") pagina: Int): Call<Response<Criador>>*/
}