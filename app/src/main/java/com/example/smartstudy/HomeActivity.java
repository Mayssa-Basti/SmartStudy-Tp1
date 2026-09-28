package com.example.smartstudy;

import android.os.Bundle;
import android.widget.Button;
import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;

public class HomeActivity extends AppCompatActivity {

    private Button btnSubjects;
    private Button btnPlanning;
    private Button btnQuiz;
    private Button btnProgress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_home);

        btnSubjects = findViewById(R.id.btnSubjects);
        btnPlanning = findViewById(R.id.btnPlanning);
        btnQuiz = findViewById(R.id.btnQuiz);
        btnProgress = findViewById(R.id.btnProgress);
    }
}