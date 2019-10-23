package com.example.desafiolemobsrefatorado.Retrofit

import com.example.desafiolemobsrefatorado.Classes.LivroDataResponse
import retrofit2.Response
import retrofit2.http.GET


interface ApiService {

    @GET("products.json")
    suspend fun getLivro(): Response<List<LivroDataResponse>>
}