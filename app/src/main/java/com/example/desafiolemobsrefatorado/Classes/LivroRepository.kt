package com.example.desafiolemobsrefatorado.Classes

import com.example.desafiolemobsrefatorado.Retrofit.ApiService

class LivroRepository (val apiService: ApiService) {

    suspend fun getListaLivro() : List<Livro> {

        val response = apiService.getLivro()

        var livros: List<Livro>? = listOf()


        if (response.isSuccessful) {
            val listagem = response.body()

            livros = listagem?.map {
                Livro(
                    it.title ?: "",
                    it.price ?: 0 ,
                    it.writer ?: "",
                    it.thumbnailHd ?: "",
                    it.date ?: ""
                )
            }
        }
        return livros ?: listOf()
    }

}