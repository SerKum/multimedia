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

class PedidoAdapter
    (private var pedidos: MutableList<OrderEntity>,private var listener: OnClickListener): RecyclerView.Adapter<PedidoAdapter.ViewHolder>()

{

    private lateinit var context: Context

    private var listener2 : OnFragmentActionListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        context = parent.context

        val view = LayoutInflater.from(context).inflate(R.layout.item_pedido,parent,false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val pedido = pedidos.get(position)

        with(holder) {
            setListener(pedido)
            binding.tvNombre.text = pedido.codigo
        }
    }

    override fun getItemCount(): Int = pedidos.size

    fun setPedidos(pedidos: MutableList<OrderEntity>){
        this.pedidos = pedidos
        notifyDataSetChanged()
    }

    fun update(orderEntity: OrderEntity) {
        val index = pedidos.indexOf(orderEntity)
        if (index != -1){
            pedidos.set(index,orderEntity)
            notifyItemChanged(index)
        }
    }

    fun delete(orderEntity: OrderEntity) {
        val index = pedidos.indexOf(orderEntity)
        if (index != -1){
            pedidos.removeAt(index)
            notifyItemRemoved(index)
        }
    }

    inner class ViewHolder(view : View): RecyclerView.ViewHolder(view){
        val binding = ItemPedidoBinding.bind(view)

        val user : UserEntity = listener.getActualUser()

        fun setListener(orderEntity: OrderEntity) {
            binding.root.setOnClickListener{
                listener.onClick(orderEntity)
            }
            binding.pedido.setOnClickListener{
                listener2?.replaceFragment(PedidoActualFragment(orderEntity))
                orderEntity.isCompleted = true
            }

            binding.root.setOnLongClickListener {
                if (user.isManager) {
                    listener.onDeleteOrder(orderEntity,user)
                    Thread {
                        AbuzonApplication.database.pedidoDao().deleteOrder(orderEntity)
                    }.start()
                }
                true
            }
        }

    }
    companion object {
        fun add(pedidoAdapter: PedidoAdapter, orderEntity: OrderEntity) {
            pedidoAdapter.pedidos.add(orderEntity)
            pedidoAdapter.notifyDataSetChanged()
        }
    }

}