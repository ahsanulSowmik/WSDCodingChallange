package org.example;

public class FavoriteMovie implements IFavoriteMovie {
    private IMovie movie;

    public FavoriteMovie(IMovie movie) {
        this.movie = movie;
    }

    @Override
    public IMovie getMovie() {
        return movie;
    }
}