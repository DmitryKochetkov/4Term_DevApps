package com.dimedrol.lab3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

public class DataActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data);

        DBHelper dbHelper = new DBHelper(this);

        RecyclerView rw = (RecyclerView) findViewById(R.id.list);
        StudentAdapter adapter = new StudentAdapter(dbHelper.getStudents(), this);
        rw.setAdapter(adapter);
    }
}
