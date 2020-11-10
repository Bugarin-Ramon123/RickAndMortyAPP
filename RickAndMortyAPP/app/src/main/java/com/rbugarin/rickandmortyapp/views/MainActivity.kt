package com.rbugarin.rickandmortyapp.views

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.viewModels
import androidx.databinding.BindingAdapter
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.rbugarin.rickandmortyapp.R
import com.rbugarin.rickandmortyapp.adapters.CharacterAdapter
import com.rbugarin.rickandmortyapp.models.CharacterView
import com.rbugarin.rickandmortyapp.viewmodels.MainActivityViewModel

@BindingAdapter("imageUrl")
fun loadImage(view : ImageView, url : String){
    Glide.with(view.context)
        .load(url)
        .into(view)
}

@BindingAdapter("statusColor")
fun changeColorFromStatus(textview : TextView, status : String){
    when (status) {
        "Alive" -> {
            textview.setTextColor(Color.GREEN)
        }
        "Dead" -> {
            textview.setTextColor(Color.RED)
        }
        else -> {
            textview.setTextColor(Color.GRAY)
        }
    }
}

class MainActivity : AppCompatActivity() {

    private val mainActivityViewModel : MainActivityViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerViewData)
        val characterAdapter = CharacterAdapter()
        recyclerView.layoutManager = LinearLayoutManager(this)

        recyclerView.adapter = characterAdapter

        mainActivityViewModel.rickAndMortyListLiveData.observe(this,
            Observer<List<CharacterView>> { characterview ->
            characterAdapter.addResults(characterview)
                characterAdapter.notifyDataSetChanged()
            }
        )

        mainActivityViewModel.getCharacters()
        }
}