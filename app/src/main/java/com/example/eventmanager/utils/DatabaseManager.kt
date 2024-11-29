package com.example.eventmanager.utils

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.example.eventmanager.data.entities.Event
import com.example.eventmanager.data.entities.Guest

class DatabaseManager(context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    companion object {
        // If you change the database schema, you must increment the database version.
        const val DATABASE_VERSION = 1
        const val DATABASE_NAME = "EventManagerDB.db"


        private const val SQL_CREATE_TABLE =
            "CREATE TABLE ${Guest.TABLE_NAME} (" +
                    "${Guest.COLUMN_ID} INTEGER PRIMARY KEY AUTOINCREMENT," +
                    "${Guest.COLUMN_NAME_TITLE} TEXT," +
                    "${Guest.COLUMN_NAME_NOTES} TEXT)"

        private const val SQL_CREATE_TABLE2 =
            "CREATE TABLE ${Event.TABLE_NAME} (" +
                    "${Event.COLUMN_ID} INTEGER PRIMARY KEY AUTOINCREMENT," +
                    "${Event.COLUMN_NAME_TITLE} TEXT," +
                    "${Event.COLUMN_NAME_DATES} TEXT)"

        private const val SQL_DELETE_TABLE_GUEST = "DROP TABLE IF EXISTS ${Guest.TABLE_NAME}"
        private const val SQL_DELETE_TABLE_EVENT = "DROP TABLE IF EXISTS ${Event.TABLE_NAME}"
    }

    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL(SQL_CREATE_TABLE)
        db.execSQL(SQL_CREATE_TABLE2)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        onDestroy(db)
        onCreate(db)
        //db.execSQL("ALTER TABLE ${Task.TABLE_NAME} ADD COLUMN ${Task.COLUMN_NAME_PRIORITY} INTEGER")
    }

    private fun onDestroy(db: SQLiteDatabase) {
        db.execSQL(SQL_DELETE_TABLE_GUEST)
        db.execSQL(SQL_DELETE_TABLE_EVENT)
    }
}