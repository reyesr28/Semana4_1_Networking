package com.example.semana4_1

import Beans.Usuarios
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class UsersViewHolder(view: View):RecyclerView.ViewHolder(view) {

    var userCod=view.findViewById<TextView>(R.id.txtCod)
    var userNom=view.findViewById<TextView>(R.id.txtNom)
    var userEdad=view.findViewById<TextView>(R.id.txtEdad)
    var userCorreo=view.findViewById<TextView>(R.id.txtCorreo)
    var userFoto=view.findViewById<ImageView>(R.id.imgUser)

    fun render(userModel:Usuarios){
        userCod.text=userModel.codigo
        userNom.text=userModel.nombre
        userEdad.text=userModel.edad.toString()
        userCorreo.text=userModel.correo
        Picasso.get().load(userModel.foto)
            .resize(300,300)
            .centerCrop().into(userFoto)

    }



}