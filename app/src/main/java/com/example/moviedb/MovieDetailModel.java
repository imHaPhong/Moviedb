package com.example.moviedb;

public class MovieDetailModel {
    private String overview;
    private String backdrop_path;
    private String original_title;
    private String poster_path;

    public MovieDetailModel(String overview, String backdrop_path, String original_title, String poster_path) {
        this.overview = overview;
        this.backdrop_path = backdrop_path;
        this.original_title = original_title;
        this.poster_path = poster_path;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getBackdrop_path() {
        return backdrop_path;
    }

    public void setBackdrop_path(String backdrop_path) {
        this.backdrop_path = backdrop_path;
    }

    public String getOriginal_title() {
        return original_title;
    }

    public void setOriginal_title(String original_title) {
        this.original_title = original_title;
    }

    public String getPoster_path() {
        return poster_path;
    }

    public void setPoster_path(String poster_path) {
        this.poster_path = poster_path;
    }
}
