package com.example.notesapplicationkt

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider

class AddNoteActivity : AppCompatActivity() {
    private lateinit var noteviewmodel:NoteViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_note)
        val editText: EditText = findViewById(R.id.editTextNote)
        val buttonAdd: Button = findViewById(R.id.buttonAddNote)
        noteviewmodel= ViewModelProvider(this, NoteViewModelFactory(this))[NoteViewModel::class.java]
        buttonAdd.setOnClickListener {
            Log.e("checking_pranesh", "hello")
            val newNote = editText.text.toString().trim()
            if (newNote.isNotEmpty()) {
               // noteviewmodel.addItem(newNote)
                setResult(RESULT_OK)
                finish()
            }
        }
    }
}
