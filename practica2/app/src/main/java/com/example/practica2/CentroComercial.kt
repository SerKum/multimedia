package com.example.practica2

data class CentroComercial(val nombre: String,val direccion: String) {

    val tiendas:MutableList<Tiendas> = mutableListOf()

    fun añadirTienda(n:String,d:String) {
        val t = Tiendas(n,d)
        tiendas.add(t)
    }
}