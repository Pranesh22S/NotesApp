package com.example.notesapplicationkt

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.databinding.DataBindingUtil
import androidx.databinding.DataBindingComponent
import com.example.notesapplicationkt.databinding.FragmentMainBinding

class MainFragment : Fragment() {
    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!
    private lateinit var adapter: MyAdapter
    private lateinit var noteViewModel: NoteViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        noteViewModel = ViewModelProvider(this, NoteViewModelFactory(requireContext())).get(NoteViewModel::class.java)
        binding.rv1.layoutManager = LinearLayoutManager(context)
        adapter = MyAdapter(object : MyAdapter.AdapterListener {
            override fun onDelete(id: Int) {
                noteViewModel.deleteItemBy(id)
                getNotification("Deleted Successfully")
            }
            override fun onEdit(id: Int, note:  String) {
                val isAdd:Boolean=false
                val action=MainFragmentDirections.actionMainFragmentToNoteFragment(id,note,isAdd)
                findNavController().navigate(action)
            }
        }, listOf())
        binding.rv1.adapter = adapter
        binding.addButton.setOnClickListener {
            val isAdd:Boolean=true
            val action = MainFragmentDirections.actionMainFragmentToNoteFragment(0,"",isAdd)
            findNavController().navigate(action)
        }
    }
    override fun onStart() {
        super.onStart()
        val allNotes: LiveData<List<Notes>> = noteViewModel.getAllNotes()
        Log.d("MainFragment", "On Started")
        allNotes.observe(viewLifecycleOwner, { notes ->
            if (notes.isEmpty()) {
                binding.tv1.visibility = View.VISIBLE
                binding.rv1.visibility = View.VISIBLE
            } else {
                binding.tv1.visibility = View.GONE
                binding.rv1.visibility = View.VISIBLE
                Log.d("MainFragment", "$notes")
            }
            adapter.updatelist(notes)
        })
    }
    private fun getNotification(str: String) {
        Toast.makeText(context, str, Toast.LENGTH_SHORT).show()
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
