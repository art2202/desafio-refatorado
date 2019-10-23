package com.example.desafiolemobsrefatorado.Activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.desafiolemobsrefatorado.Adapter.AdapterLivro
import com.example.desafiolemobsrefatorado.Classes.Livro
import com.example.desafiolemobsrefatorado.Classes.LivroRepository
import com.example.desafiolemobsrefatorado.R
import com.example.desafiolemobsrefatorado.Retrofit.RestApi
import com.example.desafiolemobsrefatorado.ViewModels.MyViewModel
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.*

class MainActivity : AppCompatActivity() {

    var model :MyViewModel]?
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val repository: LivroRepository = LivroRepository(RestApi.getLivroService())
        var livros : List<Livro> = listOf()

        CoroutineScope(Dispatchers.IO).launch {
            livros = repository.getListaLivro()
            runOnUiThread {
                inicializa(livros)
            }
        }
    }
    private fun inicializa(livros : List<Livro>){
        recyclerLivros.layoutManager = LinearLayoutManager(this)
        recyclerLivros.setHasFixedSize(true)
        recyclerLivros.adapter = AdapterLivro(livros, this.applicationContext)
    }

}

