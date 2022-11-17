package com.example.proyecto_1_evaluacion

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverter


@Entity(primaryKeys = ["orderId","productId"], tableName = "OrderProductEntity")
data class OrderProductEntity
    (
        val orderId : Long,
        val productId : Long
    )
