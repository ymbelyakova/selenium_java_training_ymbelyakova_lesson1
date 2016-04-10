package selenium_java_training_PO;

import java.util.List;
import org.openqa.selenium.*;
import org.testng.*;

import org.testng.annotations.Test;

import selenium_java_training.model.Movie;

public class DeleteMoviePO extends TestBase {
		
	@Test
    public void testCancelDeleteMovie() throws Exception {
        app.getNavigationHelper().goToHomePage();
        List<Movie> moviesOrig = app.getMovieHelper().getAllMovies();
        int countorig = moviesOrig.size();

        app.getMovieHelper().openMovieToDelete(0);
        app.getMovieHelper().cancelDeleteMovie();

        app.getNavigationHelper().goToHomePage();
        List<Movie> moviesRes = app.getMovieHelper().getAllMovies();
        int countres = moviesRes.size();

        System.out.println(countorig);
        System.out.println(countres);
        if (countres != countorig) System.out.println("Something is wrong");
        else System.out.println("All is OK. No movie was deleted.");
    }
	
	@Test
    public void testDeleteMovie() throws Exception {
        app.getNavigationHelper().goToHomePage();
        List<Movie> moviesOrig = app.getMovieHelper().getAllMovies();
        int countorig = moviesOrig.size();

        app.getMovieHelper().openMovieToDelete(0);
        app.getMovieHelper().deleteMovie();

        app.getNavigationHelper().goToHomePage();
        List<Movie> moviesRes = app.getMovieHelper().getAllMovies();
        int countres = moviesRes.size();

        System.out.println(countorig);
        System.out.println(countres);
        if (countres != countorig - 1) System.out.println("Something is wrong");
        else System.out.println("All is OK. One movie was deleted.");
    }

}
