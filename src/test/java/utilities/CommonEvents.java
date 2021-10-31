package utilities;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;


import java.util.ArrayList;

public class CommonEvents {

    private static WebDriver driver;

    private static WebDriver initiateDriver(){

        System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver");
        driver = new ChromeDriver();
        return driver;
    }

    public static WebDriver getDriver(){
        if(driver != null){
            return driver;
        }
        WebDriver driver = initiateDriver();
        return driver;
    }

    public static void closeDriver(){
        driver.quit();

    }
    public void actionsEscape(){
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.ESCAPE).build().perform();
    }

    public  void windowHandles(Integer tab_index){
        ArrayList<String> tabs_windows = new ArrayList<String> (driver.getWindowHandles());
        driver.switchTo().window(tabs_windows.get(tab_index));

    }
}
