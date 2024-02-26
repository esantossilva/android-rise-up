package com.example.lessonsapp

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.lessonsapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var preferences: SharedPreferences

    companion object {
        const val PREFERENCES_NAME = "ashe728y9e2h387"
        const val EMAIL_KEY = "98ueh18e"
        const val EMAIL_KEY_EXTRA = "98392h37h923e-1093ie"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Cria o binding
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Cria a lista de contatos
        val contactList = listOf(
            Contact(1, "João", "joao@gmail.com", "8199990001"),
            Contact(2, "Amanda", "amanda@gmail.com", "8199990002"),
            Contact(3, "José", "jose@gmail.com", "8199990003"),
            Contact(4, "Cecília", "cecilia@gmail.com", "8199990004"),
        )

        preferences = getSharedPreferences(PREFERENCES_NAME, MODE_PRIVATE)

        // Criar adapter
        val recyclerAdapter = MyRecyclerAdapter(this, contactList)
        recyclerAdapter.setItemClickListener {
            val intent = Intent(this, OnboardingQuizActivity::class.java)
            intent.putExtra(EMAIL_KEY_EXTRA, it.email)
            startActivity(intent)
        }

        binding.button.setOnClickListener {
            goToNextActivity()
        }

        // Atribuir o adapter ao RecyclerView (rvContacts)
        binding.rvContacts.apply {
            adapter = recyclerAdapter
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        }
    }

    private fun goToNextActivity() {
        val intent = Intent(this, OnboardingQuizActivity::class.java)
        startActivity(intent)
    }
}