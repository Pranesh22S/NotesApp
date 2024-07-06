package com.example.notesapplicationkt

import android.content.Context
import androidx.room.Room

object DataBaseHolder {

    var INSTANCE : NotesDataBase? = null

    fun getInstance(context: Context): NotesDataBase {
        return INSTANCE?:synchronized(this){
            val instance = Room.databaseBuilder(
                context.applicationContext,
                NotesDataBase::class.java,
                "notes_database")
                .addMigrations(MIGRATION_1_2)
                .build()
            INSTANCE=instance
            instance
        }
    }

}