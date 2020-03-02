package com.example.btvnlistview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;

public class Main2Activity extends AppCompatActivity {
    EditText edit_text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        edit_text = findViewById(R.id.edit_text);
        Intent intent = getIntent();
        edit_text.setText(intent.getStringExtra("dl"));
    }
}
