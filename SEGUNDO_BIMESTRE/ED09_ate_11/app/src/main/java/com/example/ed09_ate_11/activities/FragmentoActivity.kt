package com.example.ed09_ate_11.activities

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.example.ed09_ate_11.R
import com.example.ed09_ate_11.databinding.ActivityFragmentoBinding
import com.example.ed09_ate_11.fragments.Tela1Fragment
import com.example.ed09_ate_11.fragments.Tela2Fragment
import com.example.ed09_ate_11.fragments.Tela3Fragment
import com.example.ed09_ate_11.fragments.Tela4Fragment

class FragmentoActivity : AppCompatActivity(){
    private lateinit var mBinding: ActivityFragmentoBinding

    private lateinit var mTela1Fragment: Tela1Fragment
    private lateinit var mTela2Fragment: Tela2Fragment
    private lateinit var mTela3Fragment: Tela3Fragment
    private lateinit var mTela4Fragment: Tela4Fragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_fragmento)

        // Cria os fragmentos
        mTela1Fragment = Tela1Fragment.newInstance()
        mTela2Fragment = Tela2Fragment.newInstance(/*"Luigi Mario", "luigi@gmail.com"*/)
        mTela3Fragment = Tela3Fragment.newInstance()
        mTela4Fragment = Tela4Fragment.newInstance()

        // Carrega o primeiro fragmento no container vazio
        trocarFragmento(mTela1Fragment)

        // Cadastra os eventos da bottom navigation para trocar de fragmento
        mBinding.fragmentoBtmNavigation.setOnItemSelectedListener(::onSelectedBottomNavigationItem)
    }

    private fun onSelectedBottomNavigationItem(menuItem: MenuItem): Boolean {
        when (menuItem.itemId) {
            R.id.action_tela1 -> trocarFragmento(mTela1Fragment)
            R.id.action_tela2 -> trocarFragmento(mTela2Fragment)
            R.id.action_tela3 -> trocarFragmento(mTela3Fragment)
            R.id.action_tela4 -> trocarFragmento(mTela4Fragment)
        }
        return true
    }

    /**
     * Função para realizar a troca dinâmica dos fragmentos.
     */
    private fun trocarFragmento(fragmento: Fragment) {
        val fragmentTransaction: FragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_NONE)
        fragmentTransaction.replace(R.id.fragmento_container, fragmento)
        fragmentTransaction.commit()
    }
}
