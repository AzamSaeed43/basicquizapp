package com.example.basicquizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        TextView result=findViewById(R.id.result);
        Intent intent=getIntent();
        int res=intent.getIntExtra("result",0);
        result.setText(Integer.toString(res));
    }
}