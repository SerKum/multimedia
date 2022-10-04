package com.example.practica1

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import com.google.android.material.appbar.CollapsingToolbarLayout
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.example.practica1.databinding.ActivityScrollingBinding

class ScrollingActivity : AppCompatActivity() {
    private lateinit var binding: ActivityScrollingBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        binding = ActivityScrollingBinding.inflate(layoutInflater)
        setContentView(binding.root)

        cargarImagenes()
        binding.content.btn1.setOnClickListener{
            val url1 = Intent(android.content.Intent.ACTION_VIEW)
            url1.data = Uri.parse("https://es.wikipedia.org/wiki/Ibai_Llanos")
            startActivity(url1)
        }
        binding.content.btn2.setOnClickListener{
            val url1 = Intent(android.content.Intent.ACTION_VIEW)
            url1.data = Uri.parse("https://www.wikidata.org/wiki/Q109388431")
            startActivity(url1)
        }
        binding.content.btn3.setOnClickListener{
            val url1 = Intent(android.content.Intent.ACTION_VIEW)
            url1.data = Uri.parse("https://es.wikipedia.org/wiki/Lionel_Messi")
            startActivity(url1)
        }
        binding.content.btn4.setOnClickListener{
            val url1 = Intent(android.content.Intent.ACTION_VIEW)
            url1.data = Uri.parse("https://es.wikipedia.org/wiki/Fernando_Alonso")
            startActivity(url1)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_scrolling, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.

        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }


    private fun cargarImagenes(){
        val img1 = "https://fotografias.lasexta.com/clipping/cmsimages02/2020/06/07/A1058F5B-1E5B-4146-BC65-F4D8838F490B/97.jpg?crop=1131,636,x119,y0&width=1600&height=900&optimize=low&format=webply"
        val img2 = "https://pbs.twimg.com/profile_images/1284106200607596546/PKk7Nrci_400x400.jpg"
        val img3 = "https://pbs.twimg.com/profile_images/1291372653866033157/3PlDuuak_400x400.jpg"
        val img4 = "https://pbs.twimg.com/profile_images/1554022786884112384/gjo1iyvn_400x400.jpg"
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