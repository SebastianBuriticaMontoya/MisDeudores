package com.edwinacubillos.misdeudores.data.database.dao

import androidx.room.*
import com.edwinacubillos.misdeudores.data.database.entities.Usuario

@Dao
interface UsuarioDAO {
    @Insert
    fun insertUsuario(usuario: Usuario)

    @Query("SELECT * FROM tabla_usuario where email LIKE :email")
    fun searchDeudor(email: String): Usuario

}