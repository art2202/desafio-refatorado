package com.example.desafiolemobsrefatorado.Activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import com.example.desafiolemobsrefatorado.Classes.Livro
import com.example.desafiolemobsrefatorado.Classes.LivroDataResponse
import com.example.desafiolemobsrefatorado.Classes.LivroRepository
import com.example.desafiolemobsrefatorado.R
import com.example.desafiolemobsrefatorado.Retrofit.RestApi
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {


    private var recyclerView: RecyclerView? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var repository: LivroRepository = LivroRepository(RestApi.getLivroService())

        var livros : List<Livro>

        inicializa()

        CoroutineScope(Dispatchers.IO).launch {

            livros = repository.getListaLivro()


        }


    }
    private fun inicializa(){
        recyclerView = findViewById(R.id.recyclerView)
    }


}

