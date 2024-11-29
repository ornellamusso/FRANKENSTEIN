package com.example.eventmanager.data.entities

data class Guest(
    val id: Long,
    var name: String,
    var notes: String = ""
) {
    companion object {
        const val TABLE_NAME = "Guest"
        const val COLUMN_ID = "id"
        const val COLUMN_NAME_TITLE = "title"
        const val COLUMN_NAME_NOTES = "notes"
        val COLUMN_NAMES = arrayOf(
            COLUMN_ID,
            COLUMN_NAME_TITLE,
            COLUMN_NAME_NOTES)
    }
}