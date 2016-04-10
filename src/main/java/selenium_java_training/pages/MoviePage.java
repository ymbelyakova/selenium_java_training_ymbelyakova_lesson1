package selenium_java_training.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

public class MoviePage extends AnyPage {

    @FindBy(linkText="Remove")
    private WebElement removeButton;

    public MoviePage(PageManager pages) {
        super(pages);
    }

    public HomePage clickRemoveButton() {
        removeButton.click();
        driver.switchTo().alert().accept();
        return pages.homePage;
    }
    
    public MoviePage cancelRemove() {
    	removeButton.click();
    	driver.switchTo().alert().dismiss();
    	return this;
    }

    public MoviePage ensurePageLoaded() {
        super.ensurePageLoaded();
        wait.until(presenceOfElementLocated(By.id("movie")));
        return this;
    }
}

