package com.example.ed09_ate_11.fragments

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.ed09_ate_11.R
import com.example.ed09_ate_11.constantes.TAG
import com.example.ed09_ate_11.databinding.FragmentTela01Binding
import com.example.ed09_ate_11.models.Criador
import com.example.ed09_ate_11.models.Filmes
import com.example.ed09_ate_11.models.Response
import com.example.ed09_ate_11.network.NetworkManager
import com.example.ed09_ate_11.widgets.adapters.FilmesRecyclerAdapter
import retrofit2.Call
import retrofit2.Callback


class Tela1Fragment : Fragment() {


    private lateinit var mBinding: FragmentTela01Binding

    // Lista com todos os Filmes

    private var mFilmes: MutableList<Filmes> = mutableListOf()


    // Controle da paginação do webservice
    private var mPagina = 1

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inicialização usando DataBinding
        mBinding = FragmentTela01Binding.inflate(inflater, container, false)
        return mBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // -- Configuração do recycler view
        // Define o gerenciador de layout do recycler vi

        mBinding.filmesRecycler.layoutManager = LinearLayoutManager(activity)

        // Carrega o adaptador do recycler view
        // - Primeiro parametro: lista com os filmes
        // - Segundo parametro: implementação dos eventos dos itens do recycler view
        mBinding.filmesRecycler.adapter = FilmesRecyclerAdapter(
            mFilmes,
            object : FilmesRecyclerAdapter.Evento {
                override fun onCompartilharClick(filmes : Filmes) {
                    this@Tela1Fragment.onCompartilharClick(filmes)
                }

                override fun onFilmesClick(filmes : Filmes) {
                    this@Tela1Fragment.onSelecionarFilmeClick(filmes)
                }
            }
        )

        // Captura o evento de scroll para carregar mais itens na página
        mBinding.filmesRecycler.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)

                // Se não for mais possível realizar o scroll para baixo, chama o webservice
                if (!recyclerView.canScrollVertically(1)) { //1 for down
                    carregarFilmes()
                }
            }
        })

        // -- Webservice
        // Cria a chamada para o endpoint do webservice
        carregarFilmes()
    }

    private fun onSelecionarFilmeClick(filmes : Filmes) {
        // Cria a caixa de alerta
        val alerta = AlertDialog.Builder(requireContext())
            .setTitle("Criador")
            .setMessage(filmes.criador?.name)
            .setPositiveButton(R.string.app_ok) { dialog, i ->
                // Ação ao selecionar o botão de ok!
                dialog.dismiss()
            }
            .setNegativeButton(R.string.app_nao) { dialog, i ->
                // Ação ao selecionar o botão de não!
                dialog.dismiss()
            }
            .create()

        // Exibe a caixa de alerta
        alerta.show()
    }

    override fun onStop() {
        super.onStop()

        // Termina todos as chamadas de webservice
        NetworkManager.stop()
    }

    /**
     * Chama o webservice para carregar mais filmes.
     */
    private fun carregarFilmes() {
        Log.d(TAG, "carregarFilmes: ")

        // Verifica se chegou na última página
        if (mPagina < 0) {
            Log.i(TAG, "carregarFilmes: Última página - sem dados para carregar")
            return
        }

        Log.d(TAG, "carregarFilmes: Carregando dados da página $mPagina")
        val call = NetworkManager.service.listarFilmes(mPagina)

        // Enfileira a execução do webservice e trata a resposta
        call.enqueue(object : Callback<Response<Filmes>> {

            // Retorno de sucesso
            override fun onResponse(
                call: Call<Response<Filmes>>,
                response: retrofit2.Response<Response<Filmes>>
            ) {
                onResponseSuccess(response.body())
            }

            // Retorno de falha
            override fun onFailure(call: Call<Response<Filmes>>, t: Throwable) {
                Log.e(TAG, "onFailure: ", t)
                if (context != null) {
                    Toast.makeText(context, t.message, Toast.LENGTH_LONG).show()
                }
            }
        })
    }

    /**
     * Função para tratar a mensagem de sucesso do webservice.
     */
    private fun onResponseSuccess(body: Response<Filmes>?) {
        Log.d(TAG, "onResponseSuccess: ")

        // Atualiza qual é a próxima página a ser carregada
        // - Se for a última página, invalida o contador de páginas para evitar novas chamadas
        // - Senão, atualiza o contador de páginas
        if (body?.info?.next == null) {
            mPagina = -1
        } else {
            mPagina++
        }

        // Adiciona os resultados obtidos na lista de filmes
        if (body?.resultados != null) {
            // Recupera o range da lista
            val ini = mFilmes.size
            val qtd = mFilmes.size + body.resultados.size

            // Concatena as duas listas
            mFilmes.addAll(body.resultados)
            Log.d(TAG, "onResponseSuccess: ${mFilmes.size}")

            // Atualiza o recycler view
            Log.d(TAG, "onResponseSuccess: Atualizando adapter")
            Log.d(TAG, "onResponseSuccess: ${mBinding.filmesRecycler.adapter}")
            mBinding.filmesRecycler.adapter?.notifyItemRangeInserted(ini, qtd)

            // Esconde a tela de loading e exibe o recycler
            mBinding.filmesRecycler.visibility = View.GONE
            mBinding.filmesRecycler.visibility = View.VISIBLE
        }
    }

    /**
     * Executa a ação de compartilhar um filme.
     */
    fun onCompartilharClick(filmes: Filmes) {
        val intent = Intent().apply {
            action = Intent.ACTION_SEND
            type = "text/plain"
            putExtra(Intent.EXTRA_TEXT, "${filmes.name}: ${filmes.images?.large}")
        }
        startActivity(Intent.createChooser(intent, getText(R.string.filmes_chooser)))
    }

    // Para construir um fragmento, usamos o padrão builder
    // Ele permite que todos os fragmentos sejam criados de maneira uniforme, padroniza
    //  a passagem de parametros

    /** Função estática para a construção dos fragmentos */
    companion object {
        @JvmStatic
        fun newInstance() = Tela1Fragment()
    }
}