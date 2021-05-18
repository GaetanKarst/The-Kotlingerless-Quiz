package com.example.quiz_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class QuestionActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_question)

        val questionList = Constants.getQuestions();

        displayQuestion1(questionList);
    }

    private fun displayQuestion1(list : ArrayList<Question>) : Unit {
        val questionText = findViewById<TextView>(R.id.question_text);
        questionText.setText(list.get(0).question);
        println(list.get(0));

    }
}