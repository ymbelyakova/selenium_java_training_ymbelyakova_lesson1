package selenium_java_training.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;

import static org.openqa.selenium.support.ui.ExpectedConditions.*;

public class AddPage extends InternalPage {

    public AddPage(PageManager pages) {
        super(pages);
    }

    @FindBy(name = "name")
    private WebElement title;

    @FindBy(name = "year")
    private WebElement year;

    @FindBy(name = "submit")
    private WebElement submit;

    @FindBy(css = "input.error")
    private WebElement requiredFild;
    
  /*  @FindBy(name="imdbid")
    private WebElement imdbid;
    
    @FindBy(name="duration")
    private WebElement duration;
    
    @FindBy(name="aka")
    private WebElement aka;
    
    @FindBy(name="rating")
    private WebElement rating; */

    public WebElement getRequiredFild() {
        return requiredFild;
    }
 
  /*  public void setImdbid(String text) {
    	imdbid.clear();
    	imdbid.sendKeys(text);
    } */
    
    public void setTitle(String titletext) {
        title.clear();
        title.sendKeys(titletext);
    }

 /*   public void setAka(String text) {
    	aka.clear();
        aka.sendKeys(text);
    } */
    
    public void setYear(String text) {
        year.clear();
        year.sendKeys(text);
    }
    
 /*   public void setDuration(String text) {
    	duration.clear();
        duration.sendKeys(text);
    }

    public void setRating(String text) {
        rating.clear();
        rating.sendKeys(text);
    } */
     
    public void clickSubmit() {
        submit.click();
        super.ensurePageLoaded();
    }

    public AddPage ensurePageLoaded() {
        super.ensurePageLoaded();
        wait.until(presenceOfElementLocated(By.id("imdbsearchform")));
        return this;
    }


}
