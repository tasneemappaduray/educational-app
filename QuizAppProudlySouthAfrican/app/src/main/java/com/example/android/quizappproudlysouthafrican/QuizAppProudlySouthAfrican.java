package com.example.android.quizappproudlysouthafrican;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class QuizAppProudlySouthAfrican extends AppCompatActivity {

    private RadioButton questionOneOptionThree;
    private RadioButton questionTwoOptionThree;
    private RadioButton questionThreeOptionTwo;
    private RadioButton questionFourOptionThree;
    private CheckBox questionFiveOptionOne;
    private CheckBox questionFiveOptionThree;
    private CheckBox questionFiveOptionFour;
    private EditText questionSixAnswerText;
    public int score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_app_proudly_south_african);

    }

    public void submitButton(View view) {

        //Gets the name of the customer
        EditText name = (EditText) findViewById(R.id.name_view);
        String nameOfPerson = name.getText().toString();

        //Declare variables
        questionOneOptionThree = findViewById(R.id.question_1_option_3);
        questionTwoOptionThree = findViewById(R.id.question_2_option_3);
        questionThreeOptionTwo = findViewById(R.id.question_3_option_2);
        questionFourOptionThree = findViewById(R.id.question_4_option_3);
        questionFiveOptionOne = findViewById(R.id.question_5_option_1);
        questionFiveOptionThree = findViewById(R.id.question_5_option_3);
        questionFiveOptionFour = findViewById(R.id.question_5_option_4);
        questionSixAnswerText = findViewById(R.id.question_6_answer_text);
        boolean isQuestionOneOptionThree = questionOneOptionThree.isChecked();
        boolean isQuestionTwoOptionThree = questionTwoOptionThree.isChecked();
        boolean isQuestionThreeOptionTwo = questionThreeOptionTwo.isChecked();
        boolean isQuestionFourOptionThree = questionFourOptionThree.isChecked();
        boolean isQuestionFiveOptionOne = questionFiveOptionOne.isChecked();
        boolean isQuestionFiveOptionThree = questionFiveOptionThree.isChecked();
        boolean isQuestionFiveOptionFour = questionFiveOptionFour.isChecked();
        String answerText = questionSixAnswerText.getText().toString();
        int score = calculate(isQuestionOneOptionThree,isQuestionTwoOptionThree,
                              isQuestionThreeOptionTwo, isQuestionFourOptionThree,isQuestionFiveOptionOne,isQuestionFiveOptionThree,
                              isQuestionFiveOptionFour, answerText);
        String message = answersSummary(nameOfPerson, score, isQuestionOneOptionThree,
                                        isQuestionTwoOptionThree, isQuestionThreeOptionTwo, isQuestionFourOptionThree, isQuestionFiveOptionOne,
                                        isQuestionFiveOptionThree, isQuestionFiveOptionFour, answerText);
        displayMessage(message);

    }

    public void displayMessage(String message){
        TextView displayMessageTextView = (TextView) findViewById(R.id.display_message_text_view);
        displayMessageTextView.setText(message);
    }


    /**
     * This method is called to calculate the correct answers when the score button is clicked.
     */
    private int calculate(boolean isQuestionOneOptionThree, boolean isQuestionTwoOptionThree,
                          boolean isQuestionThreeOptionTwo, boolean isQuestionFourOptionThree,
                          boolean isQuestionFiveOptionOne, boolean isQuestionFiveOptionThree,
                          boolean isQuestionFiveOptionFour, String answerText) {
        if(isQuestionOneOptionThree){
            score = score + 1;
        }

        if(isQuestionTwoOptionThree){
            score = score + 1;
        }

        if(isQuestionThreeOptionTwo){
            score = score + 1;
        }

        if(isQuestionFourOptionThree){
            score = score + 1;
        }

        if(isQuestionFiveOptionOne && isQuestionFiveOptionThree && isQuestionFiveOptionFour){
            score = score + 1;
        }

        if(answerText.trim().equalsIgnoreCase("Rand")) {
            score = score + 1;
        }

        return score;
    }


    /**
    This method creates a summary of the answers
    @param  name of the person taking the quiz
     @param score calculates how many questions was questions was correctly answered
     @param isQuestionOneOptionThree is whether or not Question one is correct
     @param isQuestionTwoOptionThree is whether or not Question two is correct
     @param isQuestionThreeOptionTwo is whether or not Question three is correct
     @param isQuestionFourOptionThree is whether or not Question four is correct
     @param isQuestionFiveOptionOne is whether or not Question five option one is correct
     @param isQuestionFiveOptionThree is whether or not Question five option three is correct
     @param isQuestionFiveOptionFour is whether or not Question five option four is correct
     @param answerText is whether the text entered is correct
     */

    public String answersSummary(String name,int score, boolean isQuestionOneOptionThree,
                                 boolean isQuestionTwoOptionThree, boolean isQuestionThreeOptionTwo,
                                 boolean isQuestionFourOptionThree, boolean isQuestionFiveOptionOne,
                                 boolean isQuestionFiveOptionThree, boolean isQuestionFiveOptionFour,
                                 String answerText){
        String message = getString(R.string.answers_summary_name, name);
        message += "\n Question 1: " + isQuestionOneOptionThree;
        message += "\n Question 2: " + isQuestionTwoOptionThree;
        message += "\n Question 3: " + isQuestionThreeOptionTwo;
        message += "\n Question 4: " + isQuestionFourOptionThree;

        //If all these conditions are true statement will execute otherwise else statement will execute
        if(isQuestionFiveOptionOne && isQuestionFiveOptionThree && isQuestionFiveOptionFour){
            message += "\n Question 5: true";
        } else {
            message += "\n Question 5: false";
        }

        //If text value is equal to rand Statement will execute otherwise else statement will execute
        if(answerText.trim().equalsIgnoreCase("Rand")){
            message += "\n Question 6: Rand is correct";
        } else {
            message += "\n Question 6: incorrect answer";
        }

        //Toast message will display how many questions was correctly answered
        Toast.makeText(this, "Whoo hoo! You answered " + score + " questions correctly.", Toast.LENGTH_LONG).show();
        message += "\n You've got " + score + " correct answer.";
        return message;
    }
}
