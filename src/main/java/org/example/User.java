package org.example;

import java.util.ArrayList;
import java.util.List;

public class User implements IUser {
    private String email;
    private String name;
    private List<IFavoriteMovie> favorites;

    public User(String email, String name) {
        this.email = email;
        this.name = name;
        this.favorites = new ArrayList<>();
    }

    @Override
    public String getEmail() {
        return email;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public List<IFavoriteMovie> getFavorites() {
        return favorites;
    }

    @Override
    public void addFavorite(IFavoriteMovie favoriteMovie) {
        favorites.add(favoriteMovie);
    }

    @Override
    public void removeFavorite(IFavoriteMovie favoriteMovie) {
        favorites.remove(favoriteMovie);
    }
}
