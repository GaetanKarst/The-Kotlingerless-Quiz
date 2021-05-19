package com.example.quiz_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.content.Intent
import android.widget.Button
import org.w3c.dom.Text


class EndScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_end_screen)

        val name = intent.getStringExtra("EXTRA_NAME")
        val score = intent.getStringExtra("EXTRA_SCORE");
        val nameField = findViewById<TextView>(R.id.name_display)
        val scoreField = findViewById<TextView>(R.id.score_display);
        nameField.setText("🎉 $name your finsished the Kotlingerless Quiz! 🎉");
        scoreField.setText("Your got $score right answers!");

        onClickRestartButton();
    }

    private fun onClickRestartButton() : Unit {
        val restartButton = findViewById<Button>(R.id.restart_button);
        restartButton.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java);
            startActivity(intent);
        }

    }
}