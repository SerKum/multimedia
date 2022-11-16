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
import com.example.proyecto_1_evaluacion.databinding.FragmentPedidoBinding
import com.example.proyecto_1_evaluacion.databinding.FragmentProductoBinding
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread

class ProductoFragment : Fragment() ,OnClickListener{

    private lateinit var binding : FragmentProductoBinding
    private var listener : OnFragmentActionListener? = null

    private lateinit var productoAdapter: ProductoAdapter

    private lateinit var mLinearLayoutManager: RecyclerView.LayoutManager


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentProductoBinding.inflate(inflater)
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        productoAdapter.clearProductos()

        binding.btnSearch.setOnClickListener{
            val ean : Long = binding.txEditProducto.text.toString().toLong()
            if (existsProduct(ean)){
                binding.rcProductSearch.visibility = View.VISIBLE
                setupRecyclerView(view,ean)
            }
            else{
                Toast.makeText(view.context," Por favor. introduce un producto válido ", Toast.LENGTH_LONG)
            }
        }

    }

    private fun setupRecyclerView(view: View,ean:Long) {
        productoAdapter = ProductoAdapter(mutableListOf(), this)
        mLinearLayoutManager = LinearLayoutManager(view.context)
        getProduct(ean)
        binding.rcProductSearch.apply {
            setHasFixedSize(true)
            layoutManager = mLinearLayoutManager
            adapter = productoAdapter
        }
    }

    private fun getProduct(ean: Long){
        doAsync {
            val producto : ProductEntity = AbuzonApplication.database.productDao().getOneProduct(ean)
            uiThread {
                productoAdapter.setProductos(mutableListOf(producto))
            }
        }
    }

    private fun existsProduct(ean : Long) : Boolean{
        val exist : Boolean = AbuzonApplication.database.productDao().existsProduct(ean)
        if (exist){
            return true
        }

        return false
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
        fun newInstance() : ProductoFragment{
            return ProductoFragment()
        }
    }

    override fun setProductosPedido(productEntity: ProductEntity) {
        TODO("Not yet implemented")
    }

    override fun setConfiguration(userEntity: UserEntity) {
        TODO("Not yet implemented")
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