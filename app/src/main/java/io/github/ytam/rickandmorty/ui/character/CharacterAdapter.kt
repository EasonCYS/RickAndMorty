package io.github.ytam.rickandmorty.ui.character

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import io.github.ytam.rickandmorty.R
import io.github.ytam.rickandmorty.enum.CharacterStatusEnums
import io.github.ytam.rickandmorty.enum.SwitchLayoutEnums
import io.github.ytam.rickandmorty.extensions.loadFromUrl
import io.github.ytam.rickandmorty.model.Character
import kotlinx.android.synthetic.main.item_character_grid.view.*

/**
 *Created by Yıldırım TAM on 04/02/2021.
 */
class CharacterAdapter() : RecyclerView.Adapter<CharacterAdapter.CharacterViewHolder>() {

    private val characterList by lazy { mutableListOf<Character>() }

    class CharacterViewHolder(var view: View) : RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {

        val view: View
        val inflater = LayoutInflater.from(parent.context)

        view = inflater.inflate(R.layout.item_character_grid, parent, false)

        return CharacterViewHolder(view)
    }

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {

        holder.view.ivCharacterProfile.loadFromUrl(characterList[position].image.toString())
        holder.view.tvCharacterName.text = characterList[position].name
        holder.view.tvCharacterSpecies.text = characterList[position].species
        holder.view.tvCharacterStatus.text = characterList[position].status
        holder.view.tvCharacterGender.text = characterList[position].gender

        holder.view.setOnClickListener {
            val characterId = characterList[position].id.toString().toInt()
            val action =
                CharacterFragmentDirections.actionCharacterFragmentToCharacterDetailFragment(
                    characterId
                )

            Navigation.findNavController(it).navigate(action)
        }

        when (characterList[position].status) {
            CharacterStatusEnums.CHARACTER_ALIVE.value -> holder.view.imgCharacterStatus.setColorFilter(
                Color.parseColor("#14D91B")
            )
            CharacterStatusEnums.CHARACTER_DEAD.value -> holder.view.imgCharacterStatus.setColorFilter(
                Color.parseColor("#FF0800")
            )
            CharacterStatusEnums.CHARACTER_UNKNOWN.value -> holder.view.imgCharacterStatus.setColorFilter(
                Color.parseColor("#E3E3E3")
            )
            else -> {
                holder.view.imgCharacterStatus.setColorFilter(Color.parseColor("#F8F816"))
            }
        }
    }

    override fun getItemViewType(position: Int): Int {

        return SwitchLayoutEnums.VIEW_TYPE_SMALL.value
    }

    override fun getItemCount(): Int {

        return characterList.size
    }

    fun updateList(newCountryList: List<Character>) {

        if (characterList.isNotEmpty()) {
            this.characterList.clear()
        }
        characterList.addAll(newCountryList)
        notifyDataSetChanged()
    }
}
