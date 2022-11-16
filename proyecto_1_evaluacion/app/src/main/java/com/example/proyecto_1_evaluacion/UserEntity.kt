package com.example.proyecto_1_evaluacion

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "UserEntity")
data class UserEntity
    (
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val codigo: Int,
    val nombre : String,
    val apellidos : String,
    val password : String,
    var isManager : Boolean = false,
    var isDelivery : Boolean = false
    )
{
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as UserEntity

        if (id != other.id) return false
        if (codigo != other.codigo) return false
        if (nombre != other.nombre) return false
        if (apellidos != other.apellidos) return false
        if (password != other.password) return false
        if (isManager != other.isManager) return false
        if (isDelivery != other.isDelivery) return false

        return true
    }

    override fun hashCode(): Int {
        var result = id.hashCode()
        result = 31 * result + codigo
        result = 31 * result + nombre.hashCode()
        result = 31 * result + apellidos.hashCode()
        result = 31 * result + password.hashCode()
        result = 31 * result + isManager.hashCode()
        result = 31 * result + isDelivery.hashCode()
        return result
    }

}

