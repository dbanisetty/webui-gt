package step_defs;

import cucumber.api.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import ui_pages.ResultsPage;
import ui_pages.SearchPage;
import utilities.CommonEvents;

import java.util.concurrent.TimeUnit;

public class UiStepDefinitions {

    WebDriver driver = CommonEvents.getDriver();
    private CommonEvents com = new CommonEvents();
    String actualTitle;

    @Given("^user visits gumtree homepage$")
    public void user_visits_gumtree_homepage(){
        driver.get("https://www.gumtree.com.au/");
        com.actionsEscape();

    }

    @When("^searches for \"([^\"]*)\" in category \"([^\"]*)\"$")
    public void searches_for_in_category(String searchText, String category){
        SearchPage.selectCategory(category);
        SearchPage.enterSearch(searchText);
    }

    @When("^region is \"([^\"]*)\" within 20km$")
    public void region_is_within(String searchArea){
        SearchPage.enterSearchArea(searchArea);
        SearchPage.enterRadius();
    }

    @Then("^clicks on submit button$")
    public void clickSubmit(){
        SearchPage.setSubmitSearch();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    @When("^selects a random result from search results$")
    public void selects_a_random_result_from_search_results(){
        ResultsPage.selectFirstAd();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    @Then("^verify ad details page opens$")
    public void verify_ad_details_page_opens(){
        String expectedTitle = "sennheiser";
        try{
        actualTitle = driver.getTitle().toLowerCase();
        System.out.println("Ad details page title is: "+ actualTitle);}
        catch (org.openqa.selenium.StaleElementReferenceException ex){
            actualTitle = driver.getTitle().toLowerCase();
            System.out.println("Ad details page title is: "+ actualTitle); }
        Assert.assertTrue(actualTitle.contains(expectedTitle));

    }

    @Then("^verify numeric ad id is displayed$")
    public void verify_numeric_ad_id_is_displayed(){
        String breadcrumbAdId = ResultsPage.getAdId();
        String breadcrumbId = breadcrumbAdId.substring(6);
        System.out.println("Numeric Breadcrumb Ad Id is : "+ breadcrumbId);
        Assert.assertTrue(actualTitle.contains(breadcrumbId));

    }

    @Then("^verify similar ad is displayed in the page$")
    public void verify_similar_ad_is_displayed_in_the_page(){
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        ((JavascriptExecutor)driver).executeScript("window.scrollBy(0, 250)", "");
        if(driver.findElements(By.xpath("//div[@class='panel-body vip-similar-ads__slider-container']")).size()!=0) {
            System.out.println("Similar Ads Exist");
        } else{
            System.out.println("Similar Ads doesn't Exist");
        }

    }
}
