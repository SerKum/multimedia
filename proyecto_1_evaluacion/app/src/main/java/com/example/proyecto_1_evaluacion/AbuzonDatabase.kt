package com.example.proyecto_1_evaluacion

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters

@Database(entities = arrayOf(OrderEntity::class,UserEntity::class,ProductEntity::class,OrderProductEntity::class), version = 2)
abstract class AbuzonDatabase: RoomDatabase() {
    abstract fun pedidoDao(): PedidoDao

    abstract fun usuarioDao(): UsuarioDao

    abstract fun productDao() : ProductoDao

    abstract fun orderproductDao() : OrderProductDao
}