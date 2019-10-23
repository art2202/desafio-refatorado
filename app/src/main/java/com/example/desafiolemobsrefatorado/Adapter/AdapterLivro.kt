package com.example.desafiolemobsrefatorado.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.desafiolemobsrefatorado.Classes.Livro
import com.example.desafiolemobsrefatorado.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_livro.view.*

class AdapterLivro(private val livros : List<Livro>, private val contexto: Context) : RecyclerView.Adapter<AdapterLivro.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(contexto).inflate(R.layout.item_livro , parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return livros.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val book: Livro = livros.get(position)
        
        holder.itemView.textTitulo.setText(book.titulo)
        holder.itemView.textPreco.setText(book.preco.toString())
        holder.itemView.textEscritor.setText(book.escritor)
        holder.itemView.textData.setText(book.data)
        Picasso.with(contexto).load(book.linkImagem).fit().centerInside().into(holder.itemView.Imagem)
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
}