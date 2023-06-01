package com.example.myapplication

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DatabaseHelpers(context: Context) :
    SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    companion object {
        private const val DATABASE_NAME = "login_database"
        private const val DATABASE_VERSION = 1
    }

    override fun onCreate(db: SQLiteDatabase?) {
        val CREATE_USERS_TABLE = ("CREATE TABLE " +
                Student.TABLE_NAME + "("
                + Student.COLUMN_ID + " INTEGER PRIMARY KEY, "
                + Student.COLUMN_USERNAME + " TEXT, "
                + Student.COLUMN_PASWORD + " TEXT"
                + ")")

        db?.execSQL(CREATE_USERS_TABLE)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL("DROP TABLE IF EXISTS " + Student.TABLE_NAME)
        onCreate(db)
    }

    fun addStudent(student: Student) {
        val db = this.writableDatabase
        val values = ContentValues()
        values.put(Student.COLUMN_USERNAME, student.userName)
        values.put(Student.COLUMN_PASWORD, student.password)
        db.insert(Student.TABLE_NAME, null, values)
        db.close()
    }

    fun getAllStudents(): List<Student> {
        val students = ArrayList<Student>()
        val selectQuery = "SELECT * FROM " + Student.TABLE_NAME
        val db = this.readableDatabase
        val cursor = db.rawQuery(selectQuery, null)
        if (cursor.moveToFirst()) {
            do {
                val student = Student(
                    cursor.getInt(cursor.getColumnIndex(Student.COLUMN_ID)),
                    cursor.getString(cursor.getColumnIndex(Student.COLUMN_USERNAME)),
                    cursor.getString(cursor.getColumnIndex(Student.COLUMN_PASWORD))
                )
                students.add(student)
            } while (cursor.moveToNext())
        }

        cursor.close()
        db.close()

        return students
    }
}