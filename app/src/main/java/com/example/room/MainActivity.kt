package com.example.room

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.lifecycle.lifecycleScope
import androidx.room.Room
import com.example.room.databinding.ActivityMainBinding
import com.example.room.models.Pokemon
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    lateinit var db: AppDatabase
    lateinit var binding: ActivityMainBinding

    val getPokemon = registerForActivityResult(CreatePokemonContract()){

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        db = Room.databaseBuilder(
                applicationContext,
        AppDatabase::class.java, "pokedex-db"
        ).build()

        createPokemon()
    }

    fun onClickButton(view: View){
        getPokemon.launch(Unit)
    }

   private fun createPokemon(){
       val Pikachu = Pokemon("Pikachu")
       val Ronflex = Pokemon("Ronflex")

       lifecycleScope.launch(Dispatchers.IO) {
           db.pokemonDao().insertAll(Pikachu,Ronflex)
           Log.i("ASYNCINFO", "pokemon inserted")
       }

       Log.i("ASYNCINFO", "End od CreatePokemon")
   }

}