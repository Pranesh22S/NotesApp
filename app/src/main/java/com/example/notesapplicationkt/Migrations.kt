package com.example.notesapplicationkt

import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase

val MIGRATION_1_2=object: Migration(1,2){
    override fun migrate(database: SupportSQLiteDatabase){
        database.execSQL("ALTER TABLE Notes ADD COLUMN Date DEFAULT 0 NOT NULL")
    }
}