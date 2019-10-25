package com.example.desafiolemobsrefatorado.Activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.desafiolemobsrefatorado.Adapter.AdapterLivro
import com.example.desafiolemobsrefatorado.Classes.Livro
import com.example.desafiolemobsrefatorado.Classes.LivroRepository
import com.example.desafiolemobsrefatorado.R
import com.example.desafiolemobsrefatorado.Retrofit.RestApi
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.*

class MainActivity : AppCompatActivity() {

//    var model :MyViewModel]?
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val model : MainViewModel = ViewModelProviders.of(this)[MainViewModel::class.java]
        val repository: LivroRepository = LivroRepository(RestApi.getLivroService())
        var livros : List<Livro> = listOf()

        request(livros, repository, model)

    }

    fun request(livros : List<Livro>, repository : LivroRepository, model : MainViewModel){

        var livro = livros

        CoroutineScope(Dispatchers.IO).launch {
            livro = repository.getListaLivro()
            runOnUiThread {
                model.listaLivro.observe(this, Observer<List<Livro>>{ listaLivro ->
                    inicializa(livros)
                })

            }
        }

    }

    private fun inicializa(livros : List<Livro>){
        recyclerLivros.layoutManager = LinearLayoutManager(this)
        recyclerLivros.setHasFixedSize(true)
        recyclerLivros.adapter = AdapterLivro(livros, this.applicationContext)
    }

}

