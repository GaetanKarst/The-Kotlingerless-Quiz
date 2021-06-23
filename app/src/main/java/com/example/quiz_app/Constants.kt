package com.example.quiz_app

// Questions for DEMO purposes

object Constants {
    fun getQuestions(): ArrayList<Question> {
        val questionsList = ArrayList<Question>();

        // TODO: Refactor to be scalable
        val question1 = Question(1, "What is the capital of Nicaragua?", R.drawable.nicaragua_capital,
            "Mexico", "Managua", "Bogota", "Tokyo", "Managua" );

        val question2 = Question(2, "What was the name Romans gave to Scotland?", R.drawable.roman_empire,
        "Dacia", "Gallia", "Caledonia", "Pannonia", "Caledonia");

        val question3 = Question(3, "How many pair of legs does a lobster have?", R.drawable.lobster,
        "10", "6", "5", "4", "5");

        val question4 = Question(4, "Which country has the longest coastline in the world",
            R.drawable.coastline,
        "Russia", "Canada","Australia", "Japan", "Canada");

        val question5 = Question(5, "What major programming languages was invented in 1972?", R.drawable.programming,
        "C", "Pascal", "Fortran", "Cobol", "C")

        val question6 = Question(5, "What major programming languages was invented in 1972?", R.drawable.programming,
            "C", "Pascal", "Fortran", "Cobol", "C")

        questionsList.add(question1);
        questionsList.add(question2);
        questionsList.add(question3);
        questionsList.add(question4);
        questionsList.add(question5);

        return questionsList;
    }
}