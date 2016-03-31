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

public class DeleteMovie2 extends selenium_java_training.TestBase {
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Test
  public void testDeleteMovie() throws Exception {
    driver.get(baseUrl + "/php4dvd/");
    WebDriverWait wait =
    		new WebDriverWait(driver, 30);
    wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("div.title")));
    int countorig=driver.findElements(By.cssSelector("div.title")).size();
    driver.findElement(By.cssSelector("div[class=\"title\"]")).click();
    wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("img[alt=\"Remove\"]")));
    acceptNextAlert = false;
    driver.findElement(By.cssSelector("img[alt=\"Remove\"]")).click();
    assertTrue(closeAlertAndGetItsText().matches("^Are you sure you want to remove this[\\s\\S]$"));
    Thread.sleep(500);
    driver.findElement(By.cssSelector("img[alt=\"Remove\"]")).click();
    assertTrue(closeAlertAndGetItsText().matches("^Are you sure you want to remove this[\\s\\S]$"));
    wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("div.title")));
    int countres=driver.findElements(By.cssSelector("div.title")).size();
    System.out.println(countorig);
    System.out.println(countres);
    if (countres != countorig - 1) System.out.println("Something is wrong");
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