package com.example.practica2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.example.practica2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val lista_centros:MutableList<CentroComercial> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        listar_centros()
        poner_info()
        cargarCentros()
        setContentView(binding.root)
    }

    private fun listar_centros(){
        val c1 = CentroComercial("Bonaire","Autovía del Este, Km. 345, 46960, Valencia")
        c1.añadirTienda("Alcampo","Alcampo es uno de los hipermercados referencia en España con precios muy competitivos y productos de primera calidad en todas las secciones, donde los clientes pueden realizar sus compras cada día.")
        c1.añadirTienda("Decathlon","Decathlon es una empresa dedicada a la venta de ropa, complementos y artículos deportivos para hacer accesible el deporte al mayor número de personas posible.")
        c1.añadirTienda("Hollister","Hollister es una marca de ropa estilo \"Vida Americana\" de la compañía Abercrombie & Fitch. Inspirada en el Sur de California y diseñada para atraer a adolescentes y jóvenes.")
        c1.añadirTienda("Fnac","Creada en Francia en 1954, Fnac es la primera distribuidora en Europa de productos tecnológicos y culturales, y constituye un ejemplo único de alianza entre comercio, cultura y tecnología.")

        val c2 = CentroComercial("Gran Turia","Plaza de Europa, s/n, 46950 Xirivella, Valencia")
        c2.añadirTienda("Sprinter","La cadena deportiva Sprinter cuenta con más de 175 puntos de venta físicos en la península y con una amplia gama de primeras marcas deportivas como Fila, adidas, Nike, Puma, Asics, además de marcas propias, tanto de moda como de deportes como el running, el fútbol, el fitness o el ciclismo")
        c2.añadirTienda("Druni","Perfumes, maquillaje y cosmética para el cuidado de la piel")
        c2.añadirTienda("Phone House","Especialistas en smartphones, tarifas y accesorios.")
        c2.añadirTienda("Inside","En Inside encontrarás ropa urbana con las últimas tendencias tanto para mujer como para hombre. Orientada a un público amante del street style.")

        val c3 = CentroComercial("El Saler","Av. del Professor López Piñero, 16, 46013 València, Valencia")
        c3.añadirTienda("Berska","¿No te pierdes las últimas tendencias de moda? ¿Vives por descubrir nuevos outfits? ¿Tus looks arrasan por donde pasan? ¡Entonces has llegado al sitio perfecto!\uD83D\uDE1C")
        c3.añadirTienda("Belros","Vendemos caramelos, golosinas, frutos secos y aceitunas además de tartas de gominolas y otros artículos exclusivos.")
        c3.añadirTienda("Calzedonia","Calzedonia es una cadena italiana de tiendas especializadas en la venta de pantys y medias para mujer y niña, y de calcetines y bañadores tanto para mujer como para hombre y niño/a.")
        c3.añadirTienda("Alain Afflelou","Gafas, un saludo.")

        val c4 = CentroComercial("Arena","C. de Santa Genoveva Torres, 21, 46019 València, Valencia")
        c4.añadirTienda("Cortefiel","Prendas cómodas para todo tipo de planes. Ponte al día y renueva armario. Nuevos colores, estampados y prendas para recuperar el ritmo de otoño. Devoluciones Gratuitas.")
        c4.añadirTienda("GAME","Game Retail Limited es un minorista británico de videojuegos.")
        c4.añadirTienda("Mango","Descubre las últimas tendencias en moda, calzado y complementos de Mango. Compra los mejores looks para esta temporada en nuestra tienda online.")
        c4.añadirTienda("Movistar","Descubre las mejores ⭐ Ofertas en Internet, Fusión, Móvil, Móviles Libres ⭐ y los Mejores Contenidos de TV, Series y las mejores Películas con Movistar+.")
        lista_centros.addAll(listOf(c1,c2,c3,c4))
    }

    private fun poner_info(){
        binding.content.centerTitle.setText(lista_centros.get(0).nombre)
        binding.content.centerDesc.setText(lista_centros.get(0).direccion)
        binding.content.centerShop.setText(lista_centros.get(0).tiendas.size.toString())
        binding.content.centerTitle1.setText(lista_centros.get(1).nombre)
        binding.content.centerDesc1.setText(lista_centros.get(1).direccion)
        binding.content.centerShop1.setText(lista_centros.get(1).tiendas.size.toString())
        binding.content.centerTitle2.setText(lista_centros.get(2).nombre)
        binding.content.centerDesc2.setText(lista_centros.get(2).direccion)
        binding.content.centerShop2.setText(lista_centros.get(2).tiendas.size.toString())
        binding.content.centerTitle3.setText(lista_centros.get(3).nombre)
        binding.content.centerDesc3.setText(lista_centros.get(3).direccion)
        binding.content.centerShop3.setText(lista_centros.get(3).tiendas.size.toString())
    }

    private fun cargarCentros(){
        val img1 = "https://res.cloudinary.com/westfielddg/image/upload/westfield-media/es/centre/mobile-app/zcarfj4iu8dw4jwqidq6.jpg"
        val img2 = "https://valenciaplaza.com/public/Image/2018/5/GranTuria1_NoticiaAmpliada.jpg"
        val img3 = "https://agendadeisa.com/wp-content/uploads/2019/06/CC-SALER-112-1024x682.jpg"
        val img4 = "https://www.lovevalencia.com/wp-content/uploads/2013/03/ARENA-750x400.jpg"
        Glide.with(this)
            .load(img1)
            .diskCacheStrategy(DiskCacheStrategy.RESOURCE)
            .centerCrop()
            .into(binding.content.imgV1)
        Glide.with(this)
            .load(img2)
            .diskCacheStrategy(DiskCacheStrategy.RESOURCE)
            .centerCrop()
            .into(binding.content.imgV2)
        Glide.with(this)
            .load(img3)
            .diskCacheStrategy(DiskCacheStrategy.RESOURCE)
            .centerCrop()
            .into(binding.content.imgV3)
        Glide.with(this)
            .load(img4)
            .diskCacheStrategy(DiskCacheStrategy.RESOURCE)
            .centerCrop()
            .into(binding.content.imgV4)
    }

}