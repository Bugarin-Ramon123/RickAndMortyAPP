package com.rbugarin.rickandmortyapp.net

import com.rbugarin.rickandmortyapp.BASE_URL
import com.rbugarin.rickandmortyapp.net.services.RickAndMortyServices
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitInstance {
    companion object{
        @JvmStatic
        private val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        @JvmStatic
        public val rickAndMortyServices = retrofit.create(RickAndMortyServices::class.java)
    }
}