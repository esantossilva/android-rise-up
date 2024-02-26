package com.example.lessonsapp

import android.content.SharedPreferences
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainActivity3 : AppCompatActivity() {

    private lateinit var preferences: SharedPreferences

    companion object {
        const val PREFERENCES_NAME = "ashe728y9e2h387"
        const val KEY_LEVEL = "qi92ye9y2"
        const val KEY_APP_TYPE = "9u23e92klasfdsv"
        const val KEY_FAVORITE_PROGRAMMING_LANGUAGE = "9y8239d23"
        const val KEY_LEARN = "098sd8f7hifh984"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)

        preferences = getSharedPreferences(MainActivity.PREFERENCES_NAME, MODE_PRIVATE)

        val userLevel = preferences.getString(KEY_LEVEL, "")
    }
}