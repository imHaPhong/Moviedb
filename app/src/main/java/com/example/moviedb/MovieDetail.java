package com.example.moviedb;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MovieDetail extends AppCompatActivity {
    private JsonHolder jsonHolder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_detail);
        Intent intent = this.getIntent();
        String result = intent.getStringExtra("movieID");
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.themoviedb.org/3/movie/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        jsonHolder = retrofit.create(JsonHolder.class);
        Call<MovieDetailModel> call = jsonHolder.getMovie(result);
        call.enqueue(new Callback<MovieDetailModel>() {
            @Override
            public void onResponse(Call<MovieDetailModel> call, Response<MovieDetailModel> response) {
                MovieDetailModel movie = response.body();
                ImageView backdrop_path = MovieDetail.this.findViewById(R.id.backdrop_path);
                ImageView imagePoster = MovieDetail.this.findViewById(R.id.imagePoster);
                TextView overview = MovieDetail.this.findViewById(R.id.overview);
                TextView title = MovieDetail.this.findViewById(R.id.original_title);
                System.out.println(movie.getPoster_path() + "");
                overview.setText(movie.getOverview());
                title.setText(movie.getOriginal_title());
                Picasso.with(MovieDetail.this)
                        .load("https://image.tmdb.org/t/p/w220_and_h330_face" + movie.getPoster_path())
                        .into(imagePoster);
                Picasso.with(MovieDetail.this)
                        .load("https://image.tmdb.org/t/p/w220_and_h330_face" + movie.getBackdrop_path())
                        .into(backdrop_path);
            }

            @Override
            public void onFailure(Call<MovieDetailModel> call, Throwable t) {

            }
        });
    }
}