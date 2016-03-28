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

public class NewMovie extends selenium_java_training.TestBase {
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Test
  public void testNewMovie() throws Exception {
    driver.get(baseUrl + "/php4dvd/");
    driver.findElement(By.cssSelector("img[alt=\"Add movie\"]")).click();
    driver.findElement(By.name("imdbid")).clear();
    driver.findElement(By.name("imdbid")).sendKeys("9999999");
    driver.findElement(By.name("name")).click();
    try {
      assertTrue(driver.findElement(By.cssSelector("label[for=\"name\"]")).isDisplayed());
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    // Warning: verifyTextPresent may require manual changes
    try {
      assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("This field is required"));
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    driver.findElement(By.name("name")).clear();
    driver.findElement(By.name("name")).sendKeys("New Movie");
    driver.findElement(By.name("aka")).clear();
    driver.findElement(By.name("aka")).sendKeys("New Movie by Yulia Belyakova");
    driver.findElement(By.id("submit")).click();
    try {
      assertFalse(driver.findElement(By.cssSelector("label[for=\"name\"]")).isDisplayed());
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    try {
      assertTrue(driver.findElement(By.cssSelector("label[for=\"year\"]")).isDisplayed());
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    // Warning: verifyTextPresent may require manual changes
    try {
      assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("This field is required"));
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    driver.findElement(By.name("year")).clear();
    driver.findElement(By.name("year")).sendKeys("2016");
    driver.findElement(By.name("duration")).clear();
    driver.findElement(By.name("duration")).sendKeys("20");
    driver.findElement(By.name("rating")).clear();
    driver.findElement(By.name("rating")).sendKeys("10");
    driver.findElement(By.id("own_no")).click();
    driver.findElement(By.id("seen_no")).click();
    driver.findElement(By.id("loaned_yes")).click();
    driver.findElement(By.name("loanname")).clear();
    driver.findElement(By.name("loanname")).sendKeys("2016-03-29");
    driver.findElement(By.id("cover")).clear();
    driver.findElement(By.id("cover")).sendKeys("C:\\GitHub\\images\\new_movie.jpg");
    driver.findElement(By.name("trailer")).clear();
    driver.findElement(By.name("trailer")).sendKeys("https://www.youtube.com/watch?v=ap_avaJApm8");
    driver.findElement(By.name("notes")).clear();
    driver.findElement(By.name("notes")).sendKeys("Personal notes test");
    driver.findElement(By.name("taglines")).clear();
    driver.findElement(By.name("taglines")).sendKeys("Taglines test");
    driver.findElement(By.name("plotoutline")).clear();
    driver.findElement(By.name("plotoutline")).sendKeys("Plot outline test");
    driver.findElement(By.name("plots")).clear();
    driver.findElement(By.name("plots")).sendKeys("Plots test");
    driver.findElement(By.id("text_languages_0")).clear();
    driver.findElement(By.id("text_languages_0")).sendKeys("EN, RU");
    driver.findElement(By.name("subtitles")).clear();
    driver.findElement(By.name("subtitles")).sendKeys("Subtitles test");
    driver.findElement(By.name("audio")).clear();
    driver.findElement(By.name("audio")).sendKeys("Audio test");
    driver.findElement(By.name("video")).clear();
    driver.findElement(By.name("video")).sendKeys("Video test");
    driver.findElement(By.name("country")).clear();
    driver.findElement(By.name("country")).sendKeys("RU");
    driver.findElement(By.name("genres")).clear();
    driver.findElement(By.name("genres")).sendKeys("Comedy");
    driver.findElement(By.name("director")).clear();
    driver.findElement(By.name("director")).sendKeys("Director test");
    driver.findElement(By.name("writer")).clear();
    driver.findElement(By.name("writer")).sendKeys("Writer test");
    driver.findElement(By.name("producer")).clear();
    driver.findElement(By.name("producer")).sendKeys("Producer test");
    driver.findElement(By.name("music")).clear();
    driver.findElement(By.name("music")).sendKeys("Music test");
    driver.findElement(By.name("cast")).clear();
    driver.findElement(By.name("cast")).sendKeys("Cast test");
    driver.findElement(By.id("submit")).click();
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
