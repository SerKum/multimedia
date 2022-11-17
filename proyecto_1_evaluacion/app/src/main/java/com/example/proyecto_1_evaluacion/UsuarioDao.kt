package com.example.proyecto_1_evaluacion

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface UsuarioDao {
    @Query("SELECT * FROM UserEntity")
    fun getAllUsuarios():MutableList<UserEntity>

    @Query("SELECT * FROM UserEntity WHERE codigo = :codigo")
    fun getOneDelivery(codigo : Int):UserEntity

    @Query("SELECT EXISTS (SELECT 1 FROM UserEntity WHERE codigo = :codigo)")
    fun existsUser(codigo : Int):Boolean

    @Query("SELECT EXISTS (SELECT 1 FROM UserEntity WHERE codigo = :codigo)")
    fun exists(codigo: Int):Boolean

    @Query("SELECT * FROM UserEntity WHERE codigo = :codigo")
    fun getAUser(codigo : Int):UserEntity

    @Insert
    fun addUsuario(userEntity: UserEntity)



}