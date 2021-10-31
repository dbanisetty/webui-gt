@run @search
  Feature: Validate a specific search feature in Gumtree and verify search results

    Scenario: Search Gumtree for "Sennheiser Headphones" in "Electronics & Computers" category and access search results
      Given user visits gumtree homepage
      When searches for "Sennheiser Headphones" in category "Electronics & Computer"
      And region is "Sydney Region, NSW" within 20km
      Then clicks on submit button
      When selects a random result from search results
      Then verify ad details page opens
      And verify numeric ad id is displayed
      And verify similar ad is displayed in the page


