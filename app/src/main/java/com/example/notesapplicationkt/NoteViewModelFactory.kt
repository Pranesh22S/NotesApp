package com.example.notesapplicationkt

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

@Suppress("UNCHECKED_CAST")
class NoteViewModelFactory(private val context: Context):ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        val notesDataBase = DataBaseHolder.getInstance(context)
        return NoteViewModel(notesDataBase.notesDAO()) as T
    }
}