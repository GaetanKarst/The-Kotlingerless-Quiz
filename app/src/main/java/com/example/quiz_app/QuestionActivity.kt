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
        val answer1 = findViewById<TextView>(R.id.question_answer_1);
        val answer2 = findViewById<TextView>(R.id.question_answer_2);
        val answer3 = findViewById<TextView>(R.id.question_answer_3);
        val answer4 = findViewById<TextView>(R.id.question_answer_4);

        // TODO: Make it button but can't figure out how to set the text of an XML button element
        questionText.setText(list.get(index).question);
        answer1.setText(list.get(index).answerOne)
        answer1.setOnClickListener() {
            println("Answer 1 clicked")
        }
        answer2.setText(list.get(index).answerTwo);
        answer2.setOnClickListener() {
            println("Answer 2 clicked")
        }
        answer3.setText(list.get(index).answerThree);
        answer3.setOnClickListener() {
            println("Answer 3 clicked")
        }
        answer4.setText(list.get(index).answerFour);
        answer4.setOnClickListener() {
            println("Answer 4 clicked")
        }
    }

    //TODO: Put the onResume function here to handle right answer and increase question index + score
}