package com.dimedrol.lab3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Date;

public class AddActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        final DBHelper dbHelper = new DBHelper(this);

        final EditText editText = findViewById(R.id.input);

        Button b = findViewById(R.id.add);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Student student = new Student(editText.getText().toString(), new Date());
                dbHelper.addStudent(student);
                onBackPressed();
            }
        });
    }
}
