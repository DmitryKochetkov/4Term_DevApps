package com.dimedrol.lab3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.Date;

public class MainActivity extends AppCompatActivity {

    String[] rndNames = new String[]{"Дмитрий", "Сергей", "Иван", "Артём", "Вячеслав", "Илья", "Даниил", "Григорий", "Евгений", "Никита", "Николай"};
    String[] rndSurnames = new String[]{"Пучков", "Большаков", "Васильев", "Андреев", "Петров", "Иванов", "Синицын", "Сергеев"};
    String[] rndSecondnames = new String[]{"Витальевич", "Иванович", "Ильич", "Сергеевич", "Альбертович", "Николаевич", "Евгеньевич"};

    DBHelper dbHelper = new DBHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dbHelper.clear();
        for (int i = 0; i < 10; i++)
        {
            Date now = new Date();
            int n1 = (int)Math.floor(Math.random() * rndSurnames.length);
            int n2 = (int)Math.floor(Math.random() * rndNames.length);
            int n3 = (int)Math.floor(Math.random() * rndSecondnames.length);
            String fio = rndSurnames[n1] + " " + rndNames[n2] + " " + rndSecondnames[n3];
            Student student = new Student(fio, now);
            dbHelper.addStudent(student);
        }

        Button button1 = (Button) findViewById(R.id.button1);
        Button button2 = (Button) findViewById(R.id.button2);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, DataActivity.class);
                startActivity(intent);
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AddActivity.class);
                startActivity(intent);
            }
        });
    }
}
