package com.example.room.DAO

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.room.models.Pokemon

@Dao
interface PokemonDao {
    @Query("SELECT * FROM pokemons")
    fun getAll(): List<Pokemon>

    @Insert
    suspend fun insertAll(vararg pokemon: Pokemon)

}