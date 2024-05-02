
import org.example.IFavoriteMovie;
import org.example.IMovie;
import org.example.IUser;
import org.example.MovieListingApp;
import org.junit.*;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MovieListingAppTest {
    private MovieListingApp movieApp;

    @Before
    public void setUp() {
        movieApp = new MovieListingApp();
    }

    @Test
    public void testRegisterUser() {
        movieApp.registerUser("test@example.com", "Test User");
        IUser user = movieApp.viewUserDetails("test@example.com");
        assertNotNull(user);
        assertEquals("test@example.com", user.getEmail());
        assertEquals("Test User", user.getName());

        // Print statements for debugging
        System.out.println("User registered successfully:");
        System.out.println("Email: " + user.getEmail());
        System.out.println("Name: " + user.getName());
    }

    @Test
    public void testAddMovie() {
        movieApp.addMovie("Inception", Arrays.asList("Leonardo DiCaprio", "Joseph Gordon-Levitt"), "Sci-Fi", "2010-07-16", 160000000);
        List<IMovie> movies = movieApp.searchMovies("Inception");
        assertFalse(movies.isEmpty());
        assertEquals("Inception", movies.get(0).getTitle());

        // Print statements for debugging
        System.out.println("Movie added successfully:");
        System.out.println("Title: " + movies.get(0).getTitle());
    }

    @Test
    public void testSearchMovies() {
        movieApp.addMovie("Inception", Arrays.asList("Leonardo DiCaprio", "Joseph Gordon-Levitt"), "Sci-Fi", "2010-07-16", 160000000);
        movieApp.addMovie("The Dark Knight", Arrays.asList("Christian Bale", "Heath Ledger"), "Action", "2008-07-18", 185000000);

        List<IMovie> actionMovies = movieApp.searchMovies("Action");
        assertEquals(1, actionMovies.size());
        assertEquals("The Dark Knight", actionMovies.get(0).getTitle());

        // Print statements for debugging
        System.out.println("Movies found for 'Action' category:");
        for (IMovie movie : actionMovies) {
            System.out.println("Title: " + movie.getTitle());
        }
    }

    @Test
    public void testViewUserDetails() {
        movieApp.registerUser("test@example.com", "Test User");
        IUser user = movieApp.viewUserDetails("test@example.com");
        assertNotNull(user);
        assertEquals("test@example.com", user.getEmail());
        assertEquals("Test User", user.getName());

        // Print statements for debugging
        System.out.println("User details retrieved successfully:");
        System.out.println("Email: " + user.getEmail());
        System.out.println("Name: " + user.getName());
    }

    @Test
    public void testAddMovieToFavorites() {
        movieApp.registerUser("test@example.com", "Test User");
        movieApp.addMovie("Inception", Arrays.asList("Leonardo DiCaprio", "Joseph Gordon-Levitt"), "Sci-Fi", "2010-07-16", 160000000);

        movieApp.addMovieToFavorites("test@example.com", "Inception");
        IUser user = movieApp.viewUserDetails("test@example.com");
        assertNotNull(user);
        assertEquals(1, user.getFavorites().size());
        assertEquals("Inception", user.getFavorites().get(0).getMovie().getTitle());

        // Print statements for debugging
        System.out.println("Movie added to favorites successfully:");
        System.out.println("Title: " + user.getFavorites().get(0).getMovie().getTitle());
    }

    @Test
    public void testRemoveMovieFromFavorites() {
        movieApp.registerUser("test@example.com", "Test User");
        movieApp.addMovie("Inception", Arrays.asList("Leonardo DiCaprio", "Joseph Gordon-Levitt"), "Sci-Fi", "2010-07-16", 160000000);
        movieApp.addMovie("The Dark Knight", Arrays.asList("Christian Bale", "Heath Ledger"), "Action", "2008-07-18", 185000000);

        movieApp.addMovieToFavorites("test@example.com", "Inception");
        movieApp.addMovieToFavorites("test@example.com", "The Dark Knight");

        movieApp.removeMovieFromFavorites("test@example.com", "Inception");
        IUser user = movieApp.viewUserDetails("test@example.com");
        assertNotNull(user);
        assertEquals(1, user.getFavorites().size());
        assertEquals("The Dark Knight", user.getFavorites().get(0).getMovie().getTitle());

        // Print statements for debugging
        System.out.println("Movie removed from favorites successfully:");
        System.out.println("Remaining favorite movie: " + user.getFavorites().get(0).getMovie().getTitle());
    }

    @Test
    public void testGetAllMovies() {
        movieApp.addMovie("Inception", Arrays.asList("Leonardo DiCaprio", "Joseph Gordon-Levitt"), "Sci-Fi", "2010-07-16", 160000000);
        movieApp.addMovie("The Dark Knight", Arrays.asList("Christian Bale", "Heath Ledger"), "Action", "2008-07-18", 185000000);

        List<IMovie> allMovies = movieApp.getAllMovies();
        assertEquals(2, allMovies.size());

        // Print statements for debugging
        System.out.println("All movies:");
        for (IMovie movie : allMovies) {
            System.out.println("Title: " + movie.getTitle());
        }
    }

    @Test
    public void testGetAllFavoriteMovies() {
        movieApp.registerUser("test@example.com", "Test User");
        movieApp.addMovie("Inception", Arrays.asList("Leonardo DiCaprio", "Joseph Gordon-Levitt"), "Sci-Fi", "2010-07-16", 160000000);
        movieApp.addMovie("The Dark Knight", Arrays.asList("Christian Bale", "Heath Ledger"), "Action", "2008-07-18", 185000000);

        movieApp.addMovieToFavorites("test@example.com", "Inception");
        movieApp.addMovieToFavorites("test@example.com", "The Dark Knight");

        List<IMovie> favoriteMovies = movieApp.getAllFavoriteMovies("test@example.com");
        assertEquals(2, favoriteMovies.size());

        // Print statements for debugging
        System.out.println("Favorite movies for user 'test@example.com':");
        for (IMovie movie : favoriteMovies) {
            System.out.println("Title: " + movie.getTitle());
        }
    }
}
