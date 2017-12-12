package com.example.opilane.quiz2;



class questions {
    //array of questions
    private String MyQuestions [] = {
            "WWW stands for ?",
            "Which of the following are components of Central Processing Unit (CPU) ",
            "Which among following first generation of computers had ??",
            "Where is RAM located ",
            "f a computer has more than one processor then it is known as ?"
    };

    //array of multiple choices for each question
    private String MyChoices [] [] = {
            {"World Whole Web", "Wide World Web", "Web World Wide", "World Wide Web"},
            {"Arithmetic logic unit, Mouse", "Arithmetic logic unit, Control unit", "Arithmetic logic unit, Integrated Circuits", "Control Unit, Monitor"},
            {"Vaccum Tubes and Magnetic Drum", "Integrated Circuits", "Magnetic Tape and Transistors", "All of above"},
            {"Expansion Board", "External Drive", "Mother Board", "All of above"},
            {"Uniprocess", "Multiprocessor", "Multithreaded", "Multiprogramming"}
    };

    //array of correct answers - in the same order as array of questions
    private String MyCorrectAnswers [] = {
            "World Wide Web", "Arithmetic logic unit, Control unit", "Vaccum Tubes and Magnetic Drum", "Mother Board", "Multiprocessor"
    };
    //method returns number of questions
    int getLength() {
        return MyQuestions.length;
    }
    //method returns question from array MyQuestions[] based on array index
    String getQuestion(int a) {
        return MyQuestions[a];
    }
    // method returns a single multiple choice item for question based on array index,
    // based on number of multiple choice item in the list - 1, 2, 3 or 4 as an argument
    String getChoice(int index, int num) {
        return MyChoices[index][num -1];
    }
    //method returns correct answer for the question based on array index
    String getCorrectAnswer(int a) {
        return MyCorrectAnswers[a];
    }
}

