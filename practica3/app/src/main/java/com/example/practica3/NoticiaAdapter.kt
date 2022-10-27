package com.example.practica3

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat.startActivity
import androidx.core.os.persistableBundleOf
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.example.practica3.databinding.ItemNoticiaBinding

class NoticiaAdapter
    (private val noticias: List<Noticia>,private val listener: OnClickListener): RecyclerView.Adapter<NoticiaAdapter.ViewHolder>()

{

    private lateinit var context: Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        context = parent.context

        val view = LayoutInflater.from(context).inflate(R.layout.item_noticia,parent,false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val noticia = noticias.get(position)

        with(holder) {
            setListener(noticia)
            binding.tvContent.text = noticia.resumen
            binding.tvName.text = noticia.titulo
            Glide.with(context)
                .load(noticia.imagen)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .centerCrop()
                .circleCrop()
                .into(binding.imgPhoto)
        }
    }

    override fun getItemCount(): Int = noticias.size

    inner class ViewHolder(view : View): RecyclerView.ViewHolder(view){
        val binding = ItemNoticiaBinding.bind(view)

        fun setListener(noticia:Noticia) {
            binding.root.setOnClickListener{
                listener.onClick(noticia,position)
            }
            binding.noticia.setOnClickListener{
                    val url = Intent(Intent.ACTION_VIEW)
                    url.data = Uri.parse(noticia.enlace)
                    startActivity(context,url,null)
            }
        }



    }


}