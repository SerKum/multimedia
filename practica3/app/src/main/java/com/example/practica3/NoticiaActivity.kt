package com.example.practica3

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.practica3.databinding.ActivityNoticiaBinding
import java.time.LocalDate
import java.time.LocalDateTime

class NoticiaActivity :  AppCompatActivity(),OnClickListener{

    private lateinit var binding : ActivityNoticiaBinding

    private lateinit var noticiaAdapter: NoticiaAdapter
    private lateinit var linearLayoutManager: RecyclerView.LayoutManager


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityNoticiaBinding.inflate(layoutInflater)

        setContentView(binding.root)

        noticiaAdapter = NoticiaAdapter(getNoticias(),this)
        linearLayoutManager = LinearLayoutManager(this)

        binding.recyclerView.apply {
            layoutManager = linearLayoutManager
            adapter = noticiaAdapter
        }

    }

    private fun getNoticias(): MutableList<Noticia>{
        val noticias = mutableListOf<Noticia>()

        val not1 = Noticia(1,"Antón gana el pulso a todo un país",
            "Cuando Antón acudió al Campeonato de España de lucha de brazos muchos acabaron preguntando dónde estaba Betanzos. Porque este joven de 27 años acababa de ganar el título nacional en la categoría de principiantes de lo que se conoce popularmente como echar pulsos.",
            "22/10/2022",
            "https://cflvdg.avoz.es/sc/8QG3OpbnxqywKTR7WrnfIqkOlpQ=/768x/2022/10/22/00121666451942268149912/Foto/HO23C8F1_171756.jpg",
            "https://www.lavozdegalicia.es/noticia/coruna/betanzos/2022/10/23/anton-gana-pulso-pais/0003_202210H23C8991.htm")
        val not2 = Noticia(2,"WhatsApp sufre una caída de sus servicios",
            "La aplicación de mensajería instantánea ha experimentado fallos en varios países durante dos horas, entre las nueve y las once, hora peninsular española",
            "25/10/2022",
            "https://imagenes.elpais.com/resizer/5t-bXjPA3wENZpJaaBfF5Tr88UQ=/1960x0/cloudfront-eu-central-1.images.arcpublishing.com/prisa/ISIVZWUDWNG4LBXDCZSPMWWMC4.jpg",
            "https://elpais.com/tecnologia/2022-10-25/whatsapp-sufre-una-caida.html")
        val not3 = Noticia(3,"Antón gana el pulso a todo un país",
            "Cuando Antón acudió al Campeonato de España de lucha de brazos muchos acabaron preguntando dónde estaba Betanzos. Porque este joven de 27 años acababa de ganar el título nacional en la categoría de principiantes de lo que se conoce popularmente como echar pulsos.",
            "22/10/2022",
            "https://cflvdg.avoz.es/sc/8QG3OpbnxqywKTR7WrnfIqkOlpQ=/768x/2022/10/22/00121666451942268149912/Foto/HO23C8F1_171756.jpg",
            "https://www.lavozdegalicia.es/noticia/coruna/betanzos/2022/10/23/anton-gana-pulso-pais/0003_202210H23C8991.htm")
        val not4 = Noticia(4,"WhatsApp sufre una caída de sus servicios",
            "La aplicación de mensajería instantánea ha experimentado fallos en varios países durante dos horas, entre las nueve y las once, hora peninsular española",
            "25/10/2022",
            "https://imagenes.elpais.com/resizer/5t-bXjPA3wENZpJaaBfF5Tr88UQ=/1960x0/cloudfront-eu-central-1.images.arcpublishing.com/prisa/ISIVZWUDWNG4LBXDCZSPMWWMC4.jpg",
            "https://elpais.com/tecnologia/2022-10-25/whatsapp-sufre-una-caida.html")
        val not5 = Noticia(5,"Antón gana el pulso a todo un país",
            "Cuando Antón acudió al Campeonato de España de lucha de brazos muchos acabaron preguntando dónde estaba Betanzos. Porque este joven de 27 años acababa de ganar el título nacional en la categoría de principiantes de lo que se conoce popularmente como echar pulsos.",
            "22/10/2022",
            "https://cflvdg.avoz.es/sc/8QG3OpbnxqywKTR7WrnfIqkOlpQ=/768x/2022/10/22/00121666451942268149912/Foto/HO23C8F1_171756.jpg",
            "https://www.lavozdegalicia.es/noticia/coruna/betanzos/2022/10/23/anton-gana-pulso-pais/0003_202210H23C8991.htm")
        val not6 = Noticia(6,"WhatsApp sufre una caída de sus servicios",
            "La aplicación de mensajería instantánea ha experimentado fallos en varios países durante dos horas, entre las nueve y las once, hora peninsular española",
            "25/10/2022",
            "https://imagenes.elpais.com/resizer/5t-bXjPA3wENZpJaaBfF5Tr88UQ=/1960x0/cloudfront-eu-central-1.images.arcpublishing.com/prisa/ISIVZWUDWNG4LBXDCZSPMWWMC4.jpg",
            "https://elpais.com/tecnologia/2022-10-25/whatsapp-sufre-una-caida.html")

        noticias.add(not1)
        noticias.add(not2)
        noticias.add(not3)
        noticias.add(not4)
        noticias.add(not5)
        noticias.add(not6)

        return noticias
    }

    override fun onClick(noticia: Noticia, position: Int) {

    }
}