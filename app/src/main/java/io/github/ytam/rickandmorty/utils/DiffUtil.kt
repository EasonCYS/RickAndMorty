package io.github.ytam.rickandmorty.utils

import androidx.recyclerview.widget.DiffUtil
import io.github.ytam.rickandmorty.model.Character

class DiffUtil(
    private val oldList: List<Character>,
    private val newList: List<Character>
) : DiffUtil.Callback() {
    override fun getOldListSize(): Int {
        return oldList.size
    }

    override fun getNewListSize(): Int {
        return newList.size
    }

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition] === newList[newItemPosition]
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition] == newList[newItemPosition]
    }
}
