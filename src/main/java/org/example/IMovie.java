package org.example;

import java.util.List;

public interface IMovie {
    String getTitle();
    List<String> getCast();
    String getCategory();
    String getReleaseDate();
    double getBudget();
}