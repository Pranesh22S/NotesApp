package com.example.notesapplicationkt

import androidx.room.TypeConverter
import java.util.Date

object Converters {
    @TypeConverter
   // @JvmStatic
    fun fromDate(date: Date?): Long? {
        return date?.time
    }

    @TypeConverter
  //  @JvmStatic
    fun toDate(timestamp: Long?): Date? {
        return timestamp?.let { Date(it) }
    }
}