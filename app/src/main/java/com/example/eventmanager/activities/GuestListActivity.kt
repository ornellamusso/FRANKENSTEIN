package com.example.eventmanager.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import com.example.eventmanager.R
import com.example.eventmanager.databinding.ActivityGuestAddBinding
import com.example.eventmanager.databinding.ActivityGuestListBinding
import com.example.eventmanager.databinding.ActivityMainBinding

class GuestListActivity : AppCompatActivity() {
    private lateinit var binding: ActivityGuestListBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityGuestListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btAdd.setOnClickListener {
            navigateToAdd()
        }

    }
    private fun navigateToAdd() {
        val intent = Intent(this, GuestAddActivity::class.java)
        startActivity(intent)
    }
}