package com.example.desafiolemobsrefatorado.Retrofit

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory


object RestApi {

    private val retrofit: Retrofit

    fun getLivroService(): ApiService {
        return this.retrofit.create<ApiService>(ApiService::class.java)
    }

    init {

        this.retrofit = Retrofit.Builder()
            .baseUrl("https://raw.githubusercontent.com/Felcks/desafio-mobile-lemobs/master/")
            .addConverterFactory(MoshiConverterFactory.create())
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .build()
    }
}