package com.example.notesapplicationkt

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.notesapplicationkt.R

class DetailActivity : AppCompatActivity() {
    private lateinit var noteviewmodel:NoteViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        val detailTextView: EditText = findViewById(R.id.editTextNote)
        //val dataNotesTextView: TextView = findViewById(R.id.buttonAddNote)
        val item = intent.getSerializableExtra("ITEM") as Pair<Int,String>
        detailTextView.setText(item.second)
       // dataNotesTextView.visibility= View.GONE'
        val id:Int=item.first;
        noteviewmodel= ViewModelProvider(this, NoteViewModelFactory(this))[NoteViewModel::class.java]
        val saveButton: Button =findViewById(R.id.button2)
        saveButton.setOnClickListener(View.OnClickListener {
            val updatedNoteText=detailTextView.text.toString()
            if(updatedNoteText.isEmpty()){
                Toast.makeText(this,"Edit Properly",Toast.LENGTH_SHORT).show()
                Log.d("Sae1 ", updatedNoteText)
            }
            if(updatedNoteText==item.second){
                Toast.makeText(this,"No Changes Made",Toast.LENGTH_SHORT).show()
            }
            else {
                Log.d("Save ", "Button Clicked")
                Log.d("Save", "" + id + " " + updatedNoteText)
               // val resultIntent = Intent()
                //Log.d("chk","${detailTextView.text}")
                //resultIntent.putExtra("EDIT_NOTE", Pair(id, detailTextView.text.toString()))
              //  noteviewmodel.update(id,updatedNoteText)
               // setResult(RESULT_OK)
                finish()
            }
        })

    }
}
/*fun update(id:Int,str:String,date: Date){
        executor.execute{
           notesDAO.updateBy(id,str)
        }
    }
    fun addItem(item: String,newdate: Date) {
        Log.d("checking","Item Passed to Database")
        insert(Notes(note=item,date=newdate))
    }
    */