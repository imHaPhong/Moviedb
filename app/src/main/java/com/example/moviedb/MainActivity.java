package com.example.moviedb;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    private JsonHolder jsonHolder;
    private List<Movie> listMovie;
    private Result[] results;
    private RecyclerView movieRecycleView;
    private RecyclerView.LayoutManager mLayoutManager;
    private MovieAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText edtSearch = findViewById(R.id.searchMovie);
        getPopular();
        edtSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if(!editable.toString().trim().isEmpty()){
                    searchMovie(editable.toString());
                }
            }
        });
    }

    private void searchMovie(String keyword) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.themoviedb.org/3/search/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        jsonHolder = retrofit.create(JsonHolder.class);
        Call<Movie> call = jsonHolder.searchMovie(keyword);
        call.enqueue(new Callback<Movie>() {
            @Override
            public void onResponse(Call<Movie> call, Response<Movie> response) {
                Movie movies = response.body();
                results = movies.getResult();
                adapter.filterList(results);
            }

            @Override
            public void onFailure(Call<Movie> call, Throwable t) {

            }
        });
    }

    private void getPopular(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.themoviedb.org/3/movie/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        jsonHolder = retrofit.create(JsonHolder.class);
        Call<Movie> call = jsonHolder.getPopular();
        movieRecycleView =  this.findViewById(R.id.movieRecycleView);
        call.enqueue(new Callback<Movie>() {
            @Override
            public void onResponse(Call<Movie> call, Response<Movie> response) {
                Movie data = response.body();
                adapter = new MovieAdapter(data.getResult());
                results = data.getResult();
                mLayoutManager = new GridLayoutManager(MainActivity.this,4);
                movieRecycleView.setLayoutManager(mLayoutManager);
                movieRecycleView.setAdapter(adapter);
                adapter.setOnItemClickListener(new MovieAdapter.OnItemClickListener() {
                    @Override
                    public void onItemClick(int position) {
                        Intent intent = new Intent(MainActivity.this,MovieDetail.class);
                        intent.putExtra("movieID", results[position].getId().toString());
                        MainActivity.this.startActivity(intent);
                    }
                });
            }

            @Override
            public void onFailure(Call<Movie> call, Throwable t) {

            }
        });
    }
}