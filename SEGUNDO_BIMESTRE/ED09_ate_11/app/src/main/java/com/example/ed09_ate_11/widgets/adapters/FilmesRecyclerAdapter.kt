package com.example.ed09_ate_11.widgets.adapters

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.ed09_ate_11.models.Filmes
import com.example.ed09_ate_11.R
import com.example.ed09_ate_11.constantes.TAG
import com.example.ed09_ate_11.databinding.ItemFilmesBinding
import com.example.ed09_ate_11.models.Criador

class FilmesRecyclerAdapter (
    var filmes: List<Filmes>,
    var evento: FilmesRecyclerAdapter.Evento
) : RecyclerView.Adapter<FilmesRecyclerAdapter.ViewHolder>() {

    /**
     * Carrega o layout que será usado nos itens do recycler view. Cria um
     * view holder para cada item que será usado para armazenar os valores de exibição.
     */
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemFilmesBinding.inflate(layoutInflater, parent, false)
        return ViewHolder(binding)
    }

    /**
     * Preenche os dados do view holder com o elemento correspondente da lista de filmes.
     */
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Log.d(TAG, "onBindViewHolder: ${position}")

        val filme = filmes[position]
        Log.d(TAG, "onBindViewHolder: ${filme.name}")
        Log.d(TAG, "onBindViewHolder: ${holder.binding.filmesTxtNome.text}")

        // Define o filem do viewholder
        // - os dados são atualizados diretamente na tela devido ao databinding
        holder.binding.filmes = filme

        // Cadastra os eventos nos botões
        holder.binding.filmesImgShare.setOnClickListener {
            // Chama o método do evento recebido no construtor passando o filme atual
            evento.onCompartilharClick(filme)
        }

        holder.binding.filmesCardView.setOnClickListener {
            evento.onFilmesClick(filme)
        }

        // Carrega a imagem do filme
        Glide.with(holder.itemView)
            .load(filme.images?.small)
            .centerCrop()
            .placeholder(R.drawable.ic_placeholder)
            .into(holder.binding.filmesImgImagem);
        Log.d(TAG, "Img Filme: ${filme.images?.small}")
    }

    /**
     * Retorna o número de itens da lista.
     */
    override fun getItemCount(): Int {
        //Log.d(TAG, "getItemCount: ${filmes.size}")
        return filmes.size
    }

    // =================================================================================
    // EVENTOS
    // =================================================================================

    /**
     * Definição dos eventos que um item do recycler view pode disparar. A ação executada
     * em cada evento será definida pela classe que criou o recycler view.
     */
    interface Evento {
        fun onCompartilharClick(filmes: Filmes)
        fun onFilmesClick(filmes: Filmes)
    }

    // =================================================================================
    // VIEW HOLDER
    // =================================================================================

    /**
     * Classe do ViewHolder que armazena os itens de layout do recycle view
     */
    data class ViewHolder(var binding: ItemFilmesBinding) :
        RecyclerView.ViewHolder(binding.root)
}