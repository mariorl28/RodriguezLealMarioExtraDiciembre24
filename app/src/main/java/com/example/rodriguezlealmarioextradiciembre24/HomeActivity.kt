package com.example.rodriguezlealmarioextradiciembre24

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)


        val calculatorButton: ImageButton = findViewById(R.id.calculatorButton)
        calculatorButton.setOnClickListener {
            val intent = Intent(this, CalculadoraActivity::class.java)
            startActivity(intent)
        }


        val agendaButton: Button = findViewById(R.id.agendaButton)
        agendaButton.setOnClickListener {
            val intent = Intent(this, AgendaActivity::class.java)
            startActivity(intent)
        }

        val notaButton: Button = findViewById(R.id.notaButton)
        notaButton.setOnClickListener{
            val intent = Intent(this, NotaActivity::class.java)
            startActivity(intent)
        }
    }
}