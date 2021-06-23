package com.example.quiz_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.content.Intent
import android.widget.Button
import android.widget.ImageView
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
        insertSuccessImage();
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
        nameField.setText("🎉 $name you finished the Kotlingerless Quiz! 🎉");
    }

    private fun displayPlayerScore() : Unit {
        val score = intent.getStringExtra("EXTRA_SCORE");

        val scoreField = findViewById<TextView>(R.id.score_display);
        scoreField.setText("You got ${score} right answers!");
    }

    private fun insertSuccessImage() : Unit {
        val imageField = findViewById<ImageView>(R.id.succes_image);
        imageField.setImageResource(R.drawable.greatjob);
    }

    //TODO: make the scoreboard work
    private fun fetchScoreBoard() : Unit {
        val name1 = findViewById<TextView>(R.id.name1);
        val score1 = findViewById<TextView>(R.id.score1);

        val queue = Volley.newRequestQueue(this);
        val url = "http://192.168.0.100:8080"

        val scoreRequest = StringRequest(
            Request.Method.GET, url,
            { response -> name1.text = response;},
            { name1.text = "ERROR DATA"; score1.text = "ERROR DATA" });

        queue.add(scoreRequest);
    }
}