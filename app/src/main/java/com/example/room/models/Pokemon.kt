package com.example.room.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "pokemons")
data class Pokemon(
    @ColumnInfo(name = "name") val firstName: String?,
    @PrimaryKey(autoGenerate = true) val id: Int? = null,
)
