package com.example.rodriguezlealmarioextradiciembre24

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class NotaActivity :AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nota)

        val titleInput: EditText = findViewById(R.id.etTitle)
        val descriptionInput: EditText = findViewById(R.id.etDescription)
        val saveButton: Button = findViewById(R.id.btnSave)
        var titleOutput: TextView = findViewById(R.id.tvTitle)
        var descriptionOutput: TextView = findViewById(R.id.tvDescription)

        saveButton.setOnClickListener {
            titleOutput.text = titleInput.text.toString()
            descriptionOutput.text = descriptionInput.text.toString()



        }
    }
}