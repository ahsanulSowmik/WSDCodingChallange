package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import java.util.ArrayList;
import java.util.List;

public class MovieListingApp {
    private List<IUser> users;
    private List<IMovie> movies;

    public MovieListingApp() {
        this.users = new ArrayList<>();
        this.movies = new ArrayList<>();
    }

    public void registerUser(String email, String name) {
        users.add(new User(email, name));
    }

    public void addMovie(String title, List<String> cast, String category, String releaseDate, double budget) {
        movies.add(new Movie(title, cast, category, releaseDate, budget));
    }

    public List<IMovie> searchMovies(String keyword) {
        List<IMovie> result = new ArrayList<>();
        for (IMovie movie : movies) {
            if (movie.getTitle().toLowerCase().contains(keyword.toLowerCase()) ||
                    movie.getCast().stream().anyMatch(c -> c.toLowerCase().contains(keyword.toLowerCase())) ||
                    movie.getCategory().toLowerCase().contains(keyword.toLowerCase())) {
                result.add(movie);
            }
        }
        return result;
    }

    public IUser viewUserDetails(String email) {
        for (IUser user : users) {
            if (user.getEmail().equalsIgnoreCase(email)) {
                return user;
            }
        }
        return null;
    }

    public void addMovieToFavorites(String userEmail, String movieTitle) {
        IUser user = findUserByEmail(userEmail);
        if (user != null) {
            IMovie movie = findMovieByTitle(movieTitle);
            if (movie != null) {
                user.addFavorite(new FavoriteMovie(movie));
            }
        }
    }

    public void removeMovieFromFavorites(String userEmail, String movieTitle) {
        IUser user = findUserByEmail(userEmail);
        if (user != null) {
            user.getFavorites().removeIf(favorite -> favorite.getMovie().getTitle().equalsIgnoreCase(movieTitle));
        }
    }

    public List<IMovie> getAllMovies() {
        return movies;
    }

    public List<IMovie> getAllFavoriteMovies(String userEmail) {
        IUser user = findUserByEmail(userEmail);
        if (user != null) {
            List<IFavoriteMovie> favoriteMovies = user.getFavorites();
            List<IMovie> result = new ArrayList<>();
            for (IFavoriteMovie favoriteMovie : favoriteMovies) {
                result.add(favoriteMovie.getMovie());
            }
            return result;
        } else {
            return new ArrayList<>();
        }
    }

    private IUser findUserByEmail(String email) {
        for (IUser user : users) {
            if (user.getEmail().equalsIgnoreCase(email)) {
                return user;
            }
        }
        return null;
    }

    private IMovie findMovieByTitle(String title) {
        for (IMovie movie : movies) {
            if (movie.getTitle().equalsIgnoreCase(title)) {
                return movie;
            }
        }
        return null;
    }
}

