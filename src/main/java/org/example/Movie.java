package org.example;

import java.util.List;

public class Movie implements IMovie {
    private String title;
    private List<String> cast;
    private String category;
    private String releaseDate;
    private double budget;

    public Movie(String title, List<String> cast, String category, String releaseDate, double budget) {
        this.title = title;
        this.cast = cast;
        this.category = category;
        this.releaseDate = releaseDate;
        this.budget = budget;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public List<String> getCast() {
        return cast;
    }

    @Override
    public String getCategory() {
        return category;
    }

    @Override
    public String getReleaseDate() {
        return releaseDate;
    }

    @Override
    public double getBudget() {
        return budget;
    }
}