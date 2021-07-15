package com.example.imageretrofit.server

import com.example.imageretrofit.data.Movies
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET


//https://api.themoviedb.org/3/movie/popular?api_key=7699d2afc26f0e8a727ea7b81b5bb599
const val BASE_URL = "https://api.themoviedb.org/3/"
const val API_KEY = "7699d2afc26f0e8a727ea7b81b5bb599"
interface MovieApi {
    @GET("movie/popular?api_key=$API_KEY")
    fun getAllImages():Call<Movies>

}
//https://api.themoviedb.org/3/3/movie/popular?api_key=7699d2afc26f0e8a727ea7b81b5bb599
object MoviesService {
    val movieInstance: MovieApi

    init {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        movieInstance = retrofit.create(MovieApi::class.java)
    }
}