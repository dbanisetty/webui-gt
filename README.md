
== WebUI tests with selenium webdriver  ==

# prerequisites
Java
apache maven installed
set java home and m2 home in system env variables


# run in cli
mvn clean verify

# run specific scenario(by tag name)
mvn clean verify -Dcucumber.options="--tags @search"

# reporting
used Serenity bdd for reporting
reports can be found under "target" ->"site"->"serenity"->"index.html"
# Test Execution Report
Scenario
![image](https://user-images.githubusercontent.com/48619025/139586941-d097e8bb-dcc7-4545-8342-c6558409680e.png)
Steps
![image](https://user-images.githubusercontent.com/48619025/139586955-a2e592cf-5967-4351-9f14-8d44a419f917.png)


# Test summary
Framework tests the ability of searching an item, selecting and verifying for similar Ads
can run for multiple search items by simply extending cucumber scenarios into "Scenario Outline" data tables
utilised page object model with getters, setters and methods to invoke step definitions

#Limitations
- noticed chromedriver and chrome browser version mismatch could end up in not loading browser until chromedriver version is matched
  version number is displayed in error message - "this version of chromedriver only supports chrome version xxx selenium"
  follow below steps to fix it
  . brew cask upgrade chromedriver - this command will upgrade chromedriver
  OR 
  manually download chrome from driver downloads - https://sites.google.com/a/chromium.org/chromedriver/downloads
  and select the desired version
   
- Occasionally tests fails with Stale Element reference error from second page after submitting search
  . This i suspect Elements from the page were removed from DOM due to page refresh (second time after loading/ or while loading)
  . Have overcome using try catch block 
  

#Improvements
- used actions api "ESCAPE" to dismiss model dialog on page load. However it's nice to handle using switch window (get window handle)
- Implicit wait has been used, however better to use wait.until expectedCondition

