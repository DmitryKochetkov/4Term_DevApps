package com.dimedrol.lab3;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Student {
    int id; //нужно ли?
    String fio;
    String date;

    public Student(String fio, String date) {
        this.fio = fio;
        this.date = date;
    }

    public Student(String fio, Date date) {
        this.fio = fio;
        DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy", Locale.getDefault());
        String dateText = dateFormat.format(date);
        DateFormat timeFormat = new SimpleDateFormat("HH:mm:ss", Locale.getDefault());
        String timeText = timeFormat.format(date);
        this.date = dateText + ", " + timeText;
    }

    public Student(int id, String fio, String date) {
        this.id = id;
        this.fio = fio;
        this.date = date;
    }
}
