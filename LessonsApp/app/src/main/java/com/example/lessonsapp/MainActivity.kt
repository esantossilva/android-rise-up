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
        const val CONTACT_ID = "iqhwudh83hois"
        const val EMAIL_KEY = "98ueh18e"
        const val EMAIL_KEY_EXTRA = "98392h37h923e-1093ie"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Cria o binding
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Cria a lista de contatos
        val contactDb = ContactRepositoryFake()

        preferences = getSharedPreferences(PREFERENCES_NAME, MODE_PRIVATE)

        // Criar adapter
        val recyclerAdapter = MyRecyclerAdapter(this, contactDb.getContactList())
        recyclerAdapter.setItemClickListener {
            val intent = Intent(this, Activity3::class.java)
            intent.putExtra(CONTACT_ID, it.id)
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