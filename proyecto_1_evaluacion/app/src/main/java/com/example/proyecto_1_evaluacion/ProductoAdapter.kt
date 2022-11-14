package com.example.proyecto_1_evaluacion

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.example.proyecto_1_evaluacion.databinding.ItemPedidoBinding
import com.example.proyecto_1_evaluacion.databinding.ItemProductoBinding

class ProductoAdapter
    (private var productos: MutableList<ProductEntity>,private var listener: OnClickListener): RecyclerView.Adapter<ProductoAdapter.ViewHolder>()

{

    private lateinit var context: Context

    private var listener2 : OnFragmentActionListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        context = parent.context

        val view = LayoutInflater.from(context).inflate(R.layout.item_producto,parent,false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val producto = productos.get(position)

        with(holder) {
            setListener(producto)
            binding.tvNombre.text = producto.nombre
            binding.tvDescripcion.text = producto.descripcion
        }
    }

    override fun getItemCount(): Int = productos.size

    fun setProductos(productos: MutableList<ProductEntity>){
        this.productos = productos
        notifyDataSetChanged()
    }

    fun update(productEntity: ProductEntity) {
        val index = productos.indexOf(productEntity)
        if (index != -1){
            productos.set(index,productEntity)
            notifyItemChanged(index)
        }
    }

    fun delete(productEntity: ProductEntity) {
        val index = productos.indexOf(productEntity)
        if (index != -1){
            productos.removeAt(index)
            notifyItemRemoved(index)
        }
    }

    inner class ViewHolder(view : View): RecyclerView.ViewHolder(view){
        val binding = ItemProductoBinding.bind(view)

        val user : UserEntity = listener.getActualUser()

        fun setListener(productEntity: ProductEntity) {
            binding.root.setOnClickListener{
                listener.onClick(productEntity)
            }
        }

    }
    companion object {
        fun add(productoAdapter: ProductoAdapter, productEntity: ProductEntity) {
            productoAdapter.productos.add(productEntity)
            productoAdapter.notifyDataSetChanged()
        }
    }

}