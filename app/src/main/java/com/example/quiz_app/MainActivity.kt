package com.example.quiz_app

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.security.KeyChain.EXTRA_NAME
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super. onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Hide status bar for immersive purpose (method deprecated on Android30)
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN

        startButtonListen();

    }

    private fun startButtonListen() {
        val startButton = findViewById<Button>(R.id.start_button);
        val etName = findViewById<androidx.appcompat.widget.AppCompatEditText>(R.id.et_name);

        startButton.setOnClickListener {
            if (etName.text.toString().isEmpty()) {
                println("Empty input field!");
                Toast.makeText(this, "Enter your name to start!", Toast.LENGTH_SHORT).show();
            } else {
                // Gets players' input name to pass it across activities and Finished the current activity
                getPlayerName();
                finish();
            }
        }
    }

    private fun getPlayerName() {
        val nameField = findViewById<EditText>(R.id.et_name);
        val name = nameField.text.toString();
        val intent = Intent(this, QuestionActivity::class.java).apply {
            putExtra(EXTRA_NAME, name);
        }
        startActivity(intent);
    }
}