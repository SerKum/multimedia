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
import com.example.proyecto_1_evaluacion.databinding.FragmentPedidoBinding
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread

class PedidoFragment : Fragment() ,OnClickListener{

    private lateinit var binding : FragmentPedidoBinding
    private var listener : OnFragmentActionListener? = null

    private lateinit var pedidoAdapter: PedidoAdapter
    private lateinit var pedidoAdapter2: PedidoAdapter

    private lateinit var mLinearLayoutManager: RecyclerView.LayoutManager

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPedidoBinding.inflate(inflater)
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupRecyclerView(view)
    }

    private fun setupRecyclerView(view: View) {
        pedidoAdapter = PedidoAdapter(mutableListOf(), this)
        pedidoAdapter2 = PedidoAdapter(mutableListOf(), this)
        mLinearLayoutManager = LinearLayoutManager(view.context)
        getPedidosIncompletos()
        binding.rcUncompletedOrders.apply {
            setHasFixedSize(true)
            layoutManager = mLinearLayoutManager
            adapter = pedidoAdapter
        }
        getPedidosSinRevisar()
        binding.rcUnrevisedOrders.apply {
            setHasFixedSize(true)
            layoutManager = mLinearLayoutManager
            adapter = pedidoAdapter2
        }
    }

    private fun getPedidosIncompletos(){
        doAsync {
            val pedidos : MutableList<OrderEntity> = AbuzonApplication.database.pedidoDao().getOrdersUncompleted(false)
            uiThread {
                pedidoAdapter.setPedidos(pedidos)
            }
        }
    }


    private fun getPedidosSinRevisar(){
        doAsync {
            val pedidos : MutableList<OrderEntity> = AbuzonApplication.database.pedidoDao().getOrdersUnrevised(true)
            uiThread {
                pedidoAdapter2.setPedidos(pedidos)
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
        fun newInstance() : PedidoFragment{
            return PedidoFragment()
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