package slenium_java_training_ymbelyakova;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.testng.*;
import org.testng.annotations.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class FindAndAdd2 extends selenium_java_training.TestBase {
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Test
  public void testFindAndAdd2() throws Exception {
    driver.get(baseUrl + "/php4dvd/");
    driver.findElement(By.cssSelector("img[alt=\"Add movie\"]")).click();
    driver.findElement(By.cssSelector("input[type=\"submit\"]")).click();
    try {
      assertTrue(driver.findElement(By.cssSelector("label[for=\"imdbsearch\"][class=\"error\"]")).isDisplayed());
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    driver.findElement(By.id("imdbsearch")).clear();
    driver.findElement(By.id("imdbsearch")).sendKeys("<script>alert(\"hi\");</script>");
    driver.findElement(By.cssSelector("input[type=\"submit\"]")).click();
    WebElement note = driver.findElement(By.cssSelector("div.content"));
    //note.getAttribute("innerText");
    //WebElement note = driver.findElement(By.cssSelector("div.content/div.content/div"));
    try {
        assertTrue(note.getAttribute("innerText").matches("No movies where found."));
      } catch (Error e) {
        verificationErrors.append(e.toString());
      }
    Thread.sleep(500);
    driver.findElement(By.id("imdbsearch")).clear();
    driver.findElement(By.id("imdbsearch")).sendKeys("test");
    driver.findElement(By.cssSelector("input[type=\"submit\"]")).click();
    driver.findElement(By.linkText("American Crime Story")).click();
    driver.findElement(By.name("name")).clear();
    driver.findElement(By.name("name")).sendKeys("");
    driver.findElement(By.name("year")).clear();
    driver.findElement(By.name("year")).sendKeys("");
    driver.findElement(By.id("cover")).clear();
    driver.findElement(By.id("cover")).sendKeys("C:\\GitHub\\images\\american_crime_story.jpg");
    driver.findElement(By.cssSelector("img[alt=\"Save\"]")).click();
    //driver.findElement(By.id("submit")).click();
    try {
      assertTrue(driver.findElement(By.cssSelector("label[for=\"name\"][class=\"error\"]")).isDisplayed());
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    try {
      assertTrue(driver.findElement(By.cssSelector("label[for=\"year\"][class=\"error\"]")).isDisplayed());
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    driver.findElement(By.name("name")).clear();
    driver.findElement(By.name("name")).sendKeys("American Crime Story");
    driver.findElement(By.name("aka")).clear();
    driver.findElement(By.name("aka")).sendKeys("American Crime Story");
    try {
      assertFalse(driver.findElement(By.cssSelector("label[for=\"name\"][class=\"error\"]")).isDisplayed());
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    driver.findElement(By.name("year")).clear();
    driver.findElement(By.name("year")).sendKeys("2016");
    try {
      assertFalse(driver.findElement(By.cssSelector("label[for=\"year\"][class=\"error\"]")).isDisplayed());
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    driver.findElement(By.cssSelector("img[alt=\"Save\"]")).click();
    //driver.findElement(By.id("submit")).click();
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