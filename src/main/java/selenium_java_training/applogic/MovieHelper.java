package selenium_java_training.applogic;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.*;

import selenium_java_training.model.Movie;


public class MovieHelper extends BaseHelper {

    public MovieHelper(ApplicationManager manager) {
        super(manager.getDriver());
    }

    public boolean isLoggedIn (){
        return pages.internalPage.waitPageLoaded();
    }
    
    public List<WebElement> allMovies() {
        return pages.homePage.ensurePageLoaded().getMovies();
    }
    
    public List<Movie> getAllMovies() {
        List<Movie> movies = new ArrayList<Movie>();
        for (WebElement el : allMovies()) {
            String title = el.getText();
            movies.add(new Movie().setTitle(title));
        }
        return movies;
    }

    public void createMovie(Movie movie) {
    	//pages.addPage.setImdbid(movie.getImdbid());
        pages.addPage.setTitle(movie.getTitle());
        // pages.addPage.setAka(movie.getAka());
        pages.addPage.setYear(movie.getYear());
        // pages.addPage.setDuration(movie.getDuration());
        //pages.addPage.setRating(movie.getRating());
        pages.addPage.clickSubmit();
    }

    public boolean isMovieSaved (){
        return pages.moviePage.waitPageLoaded();
    }

    public void openMovieToDelete(int index) {
        pages.homePage.ensurePageLoaded()
        .openMovie(index)
        .ensurePageLoaded();
    }

    
    public void deleteMovie() {
        pages.moviePage.clickRemoveButton().ensurePageLoaded();
    }
    
    public void cancelDeleteMovie() {
        pages.moviePage.cancelRemove().ensurePageLoaded();
    }

    public void searchMovies(String title) {
        pages.homePage.ensurePageLoaded().searchByTitle(title).ensurePageLoaded();
    }

    public String searchNotFound(String somenotfoundmovie) {
        pages.homePage.ensurePageLoaded().searchByTitle(somenotfoundmovie).ensurePageLoaded();
        return pages.homePage.getSearchNull();
    }

    public boolean isFieldRequired() {
        try {
            pages.addPage.getRequiredFild();
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }
}

