package com.edwinacubillos.misdeudores.data.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tabla_usuario")
data class Usuario (
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "id") val id: Int,
    @ColumnInfo(name = "email")val email: String? = null,
    @ColumnInfo(name = "contrasena")val contrasena: String? = null,
)