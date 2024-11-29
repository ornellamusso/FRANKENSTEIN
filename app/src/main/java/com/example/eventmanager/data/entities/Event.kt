package com.example.eventmanager.data.entities

data class Event(
    val id: Long,
    var name: String,
    var dates: String = ""
) {
    companion object {
        const val TABLE_NAME = "Event"
        const val COLUMN_ID = "id"
        const val COLUMN_NAME_TITLE = "name"
        const val COLUMN_NAME_DATES = "dates"
    }
}