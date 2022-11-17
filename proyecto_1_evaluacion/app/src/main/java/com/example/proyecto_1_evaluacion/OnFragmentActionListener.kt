package com.example.proyecto_1_evaluacion

import androidx.fragment.app.Fragment

interface OnFragmentActionListener {
    fun replaceFragment(fragment: Fragment)
    fun loadFragment(fragment: Fragment)
    fun onClickFragmentButton(): UserEntity
    fun logOut()
}