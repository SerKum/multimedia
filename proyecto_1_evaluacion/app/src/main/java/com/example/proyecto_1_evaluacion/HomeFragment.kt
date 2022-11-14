package com.example.proyecto_1_evaluacion

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.proyecto_1_evaluacion.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private lateinit var binding : FragmentHomeBinding
    private var listener : OnFragmentActionListener? = null


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
}