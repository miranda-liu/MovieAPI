package com.example.movieapi.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.movieapi.R
import com.example.movieapi.models.MovieResult
import com.example.movieapi.services.MovieService
import com.example.movieapi.services.ServiceBuilder
import retrofit2.Call
import retrofit2.Response
import retrofit2.Callback

class MainActivity : AppCompatActivity() {
    val TAG = "MainActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        loadMovies()
    }

    private fun loadMovies(){
        // initiate the service
        val destinationService = ServiceBuilder.buildService(MovieService::class.java)
        // val movieRequest = edittext.text.toString()
        val requestCall = destinationService.getMoviesList("89389cd8", "doubtfire") // put movieRequest in the right ()
        //make network call asynchronously

        // the needed object in enqueue() doesn't actually exist yet, so you make a temporary object
        requestCall.enqueue(object : Callback<MovieResult> {
            override fun onFailure(call: Call<MovieResult>, t: Throwable) {
                Log.d(TAG, "onResponse: " + t.message) // t is the throwable --> data type for a type of error
            }

            override fun onResponse(call: Call<MovieResult>, response: Response<MovieResult>) {
                Log.d(TAG, "onResponse: " + response.body())
                if (response.isSuccessful) {
                    val movieList = response.body()
                        ?: emptyList<MovieResult>() // make emptyList of MovieResult if no response from API
                    Log.d(TAG, "onResponse: $movieList")
                    // Log.d("Response", "movieList size" + movieList.totalResults)
                }
            }
        })
    }

}
