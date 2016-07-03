package com.example.android.project_3;

import android.annotation.TargetApi;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    @TargetApi(Build.VERSION_CODES.KITKAT)
    public void submitAnswers(View view) {
        int score = 0;
        //Store checkboxes in variable
        CheckBox answer1 = (CheckBox) findViewById(R.id.answer1);
        CheckBox answer2 = (CheckBox) findViewById(R.id.answer2);
        CheckBox answer3 = (CheckBox) findViewById(R.id.answer3);
        CheckBox answer4 = (CheckBox) findViewById(R.id.answer4);
        boolean isAnswer1checked = answer1.isChecked();
        boolean isAnswer2checked = answer2.isChecked();
        boolean isAnswer3checked = answer3.isChecked();
        boolean isAnswer4checked = answer4.isChecked();

        //Store radio button in variable
        RadioButton radio1 = (RadioButton) findViewById(R.id.radioButton_1);
        RadioButton radio2 = (RadioButton) findViewById(R.id.radioButton_2);
        RadioButton radio3 = (RadioButton) findViewById(R.id.radioButton_3);
        RadioButton radio4 = (RadioButton) findViewById(R.id.radioButton_4);

        RadioGroup answerGroup_1 = (RadioGroup) findViewById(R.id.radioGroup_1);
        RadioGroup answerGroup_2 = (RadioGroup) findViewById(R.id.radioGroup_2);
        boolean rightAnswerChecked1 = radio2.isChecked();
        boolean rightAnswerChecked2 = radio4.isChecked();

        //Store EditText view
        EditText declareInt = (EditText) findViewById(R.id.declareInt);

        //Convert EditText view to string
        Editable declare = declareInt.getText();
        String declareToString = declare.toString();

        //See if user input is equal to correct answer
        String correctDeclaration = "int score = 3;";
        boolean isDeclarationCorrect = Objects.equals(declareToString, correctDeclaration);

        //Check if answers 1 are correct
        if (isAnswer1checked) {
            score++;
        }
        if (isAnswer2checked) {
            score++;
        }
        if (rightAnswerChecked1) {
            score++;
        }
        if (rightAnswerChecked2) {
            score++;
        }
        if (isDeclarationCorrect) {
            score++;

        }

        //Generate toast with percentage and score
        Toast scoreToast = Toast.makeText(getApplicationContext(), "Score: " + score + "/5 Percentage: " + percentage(score), Toast.LENGTH_SHORT);
        scoreToast.show();

    }

    //return percentage score
    public int percentage(int score) {
        int percent = score * 20;
        return percent;
    }
}
