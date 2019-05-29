package com.dimedrol.lab3_2;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Student {
    int id;
    String first_name;
    String second_name;
    String last_name;
    String date;

    public Student(String first_name, String second_name, String last_name, String date) {
        this.first_name = first_name;
        this.second_name = second_name;
        this.last_name = last_name;
        this.date = date;
    }

    public Student(int id, String first_name, String second_name, String last_name, String date) {
        this.id = id;
        this.first_name = first_name;
        this.second_name = second_name;
        this.last_name = last_name;
        this.date = date;
    }

    public Student(String first_name, String second_name, String last_name, Date date) {
        this.first_name = first_name;
        this.second_name = second_name;
        this.last_name = last_name;
        DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy", Locale.getDefault());
        String dateText = dateFormat.format(date);
        DateFormat timeFormat = new SimpleDateFormat("HH:mm:ss", Locale.getDefault());
        String timeText = timeFormat.format(date);
        this.date = dateText + ", " + timeText;
    }
}
