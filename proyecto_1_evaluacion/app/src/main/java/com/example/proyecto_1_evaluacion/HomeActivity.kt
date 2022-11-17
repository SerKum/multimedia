package com.example.proyecto_1_evaluacion

import android.R
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.example.proyecto_1_evaluacion.databinding.ActivityHomeBinding


class HomeActivity : AppCompatActivity(),OnFragmentActionListener {

    private lateinit var binding : ActivityHomeBinding

    private var listener: OnFragmentActionListener? = null
    private var listener2: OnClickListener? = null

    private lateinit var user : UserEntity


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityHomeBinding.inflate(layoutInflater)

        setContentView(binding.root)

        user = intent.extras?.get("usuario") as UserEntity

        loadFragment(HomeFragment())

    }

    override fun loadFragment(fragment: Fragment) {
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.add(binding.fragmentContainer.id, fragment)
        fragmentTransaction.commit()
    }

    override fun replaceFragment(fragment: Fragment){
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(binding.fragmentContainer.id, fragment)
        fragmentTransaction.addToBackStack(null)
        fragmentTransaction.commit()
    }


    //Cerrar sesión
    override fun logOut(){
        finish()
        var i = Intent(this,MainActivity::class.java)
        startActivity(i)
    }

    override fun onBackPressed() {
        val fm: FragmentManager = supportFragmentManager
        val fragInstance = fm.findFragmentById(binding.fragmentContainer.id)

        //Permite volver a atrás en cualquier otra instancia o clase excepto en el fragment de home
        if (fragInstance !is HomeFragment){
            super.onBackPressed()
        }

    }

    override fun onClickFragmentButton(): UserEntity {
        return user
    }




}