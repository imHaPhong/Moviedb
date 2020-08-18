package com.example.moviedb;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface JsonHolder {
    @GET("popular?api_key=22662802eec40b605353e91bbe26ee44&language=vi&page=1")
    Call<Movie> getPopular();

    @GET("{movie_id}?api_key=22662802eec40b605353e91bbe26ee44&language=en-US")
    Call<MovieDetailModel> getMovie(@Path("movie_id") String movieId);

    @GET("movie?api_key=22662802eec40b605353e91bbe26ee44&language=en-US&page=1&include_adult=false&}")
    Call<Movie> searchMovie(@Query("query") String keyword);
}
