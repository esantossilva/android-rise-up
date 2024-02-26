package com.example.lessonsapp

import android.content.SharedPreferences
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.lessonsapp.databinding.Activity3Binding

class Activity3 : AppCompatActivity() {

    private lateinit var binding: Activity3Binding
    private lateinit var preferences: SharedPreferences

    companion object {
        const val PREFERENCES_NAME = "ashe728y9e2h387"
        const val CONTACT_ID = "iqhwudh83hois"
        const val KEY_LEVEL = "qi92ye9y2"
        const val KEY_APP_TYPE = "9u23e92klasfdsv"
        const val KEY_FAVORITE_PROGRAMMING_LANGUAGE = "9y8239d23"
        const val KEY_LEARN = "098sd8f7hifh984"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        preferences = getSharedPreferences(MainActivity.PREFERENCES_NAME, MODE_PRIVATE)

        // Cria o binding
        binding = Activity3Binding.inflate(layoutInflater)
        setContentView(binding.root)

        ContactRepositoryFake().getContact(getUserId())?.let {
            with(binding) {
                tvUserName.text = it.name
                tvUserEmail.text = it.email
                tvUserPhone.text = it.phoneNumber
            }
        }
    }

    private fun getUserId() = intent.getIntExtra(CONTACT_ID, 1)
}