package com.rbugarin.rickandmortyapp.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.rbugarin.rickandmortyapp.R
import com.rbugarin.rickandmortyapp.databinding.CardCharacterBinding
import com.rbugarin.rickandmortyapp.models.CharacterPageRequest
import com.rbugarin.rickandmortyapp.models.CharacterView
import com.rbugarin.rickandmortyapp.models.Results


class CharacterAdapter : RecyclerView.Adapter<CharacterAdapter.CharacterViewHolder>(){

    private var listCharacters = mutableListOf<CharacterView>()

    public fun addResults(listCharacters: List<CharacterView>){
        this.listCharacters.addAll(listCharacters)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val cardBinding= CardCharacterBinding.inflate(layoutInflater, parent,false)
        return CharacterViewHolder(cardBinding)
    }

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        val results = listCharacters[position]
        holder.onBind(results)
    }

    override fun getItemCount(): Int {
        return listCharacters.size
    }

    inner class CharacterViewHolder(private val viewBinding: CardCharacterBinding) : RecyclerView.ViewHolder(viewBinding.root){

        fun onBind(result: CharacterView){
            viewBinding.character = result
        }
    }
}