package com.example.eventmanager.activities

import android.content.Intent
import android.media.metrics.Event
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import com.example.eventmanager.R
import com.example.eventmanager.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonInvitados.setOnClickListener {

            navigateToGuestList()


        }

        binding.buttonEventos.setOnClickListener {
            navigateToEventList()
        }

    }


    private fun navigateToGuestList() {
        val intent = Intent(this, GuestListActivity::class.java)
        startActivity(intent)
    }
    private fun navigateToEventList() {
        val intent = Intent(this, EventListActivity::class.java)
        startActivity(intent)
    }


}