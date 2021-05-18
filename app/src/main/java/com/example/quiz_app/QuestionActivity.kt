package com.example.quiz_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.method.LinkMovementMethod
import android.widget.Button
import android.widget.TextView

class QuestionActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_question)

        val questionIndex: Int = 0;
        val score: Int = 0;
        val questionList = Constants.getQuestions();

        displayQuestion(questionList, questionIndex, score);
    }

    private fun displayQuestion(list : ArrayList<Question>, index: Int, score: Int) : Unit {
        val questionText = findViewById<TextView>(R.id.question_text);
        val questionAnswer1 = findViewById<TextView>(R.id.question_answer_1);
        val questionAnswer2 = findViewById<TextView>(R.id.question_answer_2);
        val questionAnswer3 = findViewById<TextView>(R.id.question_answer_3);
        val questionAnswer4 = findViewById<TextView>(R.id.question_answer_4);

        questionText.setText(list.get(index).question);
        questionAnswer1.setText(list.get(index).answerOne);
        questionAnswer1.setOnClickListener() {
            println("Answer1 clicked 🦉")
        }
        questionAnswer2.setText(list.get(index).answerTwo);
        questionAnswer3.setText(list.get(index).answerThree);
        questionAnswer4.setText(list.get(index).answerFour);
    }

    //TODO: Put the onResume function here to handle right answer and increase question index + score
}