package com.example.eventmanager.data.providers

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.util.Log
import com.example.eventmanager.data.entities.Guest
import com.example.eventmanager.utils.DatabaseManager

class TaskDAO(val context: Context) {

    private lateinit var db: SQLiteDatabase

    private fun open() {
        db = DatabaseManager(context).writableDatabase
    }

    private fun close() {
        db.close()
    }

    fun getContentValues(guest: Guest): ContentValues {
        return ContentValues().apply {
            put(Guest.COLUMN_NAME_TITLE, guest.name)
            put(Guest.COLUMN_NAME_NOTES, guest.notes)
        }
    }

    fun cursorToEntity(cursor: Cursor): Guest {
        val id = cursor.getLong(cursor.getColumnIndexOrThrow(Guest.COLUMN_ID))
        val name = cursor.getString(cursor.getColumnIndexOrThrow(Guest.COLUMN_NAME_TITLE))
        val notes = cursor.getString(cursor.getColumnIndexOrThrow(Guest.COLUMN_NAME_NOTES))

        return Guest(id, name, notes)
    }

    fun insert(guest: Guest) {
        open()

        // Create a new map of values, where column names are the keys
        val values = getContentValues(guest)

        try {
            // Insert the new row, returning the primary key value of the new row
            val id = db.insert(Guest.TABLE_NAME, null, values)
        } catch (e: Exception) {
            Log.e("DB", e.stackTraceToString())
        } finally {
            close()
        }
    }

    fun update(guest: Guest) {
        open()

        // Create a new map of values, where column names are the keys
        val values = getContentValues(guest)

        try {
            // Update the existing rows, returning the number of affected rows
            val updatedRows = db.update(Guest.TABLE_NAME, values, "${Guest.COLUMN_ID} = ${guest.id}", null)
        } catch (e: Exception) {
            Log.e("DB", e.stackTraceToString())
        } finally {
            close()
        }
    }

    fun delete(guest: Guest) {
        open()

        try {
            // Delete the existing row, returning the number of affected rows
            val deletedRows = db.delete(Guest.TABLE_NAME, "${Guest.COLUMN_ID} = ${guest.id}", null)
        } catch (e: Exception) {
            Log.e("DB", e.stackTraceToString())
        } finally {
            close()
        }
    }

    fun findById(id: Long) : Guest? {
        open()

        try {
            val cursor = db.query(
                Guest.TABLE_NAME,                    // The table to query
                Guest.COLUMN_NAMES,                  // The array of columns to return (pass null to get all)
                "${Guest.COLUMN_ID} = $id",  // The columns for the WHERE clause
                null,                   // The values for the WHERE clause
                null,                       // don't group the rows
                null,                         // don't filter by row groups
                null                         // The sort order
            )

            if (cursor.moveToNext()) {
                return cursorToEntity(cursor)
            }
        } catch (e: Exception) {
            Log.e("DB", e.stackTraceToString())
        } finally {
            close()
        }
        return null
    }

    fun findAll() : List<Guest> {
        open()

        var list: MutableList<Guest> = mutableListOf()

        try {
            val cursor = db.query(
                Guest.TABLE_NAME,                    // The table to query
                Guest.COLUMN_NAMES,                  // The array of columns to return (pass null to get all)
                null,                       // The columns for the WHERE clause
                null,                   // The values for the WHERE clause
                null,                       // don't group the rows
                null,                         // don't filter by row groups
                null                         // The sort order
            )

            while (cursor.moveToNext()) {
                val task = cursorToEntity(cursor)
                list.add(task)
            }
        } catch (e: Exception) {
            Log.e("DB", e.stackTraceToString())
        } finally {
            close()
        }
        return list
    }

}