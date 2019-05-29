package com.dimedrol.lab3_2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.Date;

public class AddActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        final DBHelper dbHelper = new DBHelper(this);

        final EditText editTextFirst = findViewById(R.id.input_first);
        final EditText editTextSecond = findViewById(R.id.input_second);
        final EditText editTextLast = findViewById(R.id.input_last);

        Button b = findViewById(R.id.add);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Student student = new Student(editTextFirst.getText().toString(), editTextSecond.getText().toString(), editTextLast.getText().toString(), new Date());
                dbHelper.addStudent(student);
                onBackPressed();
            }
        });
    }
}
