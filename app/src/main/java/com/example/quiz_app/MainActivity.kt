package com.example.quiz_app

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Hide status bar for immersive purpose (method deprecated on Android30)
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN

        val startButton = findViewById<Button>(R.id.start_button)
        val etName = findViewById<androidx.appcompat.widget.AppCompatEditText>(R.id.et_name)

        startButton.setOnClickListener {
            if (etName.text.toString().isEmpty()){
                println("Empty input field!")
                Toast.makeText(this, "Enter your name to start!", Toast.LENGTH_SHORT).show()
            }
        }
    }
}