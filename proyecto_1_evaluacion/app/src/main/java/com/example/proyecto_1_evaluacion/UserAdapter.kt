package com.example.proyecto_1_evaluacion

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.proyecto_1_evaluacion.databinding.ItemEmpleadoBinding
import com.example.proyecto_1_evaluacion.databinding.ItemProductoBinding

class UserAdapter
    (private var usuarios: MutableList<UserEntity>, private var listener: OnClickListener): RecyclerView.Adapter<UserAdapter.ViewHolder>()

{

    private lateinit var context: Context

    private var listener2 : OnFragmentActionListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        context = parent.context

        val view = LayoutInflater.from(context).inflate(R.layout.item_producto,parent,false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val usuario = usuarios.get(position)

        with(holder) {
            setListener(usuario)
            binding.tvNombre.text = usuario.nombre
            binding.tvCodigo.text = usuario.codigo.toString()
        }
    }

    override fun getItemCount(): Int = usuarios.size

    fun setUsers(usuarios: MutableList<UserEntity>){
        this.usuarios = usuarios
        notifyDataSetChanged()
    }

    fun update(userEntity: UserEntity) {
        val index = usuarios.indexOf(userEntity)
        if (index != -1){
            usuarios.set(index,userEntity)
            notifyItemChanged(index)
        }
    }

    fun delete(userEntity: UserEntity) {
        val index = usuarios.indexOf(userEntity)
        if (index != -1){
            usuarios.removeAt(index)
            notifyItemRemoved(index)
        }
    }

    inner class ViewHolder(view : View): RecyclerView.ViewHolder(view){
        val binding = ItemEmpleadoBinding.bind(view)

        val user : UserEntity = listener.getActualUser()

        fun setListener(userEntity: UserEntity) {
            binding.root.setOnClickListener{
                listener.onClick(userEntity)
            }

            binding.btnAsignDelivery.setOnClickListener{
                user.isDelivery = true
            }
        }

    }
    companion object {
        fun add(userAdapter: UserAdapter, userEntity: UserEntity) {
            userAdapter.usuarios.add(userEntity)
            userAdapter.notifyDataSetChanged()
        }
    }

}