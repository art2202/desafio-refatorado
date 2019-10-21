package com.example.desafiolemobsrefatorado.Classes

import com.example.desafiolemobsrefatorado.Retrofit.ApiService

class LivroRepository (val apiService: ApiService) {

//    private var livro: Livro? = null

    suspend fun getListaLivro() : List<Livro> {

        val response = apiService.getLivro()
        var livros: List<Livro>?

        var returnDefault : List<Livro> = listOf()

        if (response.isSuccessful) {
            val listagem = response.body()

            livros = listagem?.map {
                Livro(
                    it.writer ?: "",
                    it.price ?: 0 ,
                    it.writer ?: "",
                    it.thumbnailHd ?: "",
                    it.date ?: ""
                )
            }

            return livros ?: listOf()


        }

        else if (response.code() == 401){
            println("erro 401")
        }

        else{
            println("ERRO")
        }
        return returnDefault




    }

}