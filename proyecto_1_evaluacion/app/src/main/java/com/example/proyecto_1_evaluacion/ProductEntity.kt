package com.example.proyecto_1_evaluacion

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "ProductEntity")
data class ProductEntity
    (
        @PrimaryKey(autoGenerate = true)
        val id: Long,
        val nombre : String,
        val descripcion : String
    )



