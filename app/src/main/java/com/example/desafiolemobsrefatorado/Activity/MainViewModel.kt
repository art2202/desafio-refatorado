package com.example.desafiolemobsrefatorado.Activity

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.desafiolemobsrefatorado.Classes.Livro
import com.example.desafiolemobsrefatorado.Classes.LivroRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.launch

class MainViewModel(private val livroRepository : LivroRepository) : ViewModel() {

    val listaLivro = MutableLiveData<List<Livro>>()


    init {
        CoroutineScope(Dispatchers.IO).launch {

            listaLivro.postValue(livroRepository.getListaLivro())

        }
    }
}