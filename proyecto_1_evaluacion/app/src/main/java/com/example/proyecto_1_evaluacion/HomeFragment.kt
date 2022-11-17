package com.example.proyecto_1_evaluacion

import android.content.Context
import android.opengl.Visibility
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import com.example.proyecto_1_evaluacion.databinding.FragmentHomeBinding

class HomeFragment : Fragment() ,OnClickListener{

    private lateinit var binding : FragmentHomeBinding
    private var listener : OnFragmentActionListener? = null
    private var listener2 : OnClickListener? = null

    private lateinit var user :UserEntity

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater)
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        user = listener!!.onClickFragmentButton()

        setConfiguration(user)

        binding.tvSaludo.setText("Hola, "+user.nombre)
        binding.btnPedidos.setOnClickListener{
            listener?.replaceFragment(PedidoFragment())
        }

        binding.btnLogOut.setOnClickListener{
            listener?.logOut()
        }

        binding.btnInfo.setOnClickListener{
            listener?.replaceFragment(ProductoFragment())
        }

        binding.btnRepartidor.setOnClickListener{
            listener?.replaceFragment(RepartidorFragment())
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
        fun newInstance() : HomeFragment{
            return HomeFragment()
        }
    }

    override fun setProductosPedido(productEntity: ProductEntity) {
        TODO("Not yet implemented")
    }


    private fun setConfiguration(userEntity: UserEntity) {
        if (userEntity.isManager){
            binding.btnRepartidor.visibility = View.VISIBLE
        }
        else {
            binding.btnRepartidor.visibility = View.GONE
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