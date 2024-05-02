package org.example;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        MovieListingApp movieApp = new MovieListingApp();
        Scanner scanner = new Scanner(System.in);

        // Sample data (you can remove this in a real application)
        movieApp.addMovie("Inception", Arrays.asList("Leonardo DiCaprio", "Joseph Gordon-Levitt"), "Sci-Fi", "2010-07-16", 160000000);
        movieApp.addMovie("The Dark Knight", Arrays.asList("Christian Bale", "Heath Ledger"), "Action", "2008-07-18", 185000000);

        boolean running = true;
        while (running) {
            System.out.println("Welcome to the Movie Listing App!");
            System.out.println("1. Register User");
            System.out.println("2. Search Movies");
            System.out.println("3. Add Movie to Favorites");
            System.out.println("4. Remove Movie from Favorites");
            System.out.println("5. View All Movies");
            System.out.println("6. View All Favorite Movies");
            System.out.println("7. Exit");
            System.out.print("Choose an option: ");
            int option = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (option) {
                case 1:
                    System.out.print("Enter email: ");
                    String email = scanner.nextLine();
                    System.out.print("Enter name: ");
                    String name = scanner.nextLine();
                    movieApp.registerUser(email, name);
                    System.out.println("User registered successfully!");
                    break;
                case 2:
                    System.out.print("Enter search keyword: ");
                    String keyword = scanner.nextLine();
                    List<IMovie> searchResult = movieApp.searchMovies(keyword);
                    if (searchResult.isEmpty()) {
                        System.out.println("No movies found.");
                    } else {
                        System.out.println("Search results:");
                        for (IMovie movie : searchResult) {
                            System.out.println(movie.getTitle() + " - " + movie.getCategory());
                        }
                    }
                    break;
                case 3:
                    System.out.print("Enter user email: ");
                    String userEmail = scanner.nextLine();
                    System.out.print("Enter movie title: ");
                    String movieTitleToAdd = scanner.nextLine();
                    movieApp.addMovieToFavorites(userEmail, movieTitleToAdd);
                    System.out.println("Movie added to favorites successfully!");
                    break;
                case 4:
                    System.out.print("Enter user email: ");
                    String userEmailToRemove = scanner.nextLine();
                    System.out.print("Enter movie title: ");
                    String movieTitleToRemove = scanner.nextLine();
                    movieApp.removeMovieFromFavorites(userEmailToRemove, movieTitleToRemove);
                    System.out.println("Movie removed from favorites successfully!");
                    break;
                case 5:
                    List<IMovie> allMovies = movieApp.getAllMovies();
                    if (allMovies.isEmpty()) {
                        System.out.println("No movies available.");
                    } else {
                        System.out.println("All Movies:");
                        for (IMovie movie : allMovies) {
                            System.out.println(movie.getTitle() + " - " + movie.getCategory());
                        }
                    }
                    break;
                case 6:
                    System.out.print("Enter user email: ");
                    String userEmailFavorites = scanner.nextLine();
                    List<IMovie> favoriteMovies = movieApp.getAllFavoriteMovies(userEmailFavorites);
                    if (favoriteMovies.isEmpty()) {
                        System.out.println("No favorite movies found for this user.");
                    } else {
                        System.out.println("Favorite Movies:");
                        for (IMovie movie : favoriteMovies) {
                            System.out.println(movie.getTitle() + " - " + movie.getCategory());
                        }
                    }
                    break;
                case 7:
                    running = false;
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
        scanner.close();
    }
}