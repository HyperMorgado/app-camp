package com.example.camp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.widget.AppCompatTextView
import com.google.android.material.button.MaterialButton

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val textError = findViewById<AppCompatTextView>(R.id.text_error)

        val button = findViewById<MaterialButton>(R.id.button_enter)

        val textRegister = findViewById<AppCompatTextView>(R.id.text_register)

        button.setOnClickListener {
            val intent = Intent(this, BookListActivity::class.java)
            startActivity(intent)
        }

        textRegister.setOnClickListener {
            //TODO: implementar
            Toast.makeText(this, "Novo registro de usuário", Toast.LENGTH_SHORT).show()
        }

    }
}