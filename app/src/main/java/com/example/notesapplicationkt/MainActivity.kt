package com.example.notesapplicationkt

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ListView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModelProvider
import com.example.notesapplicationkt.AddNoteActivity
import com.example.notesapplicationkt.MyAdapter
import androidx.lifecycle.Observer
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.util.Date

class MainActivity : AppCompatActivity(){

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_main)

       }
}

































    /*companion object {
        private const val REQUEST_CODE_ADD_NOTE=1
        private const val REQUEST_CODE_EDIT_NOTE=2
        private const val TAG = "MainActivity"
    }
    private lateinit var adapter: MyAdapter
    private lateinit var noteViewModel: NoteViewModel
    private lateinit var et: TextView
    private lateinit var recyclerView:RecyclerView
    private lateinit var navController: NavController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerView= findViewById(R.id.rv1)
        recyclerView.layoutManager = LinearLayoutManager(this)
//        val navHostFragment=supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
//        navController=navHostFragment.navController
        val addNoteButton: Button = findViewById(R.id.add_button)
        et = findViewById(R.id.tv1)
        noteViewModel = ViewModelProvider(this, NoteViewModelFactory(this))[NoteViewModel::class.java]

        adapter = MyAdapter(object : MyAdapter.AdapterListener {
            override fun onDelete(id:Int) {
                noteViewModel.deleteItemBy(id)
            }
            override fun onEdit(id: Int, note: String) {
                val intent = Intent(this@MainActivity, DetailActivity::class.java).apply {
                    putExtra("ITEM", Pair(id, note))
                }
                //startActivityForResult(intent, REQUEST_CODE_EDIT_NOTE)
                startActivity(intent)
            }
        },listOf())
        recyclerView.adapter = adapter
        addNoteButton.setOnClickListener {
            val intent = Intent(this, AddNoteActivity::class.java)
            //startActivityForResult(intent, REQUEST_CODE_ADD_NOTE)
            startActivity(intent)
        }
    }
//    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
//        super.onActivityResult(requestCode, resultCode, data)
//        if (resultCode == RESULT_OK) {
//            getNotification("Added Successfully")
//        }
//    }
    fun getNotification(str:String){
        Toast.makeText(this,str,Toast.LENGTH_SHORT).show();
    }
    override fun onStart() {
        super.onStart()
        val allNotes: LiveData<List<Notes>> = noteViewModel.getAllNotes()
        System.out.println("On Started")
        allNotes.observe(this@MainActivity, Observer { notes ->
              if (notes.isEmpty()) {
                  et.visibility = View.VISIBLE
                  recyclerView.visibility = View.VISIBLE
              } else {
                  et.visibility = View.GONE
                  recyclerView.visibility = View.VISIBLE
                  Log.d("ch1","$notes")
              }
            adapter.updatelist(notes)
        })

    }*/
