package com.example.ed6

import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import java.net.URLEncoder

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    // função para compartilhar uma mensagem via WhatsApp
    fun shareMessageViaWhatsApp(message: String, context: Context) {
        try {
            // codifica a mensagem para que possa ser passada como parâmetro na URI
            val encodedMessage = URLEncoder.encode(message, "UTF-8")
            // cria a URI de compartilhamento com a mensagem como parâmetro
            val uri = Uri.parse("whatsapp://send?text=$encodedMessage")
            // cria um intent para abrir o WhatsApp e compartilhar a mensagem
            val intent = Intent(Intent.ACTION_SEND)
            intent.type = "text/plain"
            intent.putExtra(Intent.EXTRA_TEXT, message)
            intent.setPackage("com.whatsapp")
            intent.data = uri
            // verifica se o WhatsApp está instalado no dispositivo
            if (intent.resolveActivity(context.packageManager) != null) {
                // inicia a atividade de compartilhamento via WhatsApp
                context.startActivity(intent)
            } else {
                // exibe uma mensagem de erro caso o WhatsApp não esteja instalado
                Toast.makeText(context, "O WhatsApp não está instalado", Toast.LENGTH_SHORT).show()
            }
        } catch (e: Exception) {
            // trata possíveis exceções durante a codificação da mensagem ou criação do intent
            e.printStackTrace()
            Toast.makeText(context, "Erro ao compartilhar mensagem", Toast.LENGTH_SHORT).show()
        }
    }

    fun Buttons() {
        val btnOla_click = findViewById<Button>(R.id.btnOla)

        // define um ouvinte de eventos de clique para o botão
        btnOla_click.setOnClickListener {
            // adiciona aqui o código a ser executado quando o botão é clicado
            shareMessageViaWhatsApp("Olá sou eu de novo", this)
            // por exemplo, exibir uma mensagem de log
            Log.d("MeuApp", "O botão foi clicado!")
        }
    }


}