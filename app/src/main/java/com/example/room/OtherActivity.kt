package com.example.room

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.room.Room
import com.example.room.databinding.ActivityMainBinding
import com.example.room.databinding.ActivityOtherBinding

class OtherActivity : AppCompatActivity() {
    lateinit var db: AppDatabase
    lateinit var binding: ActivityOtherBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOtherBinding.inflate(layoutInflater)
        setContentView(binding.root)

        db = Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java, "pokedex-db"
        ).build()

        //createPokemon()
    }
}