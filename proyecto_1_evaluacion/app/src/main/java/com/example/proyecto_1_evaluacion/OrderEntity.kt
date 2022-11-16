package com.example.proyecto_1_evaluacion

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "OrderEntity")
data class OrderEntity
    (
    @PrimaryKey(autoGenerate = true)
        val id: Long = 0,
        val productos : MutableList<ProductEntity>,
        var isCompleted : Boolean = false,
    )