package br.com.koruthos.cursoandroid.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import br.com.koruthos.cursoandroid.databinding.FragmentTela1Binding
import br.com.koruthos.cursoandroid.databinding.FragmentTela2Binding

class Tela2Fragment : Fragment() {

    private lateinit var mBinding: FragmentTela2Binding

/*    private var mNome: String = ""
    private var mEmail: String = ""*/

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
/*
        mNome = arguments?.getString(PARAM_NOME)!!
        mEmail = arguments?.getString(PARAM_EMAIL)!!
*/
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inicialização usando DataBinding
        mBinding = FragmentTela2Binding.inflate(inflater, container, false)
        return mBinding.root
    }

/*    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

*//*
        mBinding.tela2TxtNome.text = mNome
        mBinding.tela2TxtEmail.text = mEmail
*//*
    }*/

    // Para construir um fragmento, usamos o padrão builder
    // Ele permite que todos os fragmentos sejam criados de maneira uniforme, padroniza
    //  a passagem de parametros

    /** Função estática para a construção dos fragmentos */
    companion object {

/*
        val PARAM_NOME = "nome"
        val PARAM_EMAIL = "email"
*/

        @JvmStatic
        fun newInstance(/*nome: String, email: String*/) : Tela2Fragment {

            val bundle = Bundle()
/*
            bundle.putString(PARAM_NOME, nome)
            bundle.putString(PARAM_EMAIL, email)
*/

            val fragmento = Tela2Fragment()
            fragmento.arguments = bundle
            return fragmento
        }
    }
}
