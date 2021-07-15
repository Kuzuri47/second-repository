package com.example.imageretrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.imageretrofit.adapter.MyRecyclerViweAdapter
import com.example.imageretrofit.data.Movies
import com.example.imageretrofit.server.MoviesService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    lateinit var myrecyclerView: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        getMovieImages()
    }

    private fun getMovieImages() {
        val retrofitService =MoviesService.movieInstance.getAllImages()
            retrofitService.enqueue(object : Callback<Movies>{
                override fun onResponse(call: Call<Movies>, response: Response<Movies>) {
                    val movieList = response.body()
                    if (movieList!=null){
                        Log.i("MYTAG",movieList.toString())
                        myrecyclerView = findViewById(R.id.image_recycler_view)
                        myrecyclerView.layoutManager = LinearLayoutManager(this@MainActivity)
                        myrecyclerView.adapter = MyRecyclerViweAdapter(this@MainActivity,movieList.results)
                    }

                }

                override fun onFailure(call: Call<Movies>, t: Throwable) {
                    Log.i("MYTAG","Failed to fetch data",t)

                }

            })


    }
}