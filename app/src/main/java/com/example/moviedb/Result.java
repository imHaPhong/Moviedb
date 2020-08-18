package com.example.moviedb;

import java.util.Date;

public class Result {
    private Integer id;
    private String title;
    private double vote;
    private  String overview;
    private String poster_path;
    private Date release_date;

    public Result(Integer id, String title, double vote, String overview, String poster_path, Date release_date) {
        this.id = id;
        this.title = title;
        this.vote = vote;
        this.overview = overview;
        this.poster_path = poster_path;
        this.release_date = release_date;
    }

    public String getPoster_path() {
        return poster_path;
    }

    public void setPoster_path(String poster_path) {
        this.poster_path = poster_path;
    }

    public Date getRelease_date() {
        return release_date;
    }

    public void setRelease_date(Date release_date) {
        this.release_date = release_date;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getVote() {
        return vote;
    }

    public void setVote(double vote) {
        this.vote = vote;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getPosterPath() {
        return poster_path;
    }

    public void setPosterPath(String posterPath) {
        this.poster_path = posterPath;
    }
}
