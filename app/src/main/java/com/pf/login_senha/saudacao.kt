package com.pf.login_senha

import android.os.Build
import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity

class saudacao : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_saudacao)
        val textView = findViewById<TextView>(R.id.texto)
        val pessoa: Pessoa? = intent.getParcelableExtra("object", Pessoa::class.java)
        textView.text = "${pessoa?.nome}\n${pessoa?.idade}"

    }
}