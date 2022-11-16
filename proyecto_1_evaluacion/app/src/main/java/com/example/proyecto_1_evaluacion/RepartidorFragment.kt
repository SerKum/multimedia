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
import com.example.proyecto_1_evaluacion.databinding.FragmentRepartidorBinding
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread

class RepartidorFragment : Fragment() , OnClickListener{

    private lateinit var binding : FragmentRepartidorBinding
    private var listener : OnFragmentActionListener? = null

    private lateinit var userAdapter: UserAdapter

    private lateinit var mLinearLayoutManager: RecyclerView.LayoutManager


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRepartidorBinding.inflate(inflater)
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        userAdapter.clearUsers()

        setupRecyclerView(view)

        binding.btnSearch.setOnClickListener {
            val codEmp : Int = binding.txEditEmpleado.text.toString().toInt()
            if (exists(codEmp)){
                getOneDelivery(codEmp)
            }
        }
    }

    private fun setupRecyclerView(view: View) {
        userAdapter = UserAdapter(mutableListOf(), this)
        mLinearLayoutManager = LinearLayoutManager(view.context)
        getAllDelivery()
        binding.rcDeliveryList.apply {
            setHasFixedSize(true)
            layoutManager = mLinearLayoutManager
            adapter = userAdapter
        }
    }


    private fun exists(cod : Int) : Boolean{
        val us : Boolean = AbuzonApplication.database.usuarioDao().existsUser(cod)

        if (us){
            return true
        }

        return false
    }

    private fun getOneDelivery(cod : Int){
        doAsync {
            val usuario : UserEntity = AbuzonApplication.database.usuarioDao().getOneDelivery(cod)
            uiThread {
                userAdapter.clearUsers()
                userAdapter.setUsers(mutableListOf(usuario))
                binding.rcDeliveryList.apply {
                    setHasFixedSize(true)
                    layoutManager = mLinearLayoutManager
                    adapter = userAdapter
                }
            }
        }
    }

    private fun getAllDelivery(){
        doAsync {
            val usuarios : MutableList<UserEntity> = AbuzonApplication.database.usuarioDao().getAllUsuarios()
            uiThread {
                userAdapter.setUsers(usuarios)
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
        fun newInstance() : RepartidorFragment{
            return RepartidorFragment()
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