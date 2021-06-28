package com.example.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.room.DAO.PokemonDao
import com.example.room.models.Pokemon

@Database(entities = arrayOf(Pokemon::class), version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun pokemonDao(): PokemonDao
}