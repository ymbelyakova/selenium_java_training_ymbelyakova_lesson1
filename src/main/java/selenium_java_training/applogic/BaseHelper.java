package selenium_java_training.applogic;

import java.io.File;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.WebDriverWait;

import selenium_java_training.pages.PageManager;

public class BaseHelper {

    protected WebDriver driver;
    protected WebDriverWait wait;
    protected PageManager pages;

    public BaseHelper(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 10);
        pages = new PageManager(driver);
    }



    public void click(By locator) {
        driver.findElement(locator).click();
    }

    public void type(By locator, String text) {
        click(locator);
        if (text != null) {
            String existingText = driver.findElement(locator).getAttribute("value");
            if (!text.equals(existingText)) {
                driver.findElement(locator).clear();
                driver.findElement(locator).sendKeys(text);
            }
        }
    }
    
    public void setFile(By locator, String path) {
    	driver.findElement(locator).clear();
    	File file = new File(path);
        driver.findElement(locator).sendKeys(file.getAbsolutePath());
    }


}
