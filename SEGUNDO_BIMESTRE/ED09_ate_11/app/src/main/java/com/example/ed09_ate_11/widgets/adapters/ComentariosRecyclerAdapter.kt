package br.com.koruthos.rickmorty.widgets.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.ed09_ate_11.databinding.ItemComentariosBinding
import com.example.ed09_ate_11.models.Comentarios
import com.example.ed09_ate_11.models.Filmes

class ComentariosRecyclerAdapter(
    var comentarios: MutableList<Comentarios>,
    var evento: Evento
) : RecyclerView.Adapter<ComentariosRecyclerAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemComentariosBinding.inflate(layoutInflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val comentarios = comentarios[position]
        holder.binding.comentarios = comentarios

        holder.binding.comentariosTxtComentarios.setOnClickListener {
            evento.onComentarioClick(comentarios)
        }

    }

    override fun getItemCount(): Int {
        return comentarios.size
    }

    // =================================================================================
    // EVENTOS
    // =================================================================================

    interface Evento {
        fun onComentarioClick(comentarios: Comentarios )
    }

    // =================================================================================
    // VIEW HOLDER
    // =================================================================================

    data class ViewHolder(var binding: ItemComentariosBinding) :
        RecyclerView.ViewHolder(binding.root)
}