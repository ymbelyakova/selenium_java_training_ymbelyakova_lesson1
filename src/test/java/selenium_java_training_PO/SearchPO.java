package selenium_java_training_PO;

import static org.junit.Assert.assertEquals;
import static org.testng.AssertJUnit.*;
import java.util.List;
import org.openqa.selenium.By;

import org.testng.annotations.Test;

import selenium_java_training.model.Movie;

public class SearchPO extends TestBase {
	@Test
	public void testNegativeSearch() throws Exception {
		app.getNavigationHelper().goToHomePage();
        String nftd = "somenotfoundmovie";
        assertEquals("No movies where found.", app.getMovieHelper().searchNotFound(nftd));
    }
	
	 @Test
	  public void testPositiveSearch() throws Exception {
		 app.getNavigationHelper().goToHomePage();
	        String film = "Test";
	        app.getMovieHelper().searchMovies(film);
	        List<Movie> moviesFound = app.getMovieHelper().getAllMovies();
	        System.out.println(moviesFound.size());
	 }
}
