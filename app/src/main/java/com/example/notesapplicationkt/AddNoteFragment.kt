package com.example.notesapplicationkt

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.notesapplicationkt.databinding.FragmentAddNoteBinding
import androidx.navigation.fragment.findNavController

class AddNoteFragment : Fragment() {
    private lateinit var binding: FragmentAddNoteBinding
    private lateinit var noteViewModel: NoteViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAddNoteBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        noteViewModel = ViewModelProvider(this, NoteViewModelFactory(requireContext())).get(NoteViewModel::class.java)
        binding.buttonAddNote.setOnClickListener {
            val noteText = binding.editTextNote.text.toString()
            //noteViewModel.addItem(noteText)
            findNavController().navigateUp()
        }
    }
}