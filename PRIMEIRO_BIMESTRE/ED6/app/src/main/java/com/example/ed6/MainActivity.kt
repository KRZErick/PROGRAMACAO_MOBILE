package com.example.ed6

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Tchau()
        Ola()
        AbrirImagem()
    }


    private fun Ola(){
        val btn_Ola = findViewById<Button>(R.id.btn_Ola)


        btn_Ola.setOnClickListener{
            val Numero_Telefone = "+5541992818738"
            val Menssagem = "Olá! Sou Android!"
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse("https://wa.me/$Numero_Telefone/?text=$Menssagem")
            startActivity(intent)
        }
    }
    private fun Tchau(){
        val btn_Tchau = findViewById<Button>(R.id.btn_Tchau)


        btn_Tchau.setOnClickListener{
            val Numero_Telefone = "+5541992818738"
            val Menssagem = "Tchau!"

            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse("https://wa.me/$Numero_Telefone/?text=$Menssagem")
            startActivity(intent)
        }
    }


    companion object {
        private const val SELECAO_GALERIA = 200
    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == SELECAO_GALERIA && resultCode == Activity.RESULT_OK && data != null) {
            val uri = data.data
            val imagem = findViewById<ImageView>(R.id.imageView)
            imagem.setImageURI(uri)
        }
    }

    private fun AbrirImagem(){
        val btn_AbrirImagem = findViewById<Button>(R.id.btn_AbrirImagem)
        btn_AbrirImagem.setOnClickListener {
            val intent = Intent(Intent.ACTION_PICK)
            intent.type = "image/*"
            startActivityForResult( intent, SELECAO_GALERIA)
        }
    }
}