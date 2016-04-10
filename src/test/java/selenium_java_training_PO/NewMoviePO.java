package selenium_java_training_PO;

import static org.testng.AssertJUnit.*;

import java.util.List;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import selenium_java_training.model.Movie;

public class NewMoviePO extends TestBase {
	
    @Test
    public void testNewMovie() throws Exception {
        app.getNavigationHelper().goToHomePage();
        List<Movie> movieOrig = app.getMovieHelper().getAllMovies();
        int countorig = movieOrig.size();

        app.getNavigationHelper().goToAddMoviePage();
        Movie movie = new Movie().setTitle("New Movie PO")
        		.setYear("2016");
        app.getMovieHelper().type(By.name("aka"),"New Movie by Yulia Belyakova");
        app.getMovieHelper().type(By.name("duration"),"121");
        app.getMovieHelper().type(By.name("rating"),"10");
        app.getMovieHelper().type(By.name("imdbid"),"99999");
        app.getMovieHelper().click(By.id("own_no"));
        app.getMovieHelper().click(By.id("seen_no"));
        app.getMovieHelper().click(By.id("loaned_yes"));
        app.getMovieHelper().type(By.name("loanname"), "2016-03-29");
        app.getMovieHelper().setFile(By.id("cover"), "src/test/resource/images/new_movie.jpg");
        //app.getMovieHelper().setFile(By.id("cover"), "C:\\GitHub\\images\\new_movie.jpg");
        app.getMovieHelper().type(By.name("trailer"),"https://www.youtube.com/watch?v=ap_avaJApm8");
        app.getMovieHelper().type(By.name("notes"),"Personal notes test");
        app.getMovieHelper().type(By.name("taglines"),"Taglines test");
        app.getMovieHelper().type(By.name("plotoutline"),"Plot outline test");
        app.getMovieHelper().type(By.name("plots"),"Plots test");
        app.getMovieHelper().type(By.id("text_languages_0"),"EN, RU");
        app.getMovieHelper().type(By.name("subtitles"),"Subtitles test");
        app.getMovieHelper().type(By.name("audio"),"Audio test");
        app.getMovieHelper().type(By.name("video"),"Video test");
        app.getMovieHelper().type(By.name("country"),"RU");
        app.getMovieHelper().type(By.name("genres"),"Comedy");
        app.getMovieHelper().type(By.name("director"),"Director test");
        app.getMovieHelper().type(By.name("writer"),"Writer test");
        app.getMovieHelper().type(By.name("producer"),"Producer test");
        app.getMovieHelper().type(By.name("music"),"Music test");
        app.getMovieHelper().type(By.name("cast"),"Cast test");
        //assertFalse(app.getMovieHelper().isFieldRequired());
        Thread.sleep(500);
        app.getMovieHelper().createMovie(movie);

        assertTrue(app.getMovieHelper().isMovieSaved());

        app.getNavigationHelper().goToHomePage();
        List<Movie> moviesRes = app.getMovieHelper().getAllMovies();
        int countres = moviesRes.size();

        System.out.println(countorig);
        System.out.println(countres);
        if (countres != countorig + 1) System.out.println("Something is wrong");
        else System.out.println("All is OK. One movie was created.");

    }
    
    @Test
    public void testNegativeAdd() {
        app.getNavigationHelper().goToHomePage();
        List<Movie> moviesOrig = app.getMovieHelper().getAllMovies();
        int countorig = moviesOrig.size();

        app.getNavigationHelper().goToAddMoviePage();
        Movie movie = new Movie().setTitle("Some movie not to be created");
        app.getMovieHelper().createMovie(movie);

        assertTrue(app.getMovieHelper().isFieldRequired());
        assertFalse(app.getMovieHelper().isMovieSaved());

        app.getNavigationHelper().goToHomePage();
        List<Movie> moviesRes = app.getMovieHelper().getAllMovies();
        int countres = moviesRes.size();

        System.out.println(countorig);
        System.out.println(countres);
        if (countres != countorig) System.out.println("Something is wrong");
        else System.out.println("All is OK. No movie was created.");

    }

}
