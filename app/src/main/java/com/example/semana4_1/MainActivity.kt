package com.example.semana4_1

import Beans.Usuarios
import Interface.PlaceHolder
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class MainActivity : AppCompatActivity() {

    lateinit var service:PlaceHolder

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val retrofit = Retrofit.Builder()
            .baseUrl("https://dev.formandocodigo.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        service = retrofit.create<PlaceHolder>(PlaceHolder::class.java)
        getAllUser()

    }

    private fun getAllUser(){

        service.getListado().enqueue(object: Callback<List<Usuarios>>{
            override fun onResponse(p0: Call<List<Usuarios>>, p1: Response<List<Usuarios>>) {

                val usu=p1?.body()

                val listaU= mutableListOf<Usuarios>()

                if(usu!=null){
                    for (item in usu){
                        listaU.add(
                            Usuarios(
                                item.codigo,item.nombre,item.edad,
                                item.correo,item.pass,item.foto
                            )
                        )
                    }

                    val recycler=findViewById<RecyclerView>(R.id.recyclerUsers)
                    recycler.layoutManager=LinearLayoutManager(applicationContext)
                    recycler.adapter=Adapter(listaU)
                }
            }

            override fun onFailure(p0: Call<List<Usuarios>>, p1: Throwable) {
                p1?.printStackTrace()
            }

        })


    }


}