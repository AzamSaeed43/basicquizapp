package com.example.basicquizapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class QuizActivity extends AppCompatActivity {

    int questionno=0;
    String selectedoption="";

    int result=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        TextView questions=findViewById(R.id.question);
        Button optionA=findViewById(R.id.optionA_btn);
        Button optionB=findViewById(R.id.optionB_btn);
        Button optionC=findViewById(R.id.optionC_btn);
        Button optionD=findViewById(R.id.optionD_btn);
        Button next_btn=findViewById(R.id.next_btn);


        questions.setText(QuizArray.questions[questionno]);
        optionA.setText(QuizArray.options[questionno][0]);
        optionB.setText(QuizArray.options[questionno][1]);
        optionC.setText(QuizArray.options[questionno][2]);
        optionD.setText(QuizArray.options[questionno][3]);

        optionA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                optionB.setBackgroundColor(getColor(R.color.black));
                optionC.setBackgroundColor(getColor(R.color.black));
                optionD.setBackgroundColor(getColor(R.color.black));
                selectedoption=QuizArray.options[questionno][0];
                optionA.setBackgroundColor(getColor(R.color.green));
            }
        });

        optionB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                optionA.setBackgroundColor(getColor(R.color.black));
                optionC.setBackgroundColor(getColor(R.color.black));
                optionD.setBackgroundColor(getColor(R.color.black));
                selectedoption=QuizArray.options[questionno][1];
                optionB.setBackgroundColor(getColor(R.color.green));
            }
        });

        optionC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                optionB.setBackgroundColor(getColor(R.color.black));
                optionA.setBackgroundColor(getColor(R.color.black));
                optionD.setBackgroundColor(getColor(R.color.black));
                selectedoption=QuizArray.options[questionno][2];
                optionC.setBackgroundColor(getColor(R.color.green));
            }
        });

        optionD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                optionB.setBackgroundColor(getColor(R.color.black));
                optionC.setBackgroundColor(getColor(R.color.black));
                optionA.setBackgroundColor(getColor(R.color.black));
                selectedoption=QuizArray.options[questionno][3];
                optionD.setBackgroundColor(getColor(R.color.green));
            }
        });

        next_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(selectedoption==""){
                    AlertDialog.Builder builder = new AlertDialog.Builder(QuizActivity.this);
                    builder.setMessage("Please Select the Option");
                    builder.setTitle("Alert !");
                    builder.setCancelable(true);
                    AlertDialog alertDialog = builder.create();
                    alertDialog.show();
                }else {
                    if (selectedoption == QuizArray.answers[questionno]) {
                        result++;
                    }
                    if(questionno==9){
                        Intent agn = new Intent(QuizActivity.this, ResultActivity.class);
                        agn.putExtra("result",result);
                        startActivity(agn);
                    }else {

                            questionno++;
                            questions.setText(QuizArray.questions[questionno]);
                            optionA.setText(QuizArray.options[questionno][0]);
                            optionB.setText(QuizArray.options[questionno][1]);
                            optionC.setText(QuizArray.options[questionno][2]);
                            optionD.setText(QuizArray.options[questionno][3]);

                            selectedoption="";
                        optionA.setBackgroundColor(getColor(R.color.black));
                        optionB.setBackgroundColor(getColor(R.color.black));
                        optionC.setBackgroundColor(getColor(R.color.black));
                        optionD.setBackgroundColor(getColor(R.color.black));


                    }
                    }

                }

        });
    }


}