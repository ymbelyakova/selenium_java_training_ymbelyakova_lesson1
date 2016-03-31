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

public class NegativeAdd extends selenium_java_training.TestBase {
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Test
  public void NegativeAdd() throws Exception {
    driver.get(baseUrl + "/php4dvd/");
    WebDriverWait wait =
    		new WebDriverWait(driver, 30);
    wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("div.title")));
    int countorig=driver.findElements(By.cssSelector("div.title")).size();
    wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("img[alt=\"Add movie\"]")));
    driver.findElement(By.cssSelector("img[alt=\"Add movie\"]")).click();
    
    wait.until(ExpectedConditions.elementToBeClickable(By.name("name")));
    driver.findElement(By.name("name")).clear();
    driver.findElement(By.name("name")).sendKeys("");
    wait.until(ExpectedConditions.elementToBeClickable(By.name("year")));
    driver.findElement(By.name("year")).clear();
    driver.findElement(By.name("year")).sendKeys("");
    driver.findElement(By.id("cover")).clear();
    driver.findElement(By.cssSelector("img[alt=\"Save\"]")).click();
    
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("label[for=\"name\"][class=\"error\"]")));
    try {
    	assertTrue(driver.findElement(By.cssSelector("label[for=\"name\"][class=\"error\"]")).getText().matches("This field is required"));
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("label[for=\"year\"][class=\"error\"]")));
    try {
    	assertTrue(driver.findElement(By.cssSelector("label[for=\"year\"][class=\"error\"]")).getText().matches("This field is required"));
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    
    driver.findElement(By.name("name")).clear();
    driver.findElement(By.name("name")).sendKeys("American Crime Story");
    driver.findElement(By.name("aka")).clear();
    driver.findElement(By.name("aka")).sendKeys("American Crime Story");
    wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("label[for=\"name\"][class=\"error\"]")));
    try {
      assertFalse(driver.findElement(By.cssSelector("label[for=\"name\"][class=\"error\"]")).isDisplayed());
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    
    driver.findElement(By.cssSelector("img[alt=\"Save\"]")).click();
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("label[for=\"year\"][class=\"error\"]")));
    try {
    	assertTrue(driver.findElement(By.cssSelector("label[for=\"year\"][class=\"error\"]")).getText().matches("This field is required"));
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    driver.get(baseUrl + "/php4dvd/");
    wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("div.title")));
    int countres=driver.findElements(By.cssSelector("div.title")).size();
    System.out.println(countorig);
    System.out.println(countres);
    if (countres != countorig) System.out.println("Something is wrong");
    else System.out.println("All is OK");
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