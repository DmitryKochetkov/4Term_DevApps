package com.dimedrol.lab3;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class DBHelper extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "studentDB";
    public static final String TABLE_STUDENTS = "students";
    public static final String KEY_ID = "_id";
    public static final String KEY_FIO = "fio";
    public static final String KEY_DATE = "time";

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_STUDENTS + "(" + KEY_ID + " integer primary key," + KEY_FIO + " text," + KEY_DATE + " text" + ")");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists " + TABLE_STUDENTS);
        onCreate(db);

    }

    public void addStudent(Student student)
    {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(KEY_FIO, student.fio);
        contentValues.put(KEY_DATE, student.date);
        db.insert(TABLE_STUDENTS, null, contentValues);
    }

    public ArrayList<Student> getStudents()
    {
        ArrayList<Student> res = new ArrayList<>();

        SQLiteDatabase db = getWritableDatabase();
        Cursor cursor = db.query(DBHelper.TABLE_STUDENTS, null, null, null, null, null, null);

        if (cursor.moveToFirst())
        {
            int idIndex = cursor.getColumnIndex(DBHelper.KEY_ID);
            int fioIndex = cursor.getColumnIndex(DBHelper.KEY_FIO);
            int timeIndex = cursor.getColumnIndex(DBHelper.KEY_DATE);
            do {
                Student student = new Student(cursor.getString(fioIndex), cursor.getString(timeIndex));
                res.add(student);
            } while (cursor.moveToNext());
        }
        cursor.close();

        return res;
    }
}