package com.example.notesapplicationkt

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import java.util.Date

@Entity(tableName = "notes")
//@TypeConverters(Converters::class)
data class Notes(
    @ColumnInfo(name = "Notes")
    val note: String,
//    @ColumnInfo(name="Date")
//    val date: Date,
    @PrimaryKey(autoGenerate=true)
    @ColumnInfo(name = "notesid")
    val notesId: Int=0
)