package com.example.proyecto_1_evaluacion

interface OnClickListener {
    fun setProductosPedido(productEntity: ProductEntity)
    fun setConfiguration(userEntity: UserEntity)
    fun onClick(userEntity: UserEntity)
    fun onClick(productEntity: ProductEntity)
    fun onClick(orderEntity: OrderEntity)
    fun onDeleteOrder(orderEntity: OrderEntity,userEntity: UserEntity)
    fun getActualUser() : UserEntity
}