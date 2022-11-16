package com.example.proyecto_1_evaluacion

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface ProductoDao {
    @Query("SELECT * FROM ProductEntity")
    fun getAllProduct():MutableList<ProductEntity>

    @Query("SELECT * FROM ProductEntity WHERE ean = :ean")
    fun getOneProduct(ean : Long):ProductEntity

    @Query("SELECT EXISTS (SELECT 1 FROM ProductEntity WHERE ean = :ean)")
    fun existsProduct(ean : Long):Boolean

    @Insert
    fun addProduct(productEntity: ProductEntity)

    @Delete
    fun deleteProduct(productEntity: ProductEntity)

}