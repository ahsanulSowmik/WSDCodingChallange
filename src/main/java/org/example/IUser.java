package org.example;

import java.util.List;

public interface IUser {
    String getEmail();
    String getName();
    List<IFavoriteMovie> getFavorites();
    void addFavorite(IFavoriteMovie favoriteMovie);
    void removeFavorite(IFavoriteMovie favoriteMovie);
}