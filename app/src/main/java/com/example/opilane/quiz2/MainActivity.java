package com.example.opilane.quiz2;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.content.Intent;
import android.widget.Toast;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private questions MyQuestions = new questions();

    private Button choice1; //multible choice1 from Questions
    private Button choice2; //multible choice2 from Questions
    private Button choice3; //multible choice3 from Questions
    private Button choice4; //multible choice4 from Questions
    private TextView score; //view for current total score
    private TextView question; // current question to answer
    private String MyAnswer; // correct answer for question
    private int MyScore = 0; // current total score
    private int MyQuestionNumber = 0; // current question number


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //setup screen for the first question with four alternative answers
        choice1 = findViewById(R.id.choice1);
        choice2 = findViewById(R.id.choice2);
        choice3 = findViewById(R.id.choice3);
        choice4 = findViewById(R.id.choice4);
        score = findViewById(R.id.score);
        question = findViewById(R.id.question);
        updateQuestion();
        // show current total score for the user
        updateScore();
    }
        @SuppressLint("SetTextI18n")
        private void updateScore() {
            score.setText("" + MyScore + "/" + MyQuestions.getLength());
        }
        private void updateQuestion() {
            // check if we are not outside array bounds for questions
            if (MyQuestionNumber < MyQuestions.getLength()){
                // set the text for new question, and new 4 alternative to answer on four buttons

                question.setText(MyQuestions.getQuestion(MyQuestionNumber));
                choice1.setText(MyQuestions.getChoice(MyQuestionNumber, 1));
                choice2.setText(MyQuestions.getChoice(MyQuestionNumber, 2));
                choice3.setText(MyQuestions.getChoice(MyQuestionNumber, 3));
                choice4.setText(MyQuestions.getChoice(MyQuestionNumber, 4));
                MyAnswer = MyQuestions.getCorrectAnswer(MyQuestionNumber);
                MyQuestionNumber++;
            }
            else {
                Toast.makeText(MainActivity.this, "It was the last question!", Toast.LENGTH_SHORT).show();
                //last question, create new activity & show current and highest score
                //we use intent which is responsible for providing switch between current activity and new one
                Intent intent = new Intent(MainActivity.this, highest_score_activity.class);
                intent.putExtra("score", MyScore);// pass the current score to the second screen
                startActivity(intent);
            }
        }
        public void onClick(View view) {
            //all logic for all answer buttons in one method
            Button answer = (Button) view;
            // if the answer is correct, increase the score
            if (answer.getText() == MyAnswer) {
                MyScore = MyScore + 1;
                Toast.makeText(MainActivity.this, "Correct!", Toast.LENGTH_SHORT).show();
            } else
                Toast.makeText(MainActivity.this, "Wrong!", Toast.LENGTH_SHORT).show();
            // show current total score for the user
            updateScore();
            // once the user answers the question we move on to the next one
            updateQuestion();


        }
}
