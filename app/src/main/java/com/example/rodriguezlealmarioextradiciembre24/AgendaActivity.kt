package com.example.rodriguezlealmarioextradiciembre24

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity

class AgendaActivity : AppCompatActivity() {

    private lateinit var listView: ListView
    private lateinit var adapter: ContactAdapter
    private val contacts = mutableListOf<Contact>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_agenda)

        listView = findViewById(R.id.listViewContacts)
        adapter = ContactAdapter(this, contacts)
        listView.adapter = adapter

        val btnAddContact: Button = findViewById(R.id.btnAddContact)

        btnAddContact.setOnClickListener {
            showContactDialog(null)
        }

        listView.setOnItemClickListener { _, _, position, _ ->
            showContactDialog(position)
        }

        listView.setOnItemLongClickListener { _, _, position, _ ->
            showDeleteDialog(position)
            true
        }
    }

    private fun showContactDialog(position: Int?) {
        val dialogView = layoutInflater.inflate(R.layout.dialog_contact, null)
        val etName = dialogView.findViewById<EditText>(R.id.etContactName)
        val etPhone = dialogView.findViewById<EditText>(R.id.etContactPhone)
        val etEmail = dialogView.findViewById<EditText>(R.id.etContactEmail)
        val etAddress = dialogView.findViewById<EditText>(R.id.etContactAddress)
        val etNick = dialogView.findViewById<EditText>(R.id.etContactNick)

        if (position != null) {
            val contact = contacts[position]
            etName.setText(contact.name)
            etPhone.setText(contact.phone)
            etEmail.setText(contact.email)
            etAddress.setText(contact.address)
            etNick.setText(contact.nick)
        }

        AlertDialog.Builder(this)
            .setTitle(if (position == null) "Añadir Contacto" else "Editar Contacto")
            .setView(dialogView)
            .setPositiveButton("Guardar") { _, _ ->
                val name = etName.text.toString()
                val phone = etPhone.text.toString()
                val email = etEmail.text.toString()
                val address = etAddress.text.toString()
                val nick = etNick.text.toString()

                if (name.isNotEmpty() && phone.isNotEmpty()) {
                    if (position == null) {
                        contacts.add(Contact(name, phone, email, address,nick))
                    } else {
                        val contact = contacts[position]
                        contact.name = name
                        contact.phone = phone
                        contact.email = email
                        contact.address = address
                        contact.nick = nick
                    }
                    adapter.notifyDataSetChanged()
                } else {
                    Toast.makeText(this, "El nombre y el teléfono son obligatorios", Toast.LENGTH_SHORT).show()
                }
            }
            .setNegativeButton("Cancelar", null)
            .show()
    }

    private fun showDeleteDialog(position: Int) {
        AlertDialog.Builder(this)
            .setTitle("Eliminar Contacto")
            .setMessage("¿Estás seguro de que quieres eliminar este contacto?")
            .setPositiveButton("Sí") { _, _ ->
                contacts.removeAt(position)
                adapter.notifyDataSetChanged()
            }
            .setNegativeButton("No", null)
            .show()
    }
}