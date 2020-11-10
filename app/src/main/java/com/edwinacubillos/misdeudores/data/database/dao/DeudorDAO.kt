package com.edwinacubillos.misdeudores.data.database.dao

import androidx.room.*
import com.edwinacubillos.misdeudores.data.database.entities.Deudor


@Dao
interface DeudorDAO {
    @Insert
    fun insertDeudor(deudor: Deudor)

    @Query("SELECT * FROM tabla_deudor where nombre LIKE :nombre")
    fun searchDeudor(nombre: String): Deudor

    @Delete
    fun deleteDeudor(deudor: Deudor)

    @Update
    fun updateDeudor(deudor: Deudor)

    @Query("SELECT * FROM TABLA_DEUDOR")
    fun getDeudores():MutableList<Deudor>
}