package com.example.notesapplicationkt

import android.app.DatePickerDialog
import android.graphics.Color
import androidx.fragment.app.Fragment
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.DatePicker
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
//import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.notesapplicationkt.databinding.FragmentNoteBinding
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date
import java.util.Locale

class NoteFragment : Fragment() {
    private var _binding: FragmentNoteBinding? = null
    private val binding get() = _binding!!
    private lateinit var noteViewModel: NoteViewModel
    private val args:NoteFragmentArgs by navArgs()
    private val date:Date= Date()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentNoteBinding.inflate(inflater, container, false)
        return binding!!.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        noteViewModel = ViewModelProvider(this, NoteViewModelFactory(requireContext())).get(NoteViewModel::class.java)
        binding.lifecycleOwner = viewLifecycleOwner
        val noteId = args.id
        val noteText = args.note
        val isAdd=args.isAdd
        (activity as AppCompatActivity).setSupportActionBar(binding!!.toolbar)
        (activity as AppCompatActivity).supportActionBar?.setDisplayHomeAsUpEnabled(true)
        binding!!.toolbar.setNavigationOnClickListener {
            findNavController().navigateUp()
        }
        if (!isAdd) {
           // binding!!.dateButton.text=" Date"
            binding!!.toolbar.title = "Edit Note"
            binding!!.editTextNote.setText(noteText)
            binding!!.button.text = "Update"
            binding!!.button.setOnClickListener {
                val updatedNote = binding!!.editTextNote.text.toString().trim()
                if(updatedNote.isEmpty()){
                    Toast.makeText(requireContext(),"Edit Properly", Toast.LENGTH_SHORT).show()
                }
                else if(updatedNote.trim()==noteText.trim()){
                    Toast.makeText(requireContext(),"No Changes Made", Toast.LENGTH_SHORT).show()
                }
                else {
                    noteViewModel.update(noteId, updatedNote)
                    findNavController().navigateUp()
                }
            }
        } else {
            binding!!.toolbar.title = "Add Note"
            binding!!.editTextNote.setText("")
            binding!!.button.text ="Save"
            binding!!.dateButton.text="Set Date"
            binding!!.editTextNote.setHint("Enter your note here")
            binding!!.button.setOnClickListener {
                val noteText = binding.editTextNote.text.toString()
                noteViewModel.addItem(noteText)
                findNavController().navigateUp()
            }
           /* binding!!.dateButton.setOnClickListener {
                val calendar = Calendar.getInstance()
                val datePickerDialog = DatePickerDialog(requireContext(),
                    { _: DatePicker, year: Int, month: Int, dayOfMonth: Int ->
                        calendar.set(Calendar.YEAR, year)
                        calendar.set(Calendar.MONTH, month)
                        calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth)
                        val dateFormat = SimpleDateFormat("yyyy-MM-dd", Locale("en","IN"))
                        binding!!.dateButton.setText(dateFormat.format(calendar.time.toString())
                    },
                    calendar.get(Calendar.YEAR),
                    calendar.get(Calendar.MONTH),
                    calendar.get(Calendar.DAY_OF_MONTH)
                )
                datePickerDialog.show()
            }
            if(isAdded){
                 binding!!.button.setOnClickListener {
                     noteText = binding.editTextNote.text.toString()
                 }

                 findNavController().navigateUp()
            }*/
        }
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}