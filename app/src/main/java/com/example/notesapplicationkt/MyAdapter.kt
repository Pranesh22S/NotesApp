package com.example.notesapplicationkt

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.notesapplicationkt.R
import java.io.Serializable


class MyAdapter(
    private val listener: AdapterListener,
    var values: List<Notes>
) : RecyclerView.Adapter<MyAdapter.ViewHolder>() {
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textView: TextView = view.findViewById(R.id.textView)
        val editButton: Button = view.findViewById(R.id.button)
        val deleteButton: Button = view.findViewById(R.id.delete_button)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val rowView = inflater.inflate(R.layout.list_item, parent, false)
        return ViewHolder(rowView)
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val note = values[position]
        holder.textView.text = note.note
        holder.editButton.setOnClickListener {
            listener.onEdit(note.notesId,note.note)
        }
        holder.deleteButton.setOnClickListener {
            Toast.makeText(holder.itemView.context, "Delete button clicked for item ${note.note}", Toast.LENGTH_SHORT).show()
            listener.onDelete(note.notesId)
            Log.d("ch1","Delete Checking")
        }
    }
    override fun getItemCount() = values.size
    fun updatelist(newlist: List<Notes>) {
        val utilCallBack=NotesDiffCallback(values,newlist)
        val utilResult=DiffUtil.calculateDiff(utilCallBack)
        values=newlist
        utilResult.dispatchUpdatesTo(this)
    }
    interface AdapterListener{
        fun onDelete(id:Int)
        fun onEdit(id: Int, note: String)
    }
}
