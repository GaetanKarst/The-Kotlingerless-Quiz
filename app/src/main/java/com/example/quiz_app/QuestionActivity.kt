package com.example.quiz_app

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.text.method.LinkMovementMethod
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import java.util.*
import kotlin.collections.ArrayList

var questionIndex: Int = 0;
var score: Int = 0;
val questionList = Constants.getQuestions();

class QuestionActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_question)


        displayQuestion(questionList, questionIndex);
    }

    private fun displayQuestion(list: ArrayList<Question>, index: Int): Unit {
        val questionText = findViewById<TextView>(R.id.question_text);
        val questionImage = findViewById<ImageView>(R.id.question_image);
        val answer1 = findViewById<TextView>(R.id.question_answer_1);
        val answer2 = findViewById<TextView>(R.id.question_answer_2);
        val answer3 = findViewById<TextView>(R.id.question_answer_3);
        val answer4 = findViewById<TextView>(R.id.question_answer_4);

        // TODO: Make it button but can't figure out how to set the text of an XML button element
        // TODO: Make a progressBar!
        questionText.setText(list.get(index).question);
//        questionImage.setImageResource(list.get(index).image);

        answer1.setText(list.get(index).answerOne)
        answer1.setOnClickListener() {
            answerClicked(answer1, questionIndex);
        }
        answer2.setText(list.get(index).answerTwo);
        answer2.setOnClickListener() {
            answerClicked(answer2, questionIndex);
        }
        answer3.setText(list.get(index).answerThree);
        answer3.setOnClickListener() {
            answerClicked(answer3, questionIndex);
        }
        answer4.setText(list.get(index).answerFour);
        answer4.setOnClickListener() {
            answerClicked(answer4, questionIndex);
        }
    }

    private fun answerClicked(selectedAnswer: TextView, index: Int): Boolean {
        val defaultTextColor: Int = selectedAnswer.getTextColors().getDefaultColor();

        if (selectedAnswer.text.toString() == questionList.get(index).correctAnswer) {
            selectedAnswer.setTextColor(Color.parseColor("#44FF99"));
            incrementScoreAndQuestionNb();
            Toast.makeText(this, "Correct Answer!🎉", Toast.LENGTH_SHORT).show();
            Handler().postDelayed({
                selectedAnswer.setTextColor(Color.parseColor("#000000"))
                showNextQuestion();
            }, 2000);

            return true;
        }

        selectedAnswer.setTextColor(Color.parseColor("#FE0805"));
        Toast.makeText(this, "Wrong Answer!😵", Toast.LENGTH_SHORT).show();
        Handler().postDelayed({
            selectedAnswer.setTextColor(Color.parseColor("#000000"))
            questionIndex++;
            showNextQuestion();
        }, 2000);

        return false;
    }

    private fun showNextQuestion(): Unit {
        if (questionIndex >= questionList.size) {
            finishTheGame();
        }else {
        displayQuestion(questionList, questionIndex);
        }
    }

    private fun displayScore() : Unit {
        val scoreField = findViewById<TextView>(R.id.score_display);
        scoreField.setText(score.toString());
    }

    private fun incrementScoreAndQuestionNb(): Unit {
        score++;
        displayScore();
        questionIndex++;
    }

    private fun finishTheGame(): Unit {
        val scoreString = score.toString();
//        val name = intent.getStringExtra("EXTRA_NAME");
//
//        val intentName = Intent(this, EndScreen::class.java).apply {
//            putExtra(EXTRA_NAME, name)
//        }
        val intent = Intent(this, EndScreen::class.java);
        startActivity(intent);
        finish();
    }
}