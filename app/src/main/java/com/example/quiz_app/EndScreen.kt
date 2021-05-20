package com.example.quiz_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.content.Intent
import android.widget.Button
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import org.w3c.dom.Text


class EndScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_end_screen)

        displayPlayerName();
        displayPlayerScore();
        fetchScoreBoard();
        onClickRestartButton();

        

    }

    private fun onClickRestartButton() : Unit {
        val restartButton = findViewById<Button>(R.id.restart_button);
        restartButton.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java);
            finish();
            startActivity(intent);
        }

    }

    private fun displayPlayerName() : Unit {
        val name = intent.getStringExtra("EXTRA_NAME")
        val nameField = findViewById<TextView>(R.id.name_display)
        nameField.setText("🎉 $name your finsished the Kotlingerless Quiz! 🎉");
    }

    private fun displayPlayerScore() : Unit {
        val score = intent.getStringExtra("EXTRA_SCORE");
        val scoreField = findViewById<TextView>(R.id.score_display);
        scoreField.setText("Your got ${score} right answers!");
    }

    private fun fetchScoreBoard() : Unit {
        val name1 = findViewById<TextView>(R.id.name1);
        val score1 = findViewById<TextView>(R.id.score1);

        val queue = Volley.newRequestQueue(this);
        val url = "http://192.168.0.100:8080/scores"

        val scoreRequest = StringRequest(
            Request.Method.GET, url,
            { response -> name1.text = response;},
            { name1.text = "ERROR DATA"; score1.text = "ERROR DATA" });

        queue.add(scoreRequest);
    }
}