package com.e.topic4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class ShowActivity extends AppCompatActivity {

    TextView msg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);

        msg = findViewById(R.id.msg);
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            String Captial = bundle.getString("capital");

            msg.setText(Captial);
        } else {
            Toast.makeText(this, "No capital", Toast.LENGTH_SHORT).show();
        }
    }
}
