package br.com.koruthos.cursoandroid.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import br.com.koruthos.cursoandroid.databinding.FragmentTela1Binding


class Tela1Fragment : Fragment() {

    private lateinit var mBinding: FragmentTela1Binding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inicialização usando DataBinding
        mBinding = FragmentTela1Binding.inflate(inflater, container, false)
        return mBinding.root
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
