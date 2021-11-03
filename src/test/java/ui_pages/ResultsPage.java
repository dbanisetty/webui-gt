package ui_pages;

import org.openqa.selenium.*;
import utilities.CommonEvents;

import java.util.concurrent.TimeUnit;

public class ResultsPage {

static WebDriver driver = CommonEvents.getDriver();
static By adIdLocator = By.xpath("(//span[@class='breadcrumbs__summary'])[1]");
public static By similarAds = By.className("panel-body vip-similar-ads__slider-container");

public static void selectFirstAd(){

    ((JavascriptExecutor)driver).executeScript("window.scrollBy(0, 250)", "");
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    try {
        WebElement element = driver.findElement(By.xpath("//section[@class='search-results-page__user-ad-collection']//div/div/a"));
        element.click();
    }catch (org.openqa.selenium.StaleElementReferenceException ex){
        WebElement element = driver.findElement(By.xpath("//section[@class='search-results-page__user-ad-collection']//div/div/a"));
        element.click();
    }

}

public static String getAdId(){
    ((JavascriptExecutor)driver).executeScript("window.scrollBy(0, 250)", "");
    try {
        return driver.findElement(adIdLocator).getText();
    }catch (org.openqa.selenium.StaleElementReferenceException ex)
    {
        return driver.findElement(adIdLocator).getText();
    }
}

public static void getSimilarAds(){
    driver.findElements(similarAds);
}

}
