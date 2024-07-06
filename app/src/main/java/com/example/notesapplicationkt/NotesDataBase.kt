package com.example.notesapplicationkt

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Notes::class], version = 1,exportSchema = false)
abstract class NotesDataBase : RoomDatabase() {
    abstract fun notesDAO(): NotesDAO
}