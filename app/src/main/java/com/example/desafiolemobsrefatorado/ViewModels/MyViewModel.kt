package com.example.desafiolemobsrefatorado.ViewModels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.desafiolemobsrefatorado.Classes.Livro

class MyViewModel : ViewModel(){

    val livros : MutableLiveData<List<Livro>> = MutableLiveData()
}