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

        entitiesAbuzon()

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
                            setActualUser(usuario)
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

    private fun entitiesAbuzon(){
        val e1 : UserEntity = UserEntity(id = 1,codigo = 100, nombre = "Manolo", apellidos = "Figueroa Ramirez", password = "12345")
        val e2 : UserEntity = UserEntity(id = 2,codigo = 200, nombre = "Alfonso", apellidos = "García Martinez", password = "12345")
        val m1 : UserEntity = UserEntity(id =3,codigo = 300, nombre = "Carlos", apellidos = "Bernard Gravella", password = "12345", isManager = true)

        val pr1 : ProductEntity = ProductEntity(id = 1,111111111,"Movil Samsung Galaxy S22","Móvil de ultima generación con 128gb de almacenamiento")
        val pr2 : ProductEntity = ProductEntity(id = 2,222222222,"Televisión Xiaomi 86\" ","Televisión de Xiaomi 4K con 86 pulgadas")
        val pr3 : ProductEntity = ProductEntity(id = 3,333333333,"Auriculares AirPod 2a gen","Auriculares de la marca Apple, compralos, nadie en su sano juicio lo hará")
        val pr4 : ProductEntity = ProductEntity(id = 4,444444444,"Patinete electrico Xiaomi Mi Scooter 2","Esto lo compra todo dios y no va ni a 30/h")
        val pr5 : ProductEntity = ProductEntity(id = 5,555555555,"Aire Acondicionado DAITSU WRD-H110","Fresquito pal invierno")




        Thread{
            AbuzonApplication.database.usuarioDao().addUsuario(e1)
            AbuzonApplication.database.usuarioDao().addUsuario(e2)
            AbuzonApplication.database.usuarioDao().addUsuario(m1)

            AbuzonApplication.database.productDao().addProduct(pr1)
            AbuzonApplication.database.productDao().addProduct(pr2)
            AbuzonApplication.database.productDao().addProduct(pr3)
            AbuzonApplication.database.productDao().addProduct(pr4)
            AbuzonApplication.database.productDao().addProduct(pr5)
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
        setConfiguration(user)
    }

    override fun setProductosPedido(productEntity: ProductEntity) {
        TODO("Not yet implemented")
    }

    override fun setConfiguration(userEntity: UserEntity){

    }

    override fun getActualUser(): UserEntity {
        return user
    }
}