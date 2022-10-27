package com.example.practica3

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.example.practica3.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        val preferences = getPreferences(Context.MODE_PRIVATE)
        val usuarioSP = preferences.getString("username", "")
        val passwordSP = preferences.getString("password","")

        if (usuarioSP != "" && passwordSP != ""){
            binding.apply {
                logInUser.setText(usuarioSP)
                logInPass.setText(passwordSP)
            }
        }

        Glide.with(this)
            .load("https://img.freepik.com/vector-premium/viejo-cartel-retro-fondo-paginas-propagacion-periodico-paginas-periodico-vintage-patrones-fisuras-ilustracion-fondo-vector-papel-periodico-telon-fondo-pagina-periodico-retro_229548-2373.jpg?w=2000")
            .diskCacheStrategy(DiskCacheStrategy.RESOURCE)
            .centerCrop()
            .into(binding.imgCover)

        binding.btnLogin.setOnClickListener {
            val user = binding.logInUser.text.toString()
            val password = binding.logInPass.text.toString()

            preferences.edit().putString("username", user).commit()
            preferences.edit().putString("password", password).commit()

            var i = Intent(this,NoticiaActivity::class.java)
            startActivity(i)
        }
    }
}