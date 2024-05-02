# Movie Listing App

This is a Java application for managing a movie listing system. It provides functionality for users to register, add movies, search movies, manage favorites, and more.

## Technologies Used

- Java
- JUnit (for unit testing)

## Getting Started

To get started with this project, you can follow these steps:

1. Clone the repository to your local machine.
2. Import the project into your preferred Java IDE.
3. Run the `MovieListingAppTest` class to execute the unit tests and ensure everything is working correctly.

### Prerequisites

- Java Development Kit (JDK) installed
- Integrated Development Environment (IDE) such as IntelliJ IDEA or Eclipse

### Installation

1. Clone the repository:

    ```bash
    git clone https://github.com/your_username/movie-listing-app.git
    ```

2. Open the project in your IDE.
3. Build the project to resolve dependencies.


## Features

### User Management

- `registerUser(email, name)`: Allows users to register with their email and name.
- `viewUserDetails(email)`: Retrieves details of a registered user by email.

### Movie Management

- `addMovie(title, actors, genre, releaseDate, budget)`: Adds a new movie with its details.
- `searchMovies(keyword)`: Searches for movies based on a keyword.
- `getAllMovies()`: Retrieves details of all movies in the system.

### Favorite Management

- `addMovieToFavorites(email, movieTitle)`: Adds a movie to a user's list of favorites.
- `removeMovieFromFavorites(email, movieTitle)`: Removes a movie from a user's list of favorites.
- `getAllFavoriteMovies(email)`: Retrieves all favorite movies of a user.

## Usage

You can use the provided methods to interact with the movie listing system. Here are some examples:

```java
// Register a new user
movieApp.registerUser("test@example.com", "Test User");

// Add a new movie
movieApp.addMovie("Inception", Arrays.asList("Leonardo DiCaprio", "Joseph Gordon-Levitt"), "Sci-Fi", "2010-07-16", 160000000);

// Search for movies
List<IMovie> actionMovies = movieApp.searchMovies("Action");

// Add a movie to favorites
movieApp.addMovieToFavorites("test@example.com", "Inception");

// Get all favorite movies of a user
List<IMovie> favoriteMovies = movieApp.getAllFavoriteMovies("test@example.com");

```
## Contributing

Contributions are welcome! If you find any issues or have suggestions for improvements, feel free to open an issue or create a pull request.
