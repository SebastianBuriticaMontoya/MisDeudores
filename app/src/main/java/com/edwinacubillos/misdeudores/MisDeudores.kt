package com.edwinacubillos.misdeudores

import android.app.Application
import androidx.room.Room
import com.edwinacubillos.misdeudores.data.database.DeudorDatabase

class MisDeudores : Application() {

    companion object{
        lateinit var database: DeudorDatabase
    }

    override fun onCreate() {
        super.onCreate()

        database =  Room.databaseBuilder(
            this,
            DeudorDatabase::class.java,
            "deudor_DB"
        ).allowMainThreadQueries()
            .build()

    }
}