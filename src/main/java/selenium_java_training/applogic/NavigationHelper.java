package selenium_java_training.applogic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NavigationHelper extends BaseHelper {

    public NavigationHelper(ApplicationManager manager) {
        super(manager.getDriver());
    }

    public void goToAddMoviePage() {
        pages.homePage.clickAddMovie().ensurePageLoaded();
    }

    public void goToHomePage() {
        pages.internalPage.clickHomeLink().ensurePageLoaded();
    }

}
