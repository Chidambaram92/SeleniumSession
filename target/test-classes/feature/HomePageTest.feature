
@HomeTest @SmokeTest
Feature: Test Data Feature File

  @HomeTest
  Scenario: Get User Data Home Page Scenario
    Given user navigates to home page
    And verify home page is launched
    Then get search name "Dresses"
    