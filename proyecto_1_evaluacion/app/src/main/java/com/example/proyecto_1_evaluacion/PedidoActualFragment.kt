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
import com.example.proyecto_1_evaluacion.databinding.FragmentPedidoActualBinding
import com.example.proyecto_1_evaluacion.databinding.FragmentPedidoBinding
import com.google.android.material.snackbar.Snackbar
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread
import java.time.Duration

class PedidoActualFragment(orderEntity: OrderEntity) : Fragment(),OnClickListener {

    private lateinit var binding : FragmentPedidoActualBinding
    private var listener : OnFragmentActionListener? = null

    private var order : OrderEntity = orderEntity
    private var orderProduct : MutableList<ProductEntity> = getProductOrder()


    private lateinit var user : UserEntity
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

        productoAdapter.clearProductos()

        setupRecyclerView(view)

        val codEan : String = binding.txEditProducto.text.toString().trim()

        binding.btnTramitar.setOnClickListener{
            Snackbar.make(it," Pedido tramitado con exito ",Snackbar.LENGTH_LONG)
            Thread{
                AbuzonApplication.database.pedidoDao().deleteOrder(order)
            }.start()
            listener?.replaceFragment(PedidoFragment())
        }

        binding.btnCargar.setOnClickListener {
            if (comprobarProducto(orderProduct,codEan)){
                borrarProductoLista(orderProduct,codEan)
                setupRecyclerView(it)
            }
            else {
                Toast.makeText(binding.root.context,"Introduce el producto correcto, por favor",Toast.LENGTH_LONG)
            }
        }
    }

    private fun getProductOrder() : MutableList<ProductEntity>{
        var ordPr : MutableList<ProductEntity> = mutableListOf()
        Thread{
             ordPr = AbuzonApplication.database.orderproductDao().getAllProductOrder(order.id)
        }.start()
        return ordPr
    }

    private fun comprobarProducto(list : MutableList<ProductEntity>, ean : String) : Boolean{
        for (producto in list){
            if (producto.ean.toString().equals(ean)){
                return true
            }
        }

        return false
    }

    private fun borrarProductoLista(list : MutableList<ProductEntity>, ean : String){
        for (producto in list) {
            if (producto.ean.toString().equals(ean)) {
                orderProduct.remove(producto)
                val productOrderProductEntity : OrderProductEntity = OrderProductEntity(orderId = order.id, productId = producto.id)
                Thread{
                    AbuzonApplication.database.orderproductDao().deleteProductOrder(productOrderProductEntity)
                }.start()
            }
        }
    }

    private fun setupRecyclerView(view: View) {
        productoAdapter = ProductoAdapter(mutableListOf(), this)
        mLinearLayoutManager = LinearLayoutManager(view.context)
        getProductosPedido()
        binding.tvRemaining.setText("Faltan : "+orderProduct.size)
        binding.rcProductList.apply {
            setHasFixedSize(true)
            layoutManager = mLinearLayoutManager
            adapter = productoAdapter
        }
    }

    private fun getProductosPedido(){
        doAsync {
            val productos : MutableList<ProductEntity> = orderProduct
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

    override fun setProductosPedido(productEntity: ProductEntity) {
        TODO("Not yet implemented")
    }

    private fun setConfiguration(userEntity: UserEntity) {
        if (userEntity.isManager){
            binding.btnTramitar.visibility = View.VISIBLE
        }
        else{
            binding.btnTramitar.visibility = View.GONE
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

}