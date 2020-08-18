package com.example.moviedb;

import java.util.ArrayList;
import java.util.List;

public class Movie {
    private Integer page;
    private Integer total_results;
    private Integer total_pages;
    private Result[] results;

    public Movie(Integer page, Integer total_results, Integer total_pages, Result[] result) {
        this.page = page;
        this.total_results = total_results;
        this.total_pages = total_pages;
        this.results = result;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getTotal_results() {
        return total_results;
    }

    public void setTotal_results(Integer total_results) {
        this.total_results = total_results;
    }

    public Integer getTotal_pages() {
        return total_pages;
    }

    public void setTotal_pages(Integer total_pages) {
        this.total_pages = total_pages;
    }

    public Result[] getResult() {
        return results;
    }

    public void setResult(Result[] result) {
        this.results = result;
    }
}
