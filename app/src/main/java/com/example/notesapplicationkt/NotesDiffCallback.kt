package com.example.notesapplicationkt

import androidx.recyclerview.widget.DiffUtil

class NotesDiffCallback(
    private var oldList:List<Notes>,
    private var newList:List<Notes>
): DiffUtil.Callback() {
    override fun getOldListSize():Int{
        return oldList.size
    }
    override fun getNewListSize():Int{
        return newList.size
    }

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition].notesId==newList[newItemPosition].notesId
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition]==newList[newItemPosition]
    }
}