package com.example.notesapplicationkt

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.notesapplicationkt.Notes

@Dao
interface NotesDAO {
    @Insert
    fun insert(notes: Notes)
    @Delete
    fun delete(notes: Notes)
    @Query("SELECT * FROM notes")
    fun getAllNotes(): List<Notes>
    @Query("SELECT * FROM notes")
    fun getAllNotesLive(): LiveData<List<Notes>>
    @Query("DELETE FROM notes WHERE notes = :str")
    fun deleteByName(str: String)
    @Query("DELETE FROM notes WHERE notesid=:id")
    fun deleteById(id:Int)
    @Query("UPDATE notes set notes=:str WHERE notesid=:id")
    fun updateBy(id:Int,str:String)
    //fun updateBy(id:
//    @Query("SELECT * FROM notes WHERE date BETWEEN :startDate AND :endDate")
//    suspend fun getNotesBetweenDates(startDate: Date, endDate: Date): List<Note>
}
