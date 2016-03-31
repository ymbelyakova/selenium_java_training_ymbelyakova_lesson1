package slenium_java_training_ymbelyakova;

import java.util.regex.Pattern;
import java.io.File;
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

public class FindAndAdd extends selenium_java_training.TestBase {
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Test
  public void testFindAndAdd() throws Exception {
    driver.get(baseUrl + "/php4dvd/");
    WebDriverWait wait =
    		new WebDriverWait(driver, 30);
    wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("div.title")));
    int countorig=driver.findElements(By.cssSelector("div.title")).size();
    driver.findElement(By.cssSelector("img[alt=\"Add movie\"]")).click();
    wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input[type=\"submit\"]")));
    driver.findElement(By.id("imdbsearch")).clear();
    driver.findElement(By.id("imdbsearch")).sendKeys("test");
    driver.findElement(By.cssSelector("input[type=\"submit\"]")).click();
    wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.className("title")));
    wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Test")));
    //driver.findElement(By.linkText("Test")).click();
    driver.get(baseUrl + "/php4dvd/?go=add&imdbid=2407380");
    wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.name("name")));
    driver.findElement(By.name("name")).clear();
    driver.findElement(By.name("name")).sendKeys("Test ymbelyakova");
    driver.findElement(By.name("aka")).clear();
    driver.findElement(By.name("aka")).sendKeys("Test ymbelyakova");
    driver.findElement(By.name("name")).clear();
    driver.findElement(By.name("name")).sendKeys("Test");
    driver.findElement(By.id("cover")).clear();
    File file = new File("src/test/resource/images/test_cover.jpg");
    driver.findElement(By.id("cover")).sendKeys(file.getAbsolutePath());
    /*driver.findElement(By.id("cover")).sendKeys("C:\\GitHub\\images\\test_cover.png");
    // Warning: verifyTextPresent may require manual changes
    try {
      assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*$"));
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    driver.findElement(By.id("cover")).clear();
    driver.findElement(By.id("cover")).sendKeys("C:\\GitHub\\images\\test_cover.jpg");*/
    driver.findElement(By.name("notes")).clear();
    driver.findElement(By.name("notes")).sendKeys("Personal notes test");
    driver.findElement(By.name("taglines")).clear();
    driver.findElement(By.name("taglines")).sendKeys("Taglines test");
    driver.findElement(By.name("subtitles")).clear();
    driver.findElement(By.name("subtitles")).sendKeys("Subtitles test");
    driver.findElement(By.name("country")).clear();
    driver.findElement(By.name("country")).sendKeys("UK");
    driver.findElement(By.name("genres")).clear();
    driver.findElement(By.name("genres")).sendKeys("Comedy");
    driver.findElement(By.name("director")).clear();
    driver.findElement(By.name("director")).sendKeys("Director test");
    driver.findElement(By.name("writer")).clear();
    driver.findElement(By.name("writer")).sendKeys("Writer test");
    wait.until(ExpectedConditions.elementToBeClickable(By.id("submit")));
    driver.findElement(By.id("submit")).click();
    
    wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("h1")));
    driver.findElement(By.cssSelector("h1")).click();
    wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("div.title")));
    int countres=driver.findElements(By.cssSelector("div.title")).size();
    System.out.println(countorig);
    System.out.println(countres);
    if (countres != countorig + 1) System.out.println("Something is wrong");
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
