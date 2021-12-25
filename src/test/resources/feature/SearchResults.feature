@SearchTest @SmokeTest
Feature: Search Test results scenario

  Background: 
    Given user navigates to home page

  @Smoke @SearchTest
  Scenario Outline: Title of your scenario outline
    Given user wants to search for "<searchkey>" in search header
    When user check for the "<searchResults>" in search list of particular category
    And verify if footer news letter is loaded in search results page
    Then user verify the "<footerSection>" value in footer section

    Examples: 
      | searchkey | searchResults                    | footerSection |
      | Dresses   | Casual Dresses > Printed Dress   | Specials      |
      | Shirts    | T-shirts > Faded Short Sleeve T- | Best sellers  |
