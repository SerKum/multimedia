package com.example.proyecto_1_evaluacion

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface PedidoDao {
    @Query("SELECT * FROM OrderEntity")
    fun getAllOrders():MutableList<OrderEntity>

    @Query("SELECT * FROM OrderEntity WHERE isCompleted = :revisado")
    fun getOrdersUncompleted(revisado : Boolean):MutableList<OrderEntity>

    @Query("SELECT * FROM OrderEntity WHERE isCompleted = :revisado")
    fun getOrdersUnrevised(revisado : Boolean):MutableList<OrderEntity>

    @Insert
    fun addOrder(orderEntity: OrderEntity)

    @Delete
    fun deleteOrder(orderEntity: OrderEntity)

}