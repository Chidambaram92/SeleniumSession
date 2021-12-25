@OrangeTest
Feature: Login Orange Test Feature

  Background: 
    Given user navigates to orange site launch page
    And verify if orange site home page is navigated

  @OrangeTest
  Scenario: SearchPage select for a particulra id
    When I verify the tabs present in Home page
      | Admin |
      | PIM   |
      | Time  |
