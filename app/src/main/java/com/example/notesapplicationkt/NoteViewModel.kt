package com.example.notesapplicationkt

import android.util.Log
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import java.util.concurrent.Executors
import kotlin.math.exp

class NoteViewModel(val notesDAO: NotesDAO) : ViewModel() {

    private val executor = Executors.newSingleThreadExecutor()

    fun insert(note: Notes) {
        executor.execute { notesDAO.insert(note) }
    }
    fun delete(noteId:Int) {
        Log.d("chk","${noteId}")
        executor.execute {
           // notesDAO.delete(note)
           // notesDAO.deleteByName(note.note)
            notesDAO.deleteById(noteId)
        }
    }
    fun update(id:Int,str:String){
        executor.execute{
           notesDAO.updateBy(id,str)
        }
    }
    /*fun deleteItem(s: String) {
        delete(Notes(s))
    }*/
    fun deleteItemBy(id:Int) {
        delete(id)
    }
    fun getAllNotes() : LiveData<List<Notes>>{
        return notesDAO.getAllNotesLive()
    }
    fun addItem(item: String) {
        Log.d("checking","Item Passed to Database")
        insert(Notes(item))
    }
    fun loadItemsFromDatabase() {
        executor.execute {
            val notes = notesDAO.getAllNotes()
        }
    }
}
