package com.dimedrol.lab3_2;

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
    public static final String KEY_FIRST_NAME = "first_name";
    public static final String KEY_SECOND_NAME = "second_name";
    public static final String KEY_LAST_NAME = "last_name";
    public static final String KEY_DATE = "time";

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_STUDENTS + "(" + KEY_ID + " integer primary key," + KEY_FIRST_NAME + " text," + KEY_SECOND_NAME + " text," + KEY_LAST_NAME + " text," + KEY_DATE + " text" + ")");
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

        contentValues.put(KEY_FIRST_NAME, student.first_name);
        contentValues.put(KEY_SECOND_NAME, student.second_name);
        contentValues.put(KEY_LAST_NAME, student.last_name);
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
            int firstNameIndex = cursor.getColumnIndex(DBHelper.KEY_FIRST_NAME);
            int secondNameIndex = cursor.getColumnIndex(DBHelper.KEY_SECOND_NAME);
            int lastNameIndex = cursor.getColumnIndex(DBHelper.KEY_LAST_NAME);
            int timeIndex = cursor.getColumnIndex(DBHelper.KEY_DATE);
            do {
                Student student = new Student(cursor.getInt(idIndex), cursor.getString(firstNameIndex), cursor.getString(secondNameIndex), cursor.getString(lastNameIndex), cursor.getString(timeIndex));
                res.add(student);
            } while (cursor.moveToNext());
        }
        cursor.close();

        return res;
    }

    public void clear()
    {
        SQLiteDatabase db = getWritableDatabase();
        db.delete(DBHelper.TABLE_STUDENTS, null, null);
    }

    public void Ivan()
    {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(DBHelper.KEY_FIRST_NAME, "Иванов");
        contentValues.put(DBHelper.KEY_SECOND_NAME, "Иван");
        contentValues.put(DBHelper.KEY_LAST_NAME, "Иванович");
        db.update(TABLE_STUDENTS, contentValues, KEY_ID + " = (SELECT MAX(" + KEY_ID + ") FROM " + TABLE_STUDENTS + ");", null);
    }
}