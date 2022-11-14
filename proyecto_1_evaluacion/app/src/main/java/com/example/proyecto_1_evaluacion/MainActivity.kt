package com.example.proyecto_1_evaluacion

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.proyecto_1_evaluacion.databinding.ActivityMainBinding
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread

class MainActivity : AppCompatActivity(),OnClickListener {

    private lateinit var binding: ActivityMainBinding

    private var user : UserEntity = TODO()


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

        binding.btnLog.setOnClickListener {

            if (binding.cbxRememberMe.isChecked){
                val user = binding.logInUser.text.toString()
                val password = binding.logInPass.text.toString()

                preferences.edit().putString("username", user).commit()
                preferences.edit().putString("password", password).commit()
            }
            else{
                preferences.edit().putString("username", "").commit()
                preferences.edit().putString("password", "").commit()
            }

            doAsync {

                val us : Boolean = AbuzonApplication.database.usuarioDao().exists(binding.logInUser.text.toString())
                val usuario : UserEntity = AbuzonApplication.database.usuarioDao().getAUser(binding.logInUser.text.toString().toInt())

                uiThread {
                    if (!us){
                        Toast.makeText(it,"Ese usuario no existe", Toast.LENGTH_LONG).show()
                    }
                    else if(us){
                        if (usuario.password.equals(binding.logInPass.text.toString())) {
                            var i = Intent(it,HomeActivity::class.java)
                            startActivity(i)
                        }
                        else {
                            Toast.makeText(it,"Contraseña incorrecta", Toast.LENGTH_LONG).show()
                        }
                    }
                }
            }

        }
    }

    override fun onClick(userEntity: UserEntity) {
        TODO("Not yet implemented")
    }

    override fun onClick(productEntity: ProductEntity) {
        TODO("Not yet implemented")
    }

    override fun onClick(orderEntity: OrderEntity) {

    }

    override fun onDeleteOrder(orderEntity: OrderEntity, userEntity: UserEntity) {

    }

    private fun setActualUser(userEntity: UserEntity){
        user = userEntity
    }


    override fun getActualUser(): UserEntity {
        return user
    }
}