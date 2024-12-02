package com.example.rodriguezlealmarioextradiciembre24

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.BaseAdapter

class ContactAdapter(private val context: Context, private val contacts: MutableList<Contact>) : BaseAdapter() {

    override fun getCount(): Int {
        return contacts.size
    }

    override fun getItem(position: Int): Any {
        return contacts[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view: View = convertView ?: LayoutInflater.from(context).inflate(R.layout.item_contact, parent, false)

        val nameTextView: TextView = view.findViewById(R.id.tvContactName)
        val phoneTextView: TextView = view.findViewById(R.id.tvContactPhone)
        val emailTextView: TextView = view.findViewById(R.id.tvContactEmail)
        val addressTextView: TextView = view.findViewById(R.id.tvContactAddress)
        val nickTextView: TextView = view.findViewById(R.id.tvContactNick)

        val contact = contacts[position]
        nameTextView.text = contact.name
        phoneTextView.text = contact.phone
        emailTextView.text = contact.email
        addressTextView.text = contact.address
        nickTextView.text = contact.nick

        return view
    }
}