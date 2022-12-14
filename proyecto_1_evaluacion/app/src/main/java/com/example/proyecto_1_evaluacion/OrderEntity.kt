package com.example.proyecto_1_evaluacion

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverter


@Entity(tableName = "OrderEntity")
data class OrderEntity
    (
    @PrimaryKey(autoGenerate = true)
        val id: Long = 0,
        var isCompleted : Boolean = false
    )
