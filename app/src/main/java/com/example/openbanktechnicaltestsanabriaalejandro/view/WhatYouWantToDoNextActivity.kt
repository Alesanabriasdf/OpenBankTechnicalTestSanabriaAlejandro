package com.example.openbanktechnicaltestsanabriaalejandro.view

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.openbanktechnicaltestsanabriaalejandro.databinding.ActivityWhatYouWantToDoNextBinding

class WhatYouWantToDoNextActivity : AppCompatActivity() {

    private lateinit var binding: ActivityWhatYouWantToDoNextBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWhatYouWantToDoNextBinding.inflate(layoutInflater)
        setContentView(binding.root)
        init()
    }
    private fun init () {
        binding.btnMoveBack.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            this.startActivity(intent)
        }
        binding.btnToComics.setOnClickListener {
            Toast.makeText(this,"Now you would send to a screen with Comics, for example",Toast.LENGTH_LONG).show()
        }
    }
}