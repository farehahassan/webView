package com.example.auth_ui;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class login extends AppCompatActivity {
    ImageView passIcon;
    boolean like = false;  // Define like here and set initial value

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        passIcon = findViewById(R.id.passIcon);

        passIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (like) {
                    passIcon.setImageResource(R.drawable.eye_close);  // If liked, show "eye close"
                } else {
                    passIcon.setImageResource(R.drawable.eye_open);   // If not liked, show "eye open"
                }
                like = !like;  // Toggle the value of 'like'
            }
        });
    }
}
