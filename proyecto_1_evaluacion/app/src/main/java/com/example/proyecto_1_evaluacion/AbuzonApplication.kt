package com.example.proyecto_1_evaluacion

import android.app.Application
import androidx.room.Room

class AbuzonApplication : Application() {
    companion object {
        lateinit var database: AbuzonDatabase
    }

    override fun onCreate() {
        super.onCreate()
        database = Room.databaseBuilder(
            this,
            AbuzonDatabase::class.java,
            "AbuzonDatabase")
            .allowMainThreadQueries()
            .build()

    }

}