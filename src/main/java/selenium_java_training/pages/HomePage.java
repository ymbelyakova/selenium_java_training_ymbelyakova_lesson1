package selenium_java_training.pages;

import java.util.List;

import org.openqa.selenium.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.*;
import static org.openqa.selenium.support.ui.ExpectedConditions.*;


/**
 * Sample page
 */
public class HomePage extends InternalPage {

    
	@FindBy(css = "img[alt=\"Add movie\"]")
    private WebElement addMovieButton;

    @FindBy(css = "div.movie_box")
    private WebElement movie;

    @FindBy(css = "div.title")
    private List<WebElement> movies;

    @FindBy(id = "q")
    private WebElement searchInput;

    @FindBy(css = "div.content")
    private WebElement searchNull;


    public HomePage(PageManager pages) {
        super(pages);
    }

    public String getSearchNull() {
        return searchNull.getText();
    }

    public List<WebElement> getMovies() {
        return movies;
    }

    public AddPage clickAddMovie() {
        addMovieButton.click();
        return pages.addPage;
    }

    public MoviePage openMovie(int index) {
        movies.get(index).click();
        return pages.moviePage;
    }

    public HomePage searchByTitle(String  title) {
        searchInput.clear();
        searchInput.sendKeys(title);
        searchInput.sendKeys(Keys.ENTER);
        return this;
    }

    public HomePage ensurePageLoaded() {
        super.ensurePageLoaded();
        wait.until(presenceOfElementLocated(By.id("results")));
        try {
            wait.until(presenceOfAllElementsLocatedBy(By.cssSelector("div.movie_box")));
            return this;
        } catch (TimeoutException ex) {
            return this;
        }
    }
}
