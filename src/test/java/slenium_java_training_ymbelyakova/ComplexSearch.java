package slenium_java_training_ymbelyakova;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.testng.*;
import org.testng.annotations.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ComplexSearch extends selenium_java_training.TestBase {
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Test
  public void testComplexSearch() throws Exception {
	driver.get(baseUrl + "/php4dvd/");
	// проверяем, что нет фильма somenotfoundmovie
	WebElement search = driver.findElement(By.id("q"));
	search.clear();
	search.sendKeys("somenotfoundmovie" + Keys.RETURN);
	WebDriverWait wait =
    		new WebDriverWait(driver, 30);
	wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("div.title")));
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.content")));
    wait.until(ExpectedConditions.textToBePresentInElementLocated(By.cssSelector("div.content"), "No movies where found."));
	try {
	      assertEquals("No movies where found.", driver.findElement(By.cssSelector("div.content")).getText());
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	// проверяем, что есть фильм test
	search.clear();
    search.sendKeys("test" + Keys.RETURN);
    wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("div.content")));
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.title")));
    WebElement title = driver.findElement(By.cssSelector("div.title"));
    try {
        assertTrue(title.getAttribute("innerText").matches("Test"));
      } catch (Error e) {
        verificationErrors.append(e.toString());
      }
    Thread.sleep(500);
    //выбираем категорию Animation и проверяем, что в ней нет test
    driver.findElement(By.id("category-button")).click();
    driver.findElement(By.id("category-menu")).findElement(By.linkText("Animation")).click();
    wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("div.title")));
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.content")));
    wait.until(ExpectedConditions.textToBePresentInElementLocated(By.cssSelector("div.content"), "No movies where found."));
    try {
	      assertEquals("No movies where found.", driver.findElement(By.cssSelector("div.content")).getText());
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
    //выбираем категорию Comedy и проверяем, что в ней есть test
    driver.findElement(By.id("category-button")).click();
    driver.findElement(By.id("category-menu")).findElement(By.linkText("Comedy")).click();
    wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("div.content")));
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.title")));
    try {
        assertTrue(driver.findElement(By.cssSelector("div.title")).getAttribute("innerText").matches("Test"));
      } catch (Error e) {
        verificationErrors.append(e.toString());
      }
    
    Thread.sleep(500);
    
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}