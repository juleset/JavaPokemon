package com.example.room

import android.app.Activity
import android.content.Context
import android.content.Intent
import androidx.activity.result.contract.ActivityResultContract
import com.example.room.models.Pokemon

class CreatePokemonContract : ActivityResultContract<Unit, Pokemon>() {
    override fun createIntent(context: Context, input: Unit?): Intent {
        return Intent(context, OtherActivity::class.java)
    }
    override fun parseResult(resultCode: Int, intent: Intent?): Pokemon {
        if (resultCode != Activity.RESULT_OK) {
            throw Exception()
        }
        val name = intent?.getStringExtra("name")!!
        return Pokemon(name)
    }
}
