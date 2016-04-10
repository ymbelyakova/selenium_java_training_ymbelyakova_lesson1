package selenium_java_training.pages;

import java.lang.reflect.Field;
import org.openqa.selenium.*;
import org.openqa.selenium.support.pagefactory.*;

public class DisplayedElementLocatorFactory implements ElementLocatorFactory {
	  private final WebDriver driver;
	  private final int timeOutInSeconds;

	  public DisplayedElementLocatorFactory(WebDriver driver, int timeOutInSeconds) {
	    this.driver = driver;
	    this.timeOutInSeconds = timeOutInSeconds;
	  }

	  public ElementLocator createLocator(Field field) {
	    return new DisplayedElementLocator(driver, field, timeOutInSeconds);
	  }
	}