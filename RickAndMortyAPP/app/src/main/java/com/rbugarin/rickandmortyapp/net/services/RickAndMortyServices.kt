package com.rbugarin.rickandmortyapp.net.services

import com.rbugarin.rickandmortyapp.models.CharacterPageRequest
import com.rbugarin.rickandmortyapp.models.Episode
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.http.Url
import javax.security.auth.callback.Callback

interface RickAndMortyServices {
    @GET("character")
    fun getCharacterPage(@Query("page")page:Int) : Call<CharacterPageRequest>

    @GET
    fun getEpisode(@Url url: String) : Call<Episode>
}