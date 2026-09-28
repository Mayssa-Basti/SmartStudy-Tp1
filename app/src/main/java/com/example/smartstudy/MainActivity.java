package com.example.smartstudy;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;
import android.os.Handler;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText edtEmail;
    private EditText edtPassword;
    private CheckBox cbRemember;
    private Button btnLogin;
    private Button btnRegister;
    private ProgressBar progress;
    private int progressValue = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        Log.i("SmartStudy", "onCreate");

        edtEmail = findViewById(R.id.edtEmail);
        edtPassword = findViewById(R.id.edtPassword);
        cbRemember = findViewById(R.id.cbRemember);
        btnLogin = findViewById(R.id.btnLogin);
        btnRegister = findViewById(R.id.btnRegister);
        progress = findViewById(R.id.progress);
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MainActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String email = edtEmail.getText().toString();
                String password = edtPassword.getText().toString();

                if (email.isEmpty() || password.isEmpty()) {

                    Toast.makeText(
                            MainActivity.this,
                            "Veuillez remplir tous les champs",
                            Toast.LENGTH_SHORT
                    ).show();

                } else {

                    progress.setVisibility(View.VISIBLE);

                    progressValue = 0;
                    progress.setProgress(0);

                    Handler handler = new Handler();

                    Thread worker = new Thread(new Runnable() {
                        @Override
                        public void run() {

                            while (progressValue < 100) {

                                try {
                                    Thread.sleep(50);
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }

                                handler.post(new Runnable() {
                                    @Override
                                    public void run() {

                                        progressValue++;
                                        progress.setProgress(progressValue);
                                        if (progressValue == 100) {
                                            progress.setVisibility(View.GONE);

                                            Toast.makeText(
                                                    MainActivity.this,
                                                    "Connexion réussie !",
                                                    Toast.LENGTH_SHORT
                                            ).show();
                                            Intent intent = new Intent(MainActivity.this, HomeActivity.class);
                                            startActivity(intent);
                                        }

                                    }
                                });
                            }
                        }
                    });

                    worker.start();
                }
            }
        });
    }



    @Override
    protected void onStart() {
        super.onStart();

        Log.i("SmartStudy", "onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();

        Log.i("SmartStudy", "onResume");
    }
}