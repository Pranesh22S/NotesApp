package com.example.notesapplicationkt

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.notesapplicationkt.databinding.FragmentDetailBinding

class DetailFragment : Fragment() {
//    private var binding: FragmentDetailBinding?= null
//    private lateinit var noteViewModel: NoteViewModel
//    private val args: DetailFragmentArgs by navArgs()
//
//    override fun onCreateView(
//        inflater: LayoutInflater, container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View {
//        binding = FragmentDetailBinding.inflate(inflater, container, false)
//        return binding!!.root
//    }
//
//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//        //val args: DetailFragmentArgs by navArgs()
////        val id = arguments?.getInt("id") ?: 0
////        val note = arguments?.getString("note") ?: ""
//        val id=args.id;
//        val note=args.note
//        noteViewModel = ViewModelProvider(this, NoteViewModelFactory(requireContext())).get(NoteViewModel::class.java)
//        binding!!.editTextNote.setText(note)
//        binding!!.button2.setOnClickListener {
//            val updatedNote = binding!!.editTextNote.text.toString()
//            noteViewModel.update(id, updatedNote)
//            findNavController().navigateUp()
//        }
//    }
}
