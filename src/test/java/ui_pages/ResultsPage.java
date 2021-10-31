package ui_pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import utilities.CommonEvents;

public class ResultsPage {
    static WebDriver driver = CommonEvents.getDriver();

static By firstAd = By.cssSelector(".user-ad-square-new-design:nth-child(1)");
static By adIdLocator = By.xpath("(//span[@class='breadcrumbs__summary'])[1]");
public static By similarAds = By.className("panel-body vip-similar-ads__slider-container");

public static void selectFirstAd(){
    WebElement firstAds = driver.findElement(firstAd);
    ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);",firstAds);
    firstAds.click();

    WebElement element = driver.findElement(firstAd);
    Actions actions = new Actions(driver);
    actions.moveToElement(element).build().perform();

    Actions ac = new Actions(driver);
    ac.sendKeys(Keys.ESCAPE).build().perform();
}

public static String getAdId(){
    return driver.findElement(adIdLocator).getText();
}

public static void getSimilarAds(){
    driver.findElements(similarAds);
}


}
