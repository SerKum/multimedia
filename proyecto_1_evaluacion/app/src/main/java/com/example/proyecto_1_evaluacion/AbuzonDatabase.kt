package com.example.proyecto_1_evaluacion

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = arrayOf(OrderEntity::class,UserEntity::class,ProductEntity::class), version = 1)
abstract class AbuzonDatabase: RoomDatabase() {
    abstract fun pedidoDao(): PedidoDao

    abstract fun usuarioDao(): UsuarioDao

    abstract fun productDao() : ProductoDao
}