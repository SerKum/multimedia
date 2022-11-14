package com.example.proyecto_1_evaluacion

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.proyecto_1_evaluacion.databinding.FragmentHomeBinding
import com.example.proyecto_1_evaluacion.databinding.FragmentPedidoActualBinding
import com.example.proyecto_1_evaluacion.databinding.FragmentPedidoBinding
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread

class PedidoActualFragment(orderEntity: OrderEntity) : Fragment(),OnClickListener {

    private lateinit var binding : FragmentPedidoActualBinding
    private var listener : OnFragmentActionListener? = null

    private var order : OrderEntity = orderEntity

    private lateinit var productoAdapter: ProductoAdapter

    private lateinit var mLinearLayoutManager: RecyclerView.LayoutManager


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPedidoActualBinding.inflate(inflater)
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView(view)
    }

    private fun setupRecyclerView(view: View) {
        productoAdapter = ProductoAdapter(mutableListOf(), this)
        mLinearLayoutManager = LinearLayoutManager(view.context)
        getProductosPedido()
        binding.rcProductList.apply {
            setHasFixedSize(true)
            layoutManager = mLinearLayoutManager
            adapter = productoAdapter
        }
    }

    private fun getProductosPedido(){
        doAsync {
            val productos : MutableList<ProductEntity> = order.productos
            uiThread {
                productoAdapter.setProductos(productos)
            }
        }
    }


    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnFragmentActionListener) {
            listener = context
        }
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }


    companion object {
        fun newInstance(orderEntity: OrderEntity) : PedidoActualFragment{
            return PedidoActualFragment(orderEntity)
        }
    }

    override fun onClick(userEntity: UserEntity) {
        TODO("Not yet implemented")
    }

    override fun onClick(productEntity: ProductEntity) {
        TODO("Not yet implemented")
    }

    override fun onClick(orderEntity: OrderEntity) {
        TODO("Not yet implemented")
    }

    override fun onDeleteOrder(orderEntity: OrderEntity, userEntity: UserEntity) {
        TODO("Not yet implemented")
    }

    override fun getActualUser(): UserEntity {
        TODO("Not yet implemented")
    }
}