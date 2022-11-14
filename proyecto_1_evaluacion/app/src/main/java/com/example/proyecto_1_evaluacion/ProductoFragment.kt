package com.example.proyecto_1_evaluacion

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.proyecto_1_evaluacion.databinding.FragmentHomeBinding
import com.example.proyecto_1_evaluacion.databinding.FragmentPedidoBinding
import com.example.proyecto_1_evaluacion.databinding.FragmentProductoBinding

class ProductoFragment : Fragment() {

    private lateinit var binding : FragmentProductoBinding
    private var listener : OnFragmentActionListener? = null


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

        binding.btnSearch.setOnClickListener{
            val ean : Long = binding.txEditProducto.text.toString().toLong()
            if (!binding.txEditProducto.text?.equals("")!!){

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
        fun newInstance() : ProductoFragment{
            return ProductoFragment()
        }
    }
}