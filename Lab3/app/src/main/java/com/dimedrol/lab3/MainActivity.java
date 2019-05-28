package com.dimedrol.lab3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    String[] rndNames = new String[]{"Дмитрий", "Сергей", "Иван", "Артём", "Вячеслав", "Илья", "Даниил", "Григорий", "Евгений", "Никита", "Николай"};
    String[] rndSurnames = new String[]{"Пучков", "Большаков", "Васильев", "Андреев", "Петров", "Иванов", "Синицын", "Сергеев"};
    String[] rndSecondnames = new String[]{"Витальевич", "Иванович", "Ильич", "Сергеевич", "Альбертович", "Николаевич", "Евгеньевич"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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
