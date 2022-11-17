package com.example.proyecto_1_evaluacion

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface OrderProductDao {
    @Query("SELECT p.* FROM OrderProductEntity INNER JOIN OrderEntity o ON o.id = orderId INNER JOIN ProductEntity p ON p.id = productId WHERE o.id = :orderId")
    fun getAllProductOrder(orderId: Long):MutableList<ProductEntity>

    @Insert
    fun addProductOrder(orderProductEntity: OrderProductEntity)

    @Delete
    fun deleteProductOrder(orderProductEntity: OrderProductEntity)

}