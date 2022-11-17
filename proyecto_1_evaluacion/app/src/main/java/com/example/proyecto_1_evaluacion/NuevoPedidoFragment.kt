package com.example.proyecto_1_evaluacion

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.proyecto_1_evaluacion.databinding.FragmentHomeBinding
import com.example.proyecto_1_evaluacion.databinding.FragmentNuevoPedidoBinding
import com.example.proyecto_1_evaluacion.databinding.FragmentPedidoBinding
import com.example.proyecto_1_evaluacion.databinding.FragmentProductoBinding
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread

class NuevoPedidoFragment : Fragment() , OnClickListener{

    private lateinit var binding : FragmentNuevoPedidoBinding
    private var listener : OnFragmentActionListener? = null

    private lateinit var productoAdapter: ProductoAdapter

    private lateinit var mLinearLayoutManager: RecyclerView.LayoutManager

    private lateinit var productos : MutableList<ProductEntity>


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentNuevoPedidoBinding.inflate(inflater)
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        setupRecyclerView(view)

        binding.btnNewOrder.setOnClickListener {
            val pedido : OrderEntity = OrderEntity()
            for (p in productos){
                val productOrderProductEntity : OrderProductEntity = OrderProductEntity(orderId = pedido.id, productId = p.id)
                Thread{
                    AbuzonApplication.database.orderproductDao().addProductOrder(productOrderProductEntity)
                }.start()
            }
            Thread{
                AbuzonApplication.database.pedidoDao().addOrder(pedido)
            }.start()
            listener?.replaceFragment(PedidoFragment())
        }

    }

    private fun setupRecyclerView(view: View) {
        productoAdapter = ProductoAdapter(mutableListOf(), this)
        mLinearLayoutManager = LinearLayoutManager(view.context)
        getAllProductos()
        binding.rcAsignarProductos.apply {
            setHasFixedSize(true)
            layoutManager = mLinearLayoutManager
            adapter = productoAdapter
        }
    }

    private fun getAllProductos(){
        doAsync {
            val productos : MutableList<ProductEntity> = AbuzonApplication.database.productDao().getAllProduct()
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
        fun newInstance() : NuevoPedidoFragment{
            return NuevoPedidoFragment()
        }
    }

    override fun setProductosPedido(productEntity: ProductEntity) {
        productos.add(productEntity)
        Toast.makeText(binding.root.context," Producto añadido ",Toast.LENGTH_LONG)
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

}