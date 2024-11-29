package com.example.eventmanager.utils

import java.text.DateFormat
import java.util.Calendar
import java.util.Locale

fun Calendar.isSameDay(calendar: Calendar): Boolean {
    return this.get(Calendar.YEAR) == calendar.get(Calendar.YEAR) &&
            this.get(Calendar.DAY_OF_YEAR) == calendar.get(Calendar.DAY_OF_YEAR)
}

fun Calendar.isToday(): Boolean {
    val today = Calendar.getInstance()
    return this.isSameDay(today)
}

fun Calendar.isTomorrow(): Boolean {
    val tomorrow = Calendar.getInstance()
    tomorrow.add(Calendar.DAY_OF_YEAR, 1)
    return this.isSameDay(tomorrow)
}

fun Calendar.isYesterday(): Boolean {
    val yesterday = Calendar.getInstance()
    yesterday.add(Calendar.DAY_OF_YEAR, -1)
    return this.isSameDay(yesterday)
}

fun Calendar.getFormattedDate(format: Int = DateFormat.SHORT): String {
    val dateFormat = DateFormat.getDateInstance(format, Locale.getDefault())
    return dateFormat.format(this.time)
}

fun Calendar.getFormattedTime(format: Int = DateFormat.SHORT): String {
    val timeFormat = DateFormat.getTimeInstance(format, Locale.getDefault())
    return timeFormat.format(this.time)
}

fun Calendar.getFormattedDateTime(format: Int = DateFormat.SHORT): String {
    val dateTimeFormat = DateFormat.getDateTimeInstance(format, format, Locale.getDefault())
    return dateTimeFormat.format(this.time)
}