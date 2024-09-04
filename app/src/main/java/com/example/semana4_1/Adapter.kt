package com.example.semana4_1

import Beans.Usuarios
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class Adapter(val usuariosList:List<Usuarios>):RecyclerView.Adapter<UsersViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UsersViewHolder {

        val layoutInflater=LayoutInflater.from(parent.context)
        return UsersViewHolder(layoutInflater.inflate(R.layout.card,parent,false))

    }

    override fun getItemCount(): Int =usuariosList.size

    override fun onBindViewHolder(holder: UsersViewHolder, position: Int) {
       val item=usuariosList[position]
        holder.render(item)
    }
}