package com.example.camp.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.camp.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        /*val textRegister = findViewById<AppCompatTextView>(R.id.text_register)

        textRegister.setOnClickListener {
            //TODO: implementar
            Toast.makeText(this, "Novo registro de usuário", Toast.LENGTH_SHORT).show()
        }*/
    }
}