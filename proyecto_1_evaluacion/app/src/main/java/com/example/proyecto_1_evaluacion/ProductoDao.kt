package com.example.proyecto_1_evaluacion

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface ProductoDao {
    @Query("SELECT * FROM ProductEntity")
    fun getAllProduct():MutableList<ProductEntity>

    @Insert
    fun addProduct(productEntity: ProductEntity)

    @Delete
    fun deleteProduct(productEntity: ProductEntity)

}