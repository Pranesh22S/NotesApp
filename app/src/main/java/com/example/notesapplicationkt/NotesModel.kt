package com.example.notesapplicationkt
import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStore
import com.example.notesapplicationkt.NoteViewModel

object NotesModel {

//    fun getNotesViewmodel(activity: Activity) : NoteViewModel{
//        return ViewModelProvider(ViewModelStore(), object : ViewModelProvider.Factory {
//            override fun <T : ViewModel> create(modelClass: Class<T>): T {
//                return NoteViewModel(activity) as T
//            }
//        })[NoteViewModel::class.java]
//    }
    fun getNotesViewmodel(activity: AppCompatActivity): NoteViewModel {
        return ViewModelProvider(activity).get(NoteViewModel::class.java)
    }
}