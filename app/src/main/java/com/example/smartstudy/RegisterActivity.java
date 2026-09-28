package com.example.smartstudy;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class RegisterActivity extends AppCompatActivity {
    private EditText edtName;
    private EditText edtEmail;
    private EditText edtPassword;
    private EditText edtConfirmPassword;
    private Button btnRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_register);
        edtName = findViewById(R.id.edtName);
        edtEmail = findViewById(R.id.edtEmail);
        edtPassword = findViewById(R.id.edtPassword);
        edtConfirmPassword = findViewById(R.id.edtConfirmPassword);
        btnRegister = findViewById(R.id.btnRegister);
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String name = edtName.getText().toString();
                String email = edtEmail.getText().toString();
                String password = edtPassword.getText().toString();
                String confirmPassword = edtConfirmPassword.getText().toString();
                if (name.isEmpty() || email.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {

                    Toast.makeText(
                            RegisterActivity.this,
                            "Veuillez remplir tous les champs",
                            Toast.LENGTH_SHORT
                    ).show();

                }
                else if (!password.equals(confirmPassword)) {

                    Toast.makeText(
                            RegisterActivity.this,
                            "Les mots de passe ne correspondent pas",
                            Toast.LENGTH_SHORT
                    ).show();

                }
                else {

                    Toast.makeText(
                            RegisterActivity.this,
                            "Inscription réussie !",
                            Toast.LENGTH_SHORT
                    ).show();
                    Intent intent = new Intent(RegisterActivity.this, HomeActivity.class);
                    startActivity(intent);

                }

            }
        });
    }
}