package com.pf.login_senha

import android.content.Intent
import android.os.Bundle
import android.view.MotionEvent
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Login : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_login)


        val login = findViewById<EditText>(R.id.login)
        login.setOnFocusChangeListener { v, hasFocus ->
            if (hasFocus) {
                login.setBackgroundColor(getColor(android.R.color.transparent))
            }
        }

        val senha = findViewById<EditText>(R.id.senha)
        senha.setOnFocusChangeListener { v, hasFocus ->
            if (hasFocus){
                senha.setBackgroundColor(getColor(android.R.color.transparent))
            }
        }

        val listaPessoas = mutableListOf(
            Pessoa("João Silva", "joao.silva", "senha123", 30),
            Pessoa("Maria Oliveira", "maria.oliveira", "minhasenha", 25),
            Pessoa("Carlos Souza", "carlos.souza", "seguranca123", 28)
        )

        val entrar = findViewById<Button>(R.id.entrar)

        entrar.setOnClickListener {
            var hasError = false
            val inputLogin = login.text.toString()
            val inputSenha = senha.text.toString()

            val usuarioEncontrado = listaPessoas.find { it.login == inputLogin }

            if (usuarioEncontrado == null) {
                login.setBackgroundColor(getColor(R.color.vermelho))
                login.setText("")
                senha.setBackgroundColor(getColor(android.R.color.transparent))
                senha.setText("")
                hasError = true
            } else {
                login.setBackgroundColor(getColor(android.R.color.transparent))
                if (usuarioEncontrado.senha != inputSenha) {

                    senha.setBackgroundColor(getColor(R.color.vermelho))
                    senha.setText("")
                    hasError = true
                } else {

                    senha.setBackgroundColor(getColor(android.R.color.transparent))
                }
            }

            if (!hasError) {
                val intent = Intent(this, saudacao::class.java)

                intent.putExtra("object", usuarioEncontrado)
                startActivity(intent)
            }
        }
    }
}