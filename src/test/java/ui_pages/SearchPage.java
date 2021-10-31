package ui_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilities.CommonEvents;

public class SearchPage {
    static WebDriver driver = CommonEvents.getDriver();
   // static String distance;

    //locator for 'All Categories' dropdown
    static By categoryDropdown = By.id("categoryId-wrp");
    //locator for 'Electronics' category
   static By categoryValue = By.xpath("//div[@id='categoryId-wrp']//div[@id='categoryId-wrpwrapper']//ul//li//div[contains(text(),\"Electronics & Computer\")]");
    //locator for search textbox
   static By searchBox = By.xpath("//input[@id='search-query']");
    //locator for search area
    static By searchArea = By.xpath("//input[@id='search-area']");
    //locator for radiusInput
    static By radiusInputButton = By.xpath("//span[@id='srch-radius-input']");
    //locator for radius
   // By radius = By.xpath("//button[normalize-space()='"+distance+"']");
    //locator for submit search
    static By submitSearch = By.xpath("//button[@type='submit']");

    public static void selectCategory(String category){
        driver.findElement(categoryDropdown).click();
        driver.findElement(By.xpath("//div[@id='categoryId-wrp']//div[@id='categoryId-wrpwrapper']//ul//li//div[contains(text(),'"+category+"')]")).click();
    }
    public static void enterSearch(String searchText){
        driver.findElement(searchBox).sendKeys(searchText);
    }
    public static void enterSearchArea(String searchAreaText){
        driver.findElement(searchArea).sendKeys(searchAreaText);
    }
    public static void enterRadius(){
        driver.findElement(radiusInputButton).click();
        driver.findElement(By.xpath("(//div[@id='srch-radius-wrp-option-20'])")).click();
    }
    public static void setSubmitSearch(){
        driver.findElement(submitSearch).click();
    }
}
