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

public class PositiveSearch extends selenium_java_training.TestBase {
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Test
  public void testPositiveSearch() throws Exception {
    driver.get(baseUrl + "/php4dvd/");
    WebDriverWait wait =
    		new WebDriverWait(driver, 30);
    wait.until(ExpectedConditions.elementToBeClickable(By.id("q")));
    driver.findElement(By.id("q")).clear();
    wait.until(ExpectedConditions.elementToBeClickable(By.id("q")));
    WebElement nftd=driver.findElement(By.cssSelector("div.content"));
    driver.findElement(By.id("q")).sendKeys("test" + Keys.RETURN);
    wait.until(ExpectedConditions.stalenessOf(nftd));
    //wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("div.content")));
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.title")));
    WebElement note = driver.findElement(By.cssSelector("div.title"));
    Thread.sleep(500);
    try {
        assertTrue(note.getAttribute("innerText").matches("Test"));
      } catch (Error e) {
        verificationErrors.append(e.toString());
      }
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