package com.example.auth_ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    ImageView passIcon;

    EditText passField , emailField;
    Button signInBtn;
    boolean isPassVisible = false;  // Define like here and set initial value

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        passIcon = findViewById(R.id.passIcon);
        passField = findViewById(R.id.passField);
        emailField = findViewById(R.id.emailField);
        signInBtn = findViewById(R.id.signInBtn);

        passIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isPassVisible) {
                    passField.setTransformationMethod(PasswordTransformationMethod.getInstance());
                    passIcon.setImageResource(R.drawable.eye_close);  // If liked, show "eye close"
                } else {
                    passField.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                    passIcon.setImageResource(R.drawable.eye_open);   // If not liked, show "eye open"
                }
                isPassVisible = !isPassVisible;  // Toggle the value of 'like'
                passField.setSelection(passField.getText().length());
            }
        });



        signInBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = emailField.getText().toString();
                String password = passField.getText().toString();
                if(username.isEmpty() || password.isEmpty()){
                    Toast.makeText(getApplicationContext(),"Please Fill all fields" , Toast.LENGTH_LONG).show();
                }else{

                    Intent signin = new Intent(getApplicationContext() , home_page.class);
                    signin.putExtra("username" , username);
                    startActivity(signin);
                }

            }
        });
    }

}