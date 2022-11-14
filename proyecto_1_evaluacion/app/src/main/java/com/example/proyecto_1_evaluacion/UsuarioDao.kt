package com.example.proyecto_1_evaluacion

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface UsuarioDao {
    @Query("SELECT * FROM UserEntity")
    fun getAllUsuarios():MutableList<UserEntity>

    @Query("SELECT EXISTS (SELECT 1 FROM UserEntity WHERE nombre = :nombre)")
    fun exists(nombre: String):Boolean

    @Query("SELECT * FROM UserEntity WHERE codigo = :codigo")
    fun getAUser(codigo : Int):UserEntity

    @Insert
    fun addUsuario(userEntity: UserEntity)



}